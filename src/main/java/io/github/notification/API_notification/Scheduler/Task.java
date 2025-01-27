package io.github.notification.API_notification.Scheduler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.github.notification.API_notification.service.NotificacaoService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Task {

    private final NotificacaoService service;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTask(){
        LocalDateTime now = LocalDateTime.now();
        service.checkAndSend(now);
    }
}
