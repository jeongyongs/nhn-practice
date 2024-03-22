package com.nhnacademy.edu.account.controller;

import com.nhnacademy.edu.account.indicator.CustomHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthController {
    private final CustomHealthIndicator customHealthIndicator;

    @PostMapping("/management/fail")
    public String set() {
        customHealthIndicator.setShutdown(true);

        return "ok";
    }
}
