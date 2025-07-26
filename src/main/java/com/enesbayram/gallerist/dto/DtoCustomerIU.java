package com.enesbayram.gallerist.dto;

import com.enesbayram.gallerist.model.Account;
import com.enesbayram.gallerist.model.Address;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomerIU {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String tckn;

    @NotNull
    private Date birthOfDate;

    @NotNull
    private Long addressId;

    @NotNull
    private Long accountId;
}
