package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.DtoCar;
import com.enesbayram.gallerist.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
