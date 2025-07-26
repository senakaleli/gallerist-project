package com.enesbayram.gallerist.dto;

import com.enesbayram.gallerist.model.Car;
import com.enesbayram.gallerist.model.Gallerist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleristCar extends DtoBase {

    private DtoGallerist gallerist;

    private DtoCar car;
}
