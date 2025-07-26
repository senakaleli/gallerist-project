package com.enesbayram.gallerist.controller.impl;

import com.enesbayram.gallerist.controller.IRestCurrencyRatesController;
import com.enesbayram.gallerist.controller.RestBaseController;
import com.enesbayram.gallerist.controller.RootEntity;
import com.enesbayram.gallerist.dto.CurrencyRatesResponse;
import com.enesbayram.gallerist.service.ICurrencyRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {

    @Autowired
    private ICurrencyRatesService currencyRatesService;

    @GetMapping("/currency-rates")
    @Override
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {

        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }
}
