package com.nhnacademy.edu.account.indicator;

import lombok.Setter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Setter
@Component
public class CustomHealthIndicator implements HealthIndicator {
    private Boolean shutdown;

    @Override
    public Health health() {
        if (Boolean.FALSE.equals(shutdown)) {
            return Health.up().build();
        }
        return Health.down().build();
    }
}
