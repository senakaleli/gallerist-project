package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.DtoAccount;
import com.enesbayram.gallerist.dto.DtoAddress;
import com.enesbayram.gallerist.dto.DtoCustomer;
import com.enesbayram.gallerist.dto.DtoCustomerIU;
import com.enesbayram.gallerist.exception.BaseException;
import com.enesbayram.gallerist.exception.ErrorMessage;
import com.enesbayram.gallerist.exception.MessageType;
import com.enesbayram.gallerist.model.Account;
import com.enesbayram.gallerist.model.Address;
import com.enesbayram.gallerist.model.Customer;
import com.enesbayram.gallerist.repository.AccountRepository;
import com.enesbayram.gallerist.repository.AddressRepository;
import com.enesbayram.gallerist.repository.CustomerRepository;
import com.enesbayram.gallerist.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU){

        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(dtoCustomerIU.getAddressId().toString(), MessageType.NO_RECORD_EXIST));
        }
        
        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if (optAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(dtoCustomerIU.getAccountId().toString(), MessageType.NO_RECORD_EXIST));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);

        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer =new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }
}
