package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoCar;
import com.enesbayram.gallerist.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
