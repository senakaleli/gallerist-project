package com.enesbayram.gallerist.dto;

import com.enesbayram.gallerist.enums.CarStatusType;
import com.enesbayram.gallerist.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoCar extends DtoBase {

    private String plaka;

    private String brand;

    private String model;

    private Integer productionYear;

    private BigDecimal price;

    private CurrencyType currencyType;

    private BigDecimal damagePrice;

    private CarStatusType carStatusType;
}
