package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.DtoAccountIU;
import com.enesbayram.gallerist.dto.DtoCar;
import com.enesbayram.gallerist.dto.DtoCarIU;
import com.enesbayram.gallerist.model.Car;
import com.enesbayram.gallerist.repository.CarRepository;
import com.enesbayram.gallerist.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCarIU, car);

        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();

        Car savedCar = carRepository.save(createCar(dtoCarIU));

        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }
}
