package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.*;
import com.enesbayram.gallerist.exception.BaseException;
import com.enesbayram.gallerist.exception.ErrorMessage;
import com.enesbayram.gallerist.exception.MessageType;
import com.enesbayram.gallerist.model.Car;
import com.enesbayram.gallerist.model.Gallerist;
import com.enesbayram.gallerist.model.GalleristCar;
import com.enesbayram.gallerist.repository.CarRepository;
import com.enesbayram.gallerist.repository.GalleristCarRepository;
import com.enesbayram.gallerist.repository.GalleristRepository;
import com.enesbayram.gallerist.service.IGalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

    @Autowired
    private GalleristCarRepository galleristCarRepository;

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private CarRepository carRepository;

    private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

        Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
        if (optGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(dtoGalleristCarIU.getGalleristId().toString(), MessageType.NO_RECORD_EXIST));
        }

        Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
        if (optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(dtoGalleristCarIU.getCarId().toString(), MessageType.NO_RECORD_EXIST));
        }

        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoGalleristCarIU, galleristCar);

        galleristCar.setGallerist(optGallerist.get());
        galleristCar.setCar(optCar.get());

        return galleristCar;
    }

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {

        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();

        DtoAddress dtoAddress = new DtoAddress();

        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));

        BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);

        BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);

        dtoGallerist.setAddress(dtoAddress);

        dtoGalleristCar.setGallerist(dtoGallerist);
        dtoGalleristCar.setCar(dtoCar);

        return dtoGalleristCar;
    }
}
