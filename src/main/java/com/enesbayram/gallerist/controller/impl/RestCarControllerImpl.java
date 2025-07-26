package com.enesbayram.gallerist.controller.impl;

import com.enesbayram.gallerist.controller.IRestCarController;
import com.enesbayram.gallerist.controller.RestBaseController;
import com.enesbayram.gallerist.controller.RootEntity;
import com.enesbayram.gallerist.dto.DtoCar;
import com.enesbayram.gallerist.dto.DtoCarIU;
import com.enesbayram.gallerist.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
}
