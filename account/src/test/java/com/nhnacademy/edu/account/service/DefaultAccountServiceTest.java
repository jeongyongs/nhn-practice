package com.nhnacademy.edu.account.service;

import com.nhnacademy.edu.account.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DefaultAccountServiceTest {
    @Autowired
    AccountService accountService;

    @Test
    void getAccounts() {
        List<Account> actual = accountService.getAccounts();

        Assertions.assertThat(actual).hasSizeGreaterThan(1);
    }
}
