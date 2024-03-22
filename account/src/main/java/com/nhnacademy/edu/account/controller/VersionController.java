package com.nhnacademy.edu.account.controller;

import com.nhnacademy.edu.account.dto.Version;
import com.nhnacademy.edu.account.properties.VersionProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VersionController {
    private final VersionProperties versionProperties;

    @GetMapping("/system/version")
    public Version getVersion() {
        return new Version(versionProperties.getVersion());
    }
}
