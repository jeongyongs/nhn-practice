package com.nhnacademy.edu.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.account.domain.Account;
import com.nhnacademy.edu.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerMockBeanTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountRepository accountRepository;

    @Test
    void getAccounts() throws Exception {
        given(accountRepository.findAll()).willReturn(List.of(
                new Account(1L, null, 0),
                new Account(2L, null, 0),
                new Account(3L, null, 0)));

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", equalTo(1)));
    }

    @Test
    void getAccount() throws Exception {
        given(accountRepository.findById(any())).willReturn(Optional.of(new Account(1L, null, 0)));

        mockMvc.perform(get("/accounts/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(1)));
    }

    @Test
    void postAccount() throws Exception {
        Account account = new Account(10L, null, 0);
        given(accountRepository.existsById(any())).willReturn(false);
        given(accountRepository.save(any())).willReturn(account);

        mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(account)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(10)));
    }

    @Test
    void deleteAccount() throws Exception {
        mockMvc.perform(delete("/accounts/{id}", 1))
                .andExpect(status().isOk());
    }
}
