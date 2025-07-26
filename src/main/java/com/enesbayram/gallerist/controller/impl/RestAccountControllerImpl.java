package com.enesbayram.gallerist.controller.impl;

import com.enesbayram.gallerist.controller.IRestAccountController;
import com.enesbayram.gallerist.controller.RestBaseController;
import com.enesbayram.gallerist.controller.RootEntity;
import com.enesbayram.gallerist.dto.DtoAccount;
import com.enesbayram.gallerist.dto.DtoAccountIU;
import com.enesbayram.gallerist.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoAccount> updateAccount(@PathVariable Long id, @Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.updateAccount(id, dtoAccountIU));
    }

}
