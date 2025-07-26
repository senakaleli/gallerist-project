package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.DtoAddress;
import com.enesbayram.gallerist.dto.DtoGallerist;
import com.enesbayram.gallerist.dto.DtoGalleristIU;
import com.enesbayram.gallerist.exception.BaseException;
import com.enesbayram.gallerist.exception.ErrorMessage;
import com.enesbayram.gallerist.exception.MessageType;
import com.enesbayram.gallerist.model.Address;
import com.enesbayram.gallerist.model.Gallerist;
import com.enesbayram.gallerist.repository.AddressRepository;
import com.enesbayram.gallerist.repository.GalleristRepository;
import com.enesbayram.gallerist.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

        Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(dtoGalleristIU.getAddressId().toString(), MessageType.NO_RECORD_EXIST));
        }

        Gallerist gallerist = new Gallerist();
        gallerist.setCreateTime(new Date());


        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setAddress(optAddress.get());

        return gallerist;
    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);
        return dtoGallerist;
    }
}
