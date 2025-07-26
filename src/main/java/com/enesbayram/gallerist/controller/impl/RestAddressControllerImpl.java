package com.enesbayram.gallerist.controller.impl;

import com.enesbayram.gallerist.controller.IRestAddressController;
import com.enesbayram.gallerist.controller.RestBaseController;
import com.enesbayram.gallerist.controller.RootEntity;
import com.enesbayram.gallerist.dto.DtoAddress;
import com.enesbayram.gallerist.dto.DtoAddressIU;
import com.enesbayram.gallerist.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.saveAddress(dtoAddressIU));
    }
}
