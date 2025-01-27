package io.github.notification.API_notification.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.notification.API_notification.DTO.notificationDTO;
import io.github.notification.API_notification.enums.StatusEnum;
import io.github.notification.API_notification.model.Notificacao;
import io.github.notification.API_notification.repository.NotificacaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public void salvar(notificationDTO dto) {
        repository.save(dto.toNotificacao());
    }

    public Optional<Notificacao> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long notificationId) {
        Optional<Notificacao> byId = findById(notificationId);

        if (byId.isPresent()) {
            byId.get().setStatus(StatusEnum.CANCELADO.toStatus());
            repository.save(byId.get());
        }
    }

    public void checkAndSend(LocalDateTime horario){
        List<Notificacao> notifications = repository.findByStatusInAndHorarioBefore(List.of(
                    StatusEnum.PENDENTE.toStatus(),
                    StatusEnum.ERRO.toStatus()), horario);
        
        notifications.forEach(t -> {
            t.setStatus(StatusEnum.SUCESSO.toStatus());
            repository.save(t);
        });
    }


}
