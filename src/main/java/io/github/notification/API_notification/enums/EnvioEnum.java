package io.github.notification.API_notification.enums;

import io.github.notification.API_notification.model.Envio;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnvioEnum {
    EMAIL(1L, "email"),
    SMS(2L, "sms"),
    WHATSAPP(3L, "whatsapp");

    private Long id;
    private String descricao;

    public Envio toEnvio(){
        return new Envio(this.id, this.descricao);
    }
}
