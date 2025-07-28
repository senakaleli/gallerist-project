package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoAccount;
import com.enesbayram.gallerist.dto.DtoAccountIU;
import jakarta.persistence.criteria.Root;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

    public RootEntity<DtoAccount> updateAccount(Long id, DtoAccountIU dtoAccountIU);

    public RootEntity<String> deleteAccount(Long id);
}
