package com.nhnacademy.edu.account.controller;

import com.nhnacademy.edu.account.domain.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerRandomPortTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @Order(1)
    void getAccounts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Account> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<List<Account>> responseEntity = testRestTemplate.exchange(
                "/accounts",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<>() {
                }
        );

        assertThat(responseEntity.getBody())
                .contains(new Account(1L, null, 0));
    }

    @Test
    @Order(2)
    void getAccount() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Account> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Account> responseEntity = testRestTemplate.getForEntity(
                "/accounts/{id}",
                Account.class,
                1
        );

        assertThat(responseEntity.getBody())
                .isEqualTo(new Account(1L, null, 0));
    }

}
