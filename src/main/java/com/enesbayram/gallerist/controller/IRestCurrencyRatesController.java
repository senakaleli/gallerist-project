package com.enesbayram.gallerist.controller;

import com.enesbayram.gallerist.dto.CurrencyRatesResponse;

public interface IRestCurrencyRatesController {

    public RootEntity<CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
