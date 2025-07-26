package com.enesbayram.gallerist.dto;

import com.enesbayram.gallerist.model.Account;
import com.enesbayram.gallerist.model.Address;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomer extends DtoBase {

    private String firstName;

    private String lastName;

    private String tckn;

    private Date birthOfDate;

    private DtoAddress address;

    private DtoAccount account;
}
