package com.gestionMensajes.gestionMensajes.controllers;

import com.gestionMensajes.gestionMensajes.models.ConsultaMensajesDTO;
import com.gestionMensajes.gestionMensajes.models.CrearMensajeDTO;
import com.gestionMensajes.gestionMensajes.models.ResponseMensajeDTO;
import com.gestionMensajes.gestionMensajes.services.GestionMensajesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("gestion/mensajes/v1")
public class GestionMensajesControllers {

    private static final Logger log = LoggerFactory.getLogger(GestionMensajesControllers.class);

    @Autowired
    private GestionMensajesService gestionMensajesSvc;

    @PostMapping(value = "/crearMensaje")
    public ResponseEntity<ResponseMensajeDTO> creaMensasje(@RequestBody CrearMensajeDTO menNuevo){
        log.info("Inicia proceso de envio de mensajes");
        return new ResponseEntity<ResponseMensajeDTO>(gestionMensajesSvc.mensajeNuevo(menNuevo), OK);
    }
    @GetMapping(value = "/consultarMensajes/{id}")
    public ResponseEntity<List<ConsultaMensajesDTO>> consultaMensajes(@PathVariable(required = true) Integer id){
        log.info("Inicia proceso de recuperar mensajes");
        return new ResponseEntity<>(gestionMensajesSvc.consultarMensajes(id), OK);
    }
}
