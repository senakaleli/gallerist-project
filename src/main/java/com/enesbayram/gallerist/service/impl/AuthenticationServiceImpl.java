package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.AuthRequest;
import com.enesbayram.gallerist.dto.AuthResponse;
import com.enesbayram.gallerist.dto.DtoUser;
import com.enesbayram.gallerist.dto.RefreshTokenRequest;
import com.enesbayram.gallerist.exception.BaseException;
import com.enesbayram.gallerist.exception.ErrorMessage;
import com.enesbayram.gallerist.exception.MessageType;
import com.enesbayram.gallerist.jwt.JWTService;
import com.enesbayram.gallerist.model.RefreshToken;
import com.enesbayram.gallerist.model.User;
import com.enesbayram.gallerist.repository.RefreshTokenRepository;
import com.enesbayram.gallerist.repository.UserRepository;
import com.enesbayram.gallerist.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();

        User savedUser = userRepository.save(createUser(input));

        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optUser = userRepository.findByUsername(input.getUsername());
            String accessToken = jwtService.generateToken(optUser.get());

            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());

        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(e.getMessage(), MessageType.USERNAME_OR_PASSWORD_INVALID));
        }
    }

    public boolean isValidRefreshToken(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {
        Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
        if (optRefreshToken.isEmpty()) {
            throw new BaseException(new ErrorMessage(input.getRefreshToken(), MessageType.REFRESH_TOKEN_NOT_FOUND));
        }

        if (!isValidRefreshToken(optRefreshToken.get().getExpiredDate())) {
            throw new BaseException(new ErrorMessage(input.getRefreshToken(), MessageType.REFRESH_TOKEN_IS_EXPIRED));
        }

        User user = optRefreshToken.get().getUser();
        String accessToken = jwtService.generateToken(user);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }
}
