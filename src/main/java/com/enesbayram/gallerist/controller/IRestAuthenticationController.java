package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.AuthRequest;
import com.enesbayram.gallerist.dto.AuthResponse;
import com.enesbayram.gallerist.dto.DtoUser;
import com.enesbayram.gallerist.dto.RefreshTokenRequest;
import jakarta.persistence.criteria.Root;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
