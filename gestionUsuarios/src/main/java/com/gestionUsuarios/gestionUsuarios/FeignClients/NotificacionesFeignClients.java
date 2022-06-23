package com.gestionUsuarios.gestionUsuarios.FeignClients;


import com.gestionUsuarios.gestionUsuarios.models.CrearNotificacionDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseCreaNotDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "notificaciones-service", url="http://localhost:8085", path = "gestion/notificaciones/v1")
public interface NotificacionesFeignClients {
    @PostMapping(value = "/creaNotificacion")
    ResponseCreaNotDTO creaNotificacion(@RequestBody CrearNotificacionDTO creaNot);
}
