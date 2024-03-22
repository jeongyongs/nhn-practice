package com.nhnacademy.edu.account.service;

import com.nhnacademy.edu.account.domain.Account;
import com.nhnacademy.edu.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "번 계좌가 존재하지 않습니다."));
    }

    @Override
    public Account createAccount(Account account) {
        if (accountRepository.existsById(account.getId())) {
            throw new IllegalStateException("이미 존재하는 계좌입니다.");
        }
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
