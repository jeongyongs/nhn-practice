package com.nhnacademy.edu.account.service;

import com.nhnacademy.edu.account.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccountById(Long id);

    Account createAccount(Account account);

    void deleteAccount(Long id);
}
