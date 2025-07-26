package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoGalleristCar;
import com.enesbayram.gallerist.dto.DtoGalleristCarIU;
import com.enesbayram.gallerist.dto.DtoGalleristIU;

public interface IRestGalleristCarController {

    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
