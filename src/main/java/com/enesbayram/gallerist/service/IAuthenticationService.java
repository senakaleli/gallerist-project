package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.AuthRequest;
import com.enesbayram.gallerist.dto.AuthResponse;
import com.enesbayram.gallerist.dto.DtoUser;
import com.enesbayram.gallerist.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
