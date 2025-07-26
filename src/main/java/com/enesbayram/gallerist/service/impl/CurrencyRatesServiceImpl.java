package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.CurrencyRatesResponse;
import com.enesbayram.gallerist.exception.BaseException;
import com.enesbayram.gallerist.exception.ErrorMessage;
import com.enesbayram.gallerist.exception.MessageType;
import com.enesbayram.gallerist.service.ICurrencyRatesService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRatesService {


    @Override
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
        String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
        String series = "TP.DK.USD.A.YTL";
        String type = "json";

        String endPoint = rootURL+"series="+series+"&startDate="+startDate+"&endDate="+endDate+"&type="+type;

        //https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A.YTL&startDate=23-07-2025&endDate=23-07-2025&type=json

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", "b5KTwQoz8I");

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<CurrencyRatesResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<CurrencyRatesResponse>() {
            });
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(e.getMessage(), MessageType.CURRENCY_RATES_IS_OCCURED));
        }
        return null;
    }
}
