package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoSaledCar;
import com.enesbayram.gallerist.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
