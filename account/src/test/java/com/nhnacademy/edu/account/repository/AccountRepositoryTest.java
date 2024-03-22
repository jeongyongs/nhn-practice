package com.nhnacademy.edu.account.repository;

import com.nhnacademy.edu.account.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void findById() {
        long id = 1L;
        Account account = new Account(id, "111-1111-111111", 10_000);
        entityManager.merge(account);

        Optional<Account> actual = accountRepository.findById(id);

        assertThat(actual)
                .isPresent()
                .contains(account);
    }

}
