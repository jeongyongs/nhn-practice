package com.nhnacademy.edu.account.repository;

import com.nhnacademy.edu.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
}