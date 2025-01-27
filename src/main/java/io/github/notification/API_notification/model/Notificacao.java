package io.github.notification.API_notification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacao")
@Getter
@Setter
@NoArgsConstructor
public class Notificacao {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime horario;
    private String destinatario;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "envioId")
    private Envio envio;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    public Notificacao(LocalDateTime horario, String destinatario, String mensagem, Envio envio, Status status){
        this.horario = horario;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.envio = envio;
        this.status = status;

    }
}
