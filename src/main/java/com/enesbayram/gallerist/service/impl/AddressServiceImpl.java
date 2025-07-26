package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.DtoAddress;
import com.enesbayram.gallerist.dto.DtoAddressIU;
import com.enesbayram.gallerist.model.Address;
import com.enesbayram.gallerist.repository.AddressRepository;
import com.enesbayram.gallerist.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();

        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }
}
