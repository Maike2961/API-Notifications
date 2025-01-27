package io.github.notification.API_notification.DTO;

import java.time.LocalDateTime;

import io.github.notification.API_notification.enums.EnvioEnum;
import io.github.notification.API_notification.enums.StatusEnum;
import io.github.notification.API_notification.model.Notificacao;

public record notificationDTO(LocalDateTime data, 
                            String destinatario,
                            String mensagem,
                            EnvioEnum envio) {


    public Notificacao toNotificacao(){
        return new Notificacao(
            this.data,
            this.destinatario,
            this.mensagem,
            this.envio.toEnvio(),
            StatusEnum.PENDENTE.toStatus()
        );
    }
    
}
