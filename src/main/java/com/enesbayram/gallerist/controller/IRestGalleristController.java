package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.DtoGallerist;
import com.enesbayram.gallerist.dto.DtoGalleristIU;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
