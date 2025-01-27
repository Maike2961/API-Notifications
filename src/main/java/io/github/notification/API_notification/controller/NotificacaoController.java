package io.github.notification.API_notification.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.notification.API_notification.DTO.notificationDTO;
import io.github.notification.API_notification.model.Notificacao;
import io.github.notification.API_notification.service.NotificacaoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/notification")
public class NotificacaoController {


    @Autowired
    private NotificacaoService service;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody notificationDTO dto) {
        
        service.salvar(dto);
        
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterID(@PathVariable("id") Long id) {
        Optional<Notificacao> byId = service.findById(id);

        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarNotificacao(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
