package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.DtoGalleristCar;
import com.enesbayram.gallerist.dto.DtoGalleristCarIU;

public interface IGalleristCarService {

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
