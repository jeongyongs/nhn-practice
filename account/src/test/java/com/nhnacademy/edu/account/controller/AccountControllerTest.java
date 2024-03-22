package com.nhnacademy.edu.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.account.domain.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void getAccounts() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", equalTo(1)));
    }

    @Test
    @Order(2)
    void getAccount() throws Exception {
        mockMvc.perform(get("/accounts/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(1)));
    }

    @Test
    @Order(3)
    void createAccount() throws Exception {
        Account account = new Account(1234L, "222-2222-222222", 30000);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(1234)));
    }

    @Test
    @Order(4)
    void deleteAccount() throws Exception {
        mockMvc.perform(delete("/accounts/{id}", 1))
                .andExpect(status().isOk());
    }

}
