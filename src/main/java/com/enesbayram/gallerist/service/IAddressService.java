package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.DtoAddress;
import com.enesbayram.gallerist.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
