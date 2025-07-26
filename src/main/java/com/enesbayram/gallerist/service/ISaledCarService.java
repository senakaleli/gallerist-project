package com.enesbayram.gallerist.service;


import com.enesbayram.gallerist.dto.DtoSaledCar;
import com.enesbayram.gallerist.dto.DtoSaledCarIU;

public interface ISaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
