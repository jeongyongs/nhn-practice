package com.nhnacademy.edu.account.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "count")
public class CountEndpoint {
    @ReadOperation
    public Long read() {
        return 1L;
    }
}
