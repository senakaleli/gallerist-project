package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.DtoCustomer;
import com.enesbayram.gallerist.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
