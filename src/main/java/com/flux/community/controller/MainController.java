package com.flux.community.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public Mono<HealthCheck> healthyCheck() {
        return Mono.just(new HealthCheck());
    }

    @Data
    private static class HealthCheck {
        private LocalDateTime time = LocalDateTime.now();
        private boolean status = true;
    }
}
