package com.enesbayram.gallerist.controller.impl;

import com.enesbayram.gallerist.controller.IRestGalleristController;
import com.enesbayram.gallerist.controller.RestBaseController;
import com.enesbayram.gallerist.controller.RootEntity;
import com.enesbayram.gallerist.dto.DtoGallerist;
import com.enesbayram.gallerist.dto.DtoGalleristIU;
import com.enesbayram.gallerist.service.IGalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController {

    @Autowired
    private IGalleristService galleristService;
    

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }
}
