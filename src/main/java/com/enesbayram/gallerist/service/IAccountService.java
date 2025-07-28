package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.DtoAccount;
import com.enesbayram.gallerist.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

    public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU);

    public void deleteAccount(Long id);
}
