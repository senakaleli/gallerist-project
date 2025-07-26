package com.enesbayram.gallerist.dto;

import com.enesbayram.gallerist.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoAccount extends DtoBase{

    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
