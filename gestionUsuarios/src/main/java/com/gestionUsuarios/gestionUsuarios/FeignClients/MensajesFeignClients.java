package com.gestionUsuarios.gestionUsuarios.FeignClients;

import com.gestionUsuarios.gestionUsuarios.models.ConsultaMensajesDTO;
import com.gestionUsuarios.gestionUsuarios.models.CrearMensajeDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseMensajeDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(name = "mensajes-service", url="http://localhost:8083", path = "gestion/mensajes/v1")
public interface MensajesFeignClients {

    @PostMapping(value = "/crearMensaje")
    ResponseMensajeDTO creaMensajes(@RequestBody CrearMensajeDTO menNuevo);

    @GetMapping(value = "/consultarMensajes/{id}")
    List<ConsultaMensajesDTO> consultaMensajes(@PathVariable(required = true) Integer id);

}
