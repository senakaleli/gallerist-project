package com.enesbayram.gallerist.service;

import com.enesbayram.gallerist.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {

    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}
