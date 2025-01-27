package io.github.notification.API_notification.enums;

import io.github.notification.API_notification.model.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusEnum {
    PENDENTE(1L, "pendente"),
    CANCELADO(2L, "cancelado"),
    SUCESSO(3L, "sucesso"),
    ERRO(4L, "erro");

    private Long id;
    private String descricao;

    public Status toStatus(){
        return new Status(this.id, this.descricao);
    }
}
