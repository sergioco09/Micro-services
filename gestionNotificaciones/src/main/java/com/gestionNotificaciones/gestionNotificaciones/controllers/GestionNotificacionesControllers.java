package com.gestionNotificaciones.gestionNotificaciones.controllers;

import com.gestionNotificaciones.gestionNotificaciones.models.CrearNotificacionDTO;
import com.gestionNotificaciones.gestionNotificaciones.models.ResponseCreaNotDTO;
import com.gestionNotificaciones.gestionNotificaciones.services.GestionNotificacionesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestion/notificaciones/v1")
public class GestionNotificacionesControllers {
    private static final Logger log = LoggerFactory.getLogger(GestionNotificacionesControllers.class);
    @Autowired
    private GestionNotificacionesServices gestionNotificacionesSvc;

    @PostMapping(value = "/creaNotificacion")
    public ResponseEntity<ResponseCreaNotDTO> creaNotificacion(@RequestBody CrearNotificacionDTO creaNot){
        log.info("Inicia proceso de agregar publicacion");
        return new ResponseEntity<ResponseCreaNotDTO>(gestionNotificacionesSvc.crearNotificacion(creaNot), HttpStatus.OK);
    }

}
