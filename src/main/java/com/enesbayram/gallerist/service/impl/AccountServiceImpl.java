package com.enesbayram.gallerist.service.impl;

import com.enesbayram.gallerist.dto.DtoAccount;
import com.enesbayram.gallerist.dto.DtoAccountIU;
import com.enesbayram.gallerist.exception.BaseException;
import com.enesbayram.gallerist.exception.ErrorMessage;
import com.enesbayram.gallerist.exception.MessageType;
import com.enesbayram.gallerist.model.Account;
import com.enesbayram.gallerist.repository.AccountRepository;
import com.enesbayram.gallerist.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU dtoAccountIU){
        Account account = new Account();
        account.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAccountIU, account);
        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();

        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount,  dtoAccount);
        return dtoAccount;
    }

    @Override
    public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU) {

        Optional<Account> optAccount = accountRepository.findById(id);
        if (optAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(id.toString(), MessageType.RECORD_NOT_FOUND_WITH_THIS_ID));
        }
        Account existingAccount = optAccount.get();

        Date createTime = existingAccount.getCreateTime();


        existingAccount.setAccountNo(dtoAccountIU.getAccountNo());
        existingAccount.setIban(dtoAccountIU.getIban());
        existingAccount.setAmount(dtoAccountIU.getAmount());
        existingAccount.setCurrencyType(dtoAccountIU.getCurrencyType());
        existingAccount.setCreateTime(createTime);

        Account updatedAccount = accountRepository.save(existingAccount);

        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(updatedAccount, dtoAccount);

        return dtoAccount;
    }

}
