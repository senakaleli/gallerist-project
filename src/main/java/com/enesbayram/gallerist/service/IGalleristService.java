package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.DtoGallerist;
import com.enesbayram.gallerist.dto.DtoGalleristIU;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
