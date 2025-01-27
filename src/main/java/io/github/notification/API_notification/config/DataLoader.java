package io.github.notification.API_notification.config;

import io.github.notification.API_notification.enums.EnvioEnum;
import io.github.notification.API_notification.enums.StatusEnum;
import io.github.notification.API_notification.repository.EnvioRepository;
import io.github.notification.API_notification.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(EnvioEnum.values()).map(EnvioEnum::toEnvio).forEach(envioRepository::save);

        Arrays.stream(StatusEnum.values()).map(StatusEnum::toStatus).forEach(statusRepository::save);

    }
}
