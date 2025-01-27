package io.github.notification.API_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class  ApiNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNotificationApplication.class, args);
	}

}
