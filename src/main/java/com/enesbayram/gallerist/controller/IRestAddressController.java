package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoAddress;
import com.enesbayram.gallerist.dto.DtoAddressIU;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
