package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoCustomer;
import com.enesbayram.gallerist.dto.DtoCustomerIU;

public interface IRestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
