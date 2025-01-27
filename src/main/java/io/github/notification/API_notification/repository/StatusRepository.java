package io.github.notification.API_notification.repository;

import io.github.notification.API_notification.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
