package io.github.notification.API_notification.repository;

import io.github.notification.API_notification.model.Notificacao;
import io.github.notification.API_notification.model.Status;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByStatusInAndHorarioBefore(List<Status> status, LocalDateTime horario);
}
