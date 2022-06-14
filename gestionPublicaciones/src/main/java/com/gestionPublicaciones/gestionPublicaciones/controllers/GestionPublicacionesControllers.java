package com.gestionPublicaciones.gestionPublicaciones.controllers;

import com.gestionPublicaciones.gestionPublicaciones.models.CrearPublicacionDTO;
import com.gestionPublicaciones.gestionPublicaciones.models.ResponseActualizaPubDTO;
import com.gestionPublicaciones.gestionPublicaciones.models.ResponseAltaPubliDTO;
import com.gestionPublicaciones.gestionPublicaciones.services.GestionPublicacionesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gestion/publicaciones/v1")
public class GestionPublicacionesControllers {
    private static final Logger log = LoggerFactory.getLogger(GestionPublicacionesControllers.class);

    @Autowired
    private GestionPublicacionesService gestionPublicacionesSvc;

    @PostMapping(value = "/crearPublicacion")
    public ResponseEntity<ResponseAltaPubliDTO> agregaPublicacion(@RequestBody CrearPublicacionDTO pubAlta){
        log.info("Inicia proceso de agregar publicacion");
        return new ResponseEntity<ResponseAltaPubliDTO>(gestionPublicacionesSvc.agregarPublicacion(pubAlta), HttpStatus.OK);
    }

    @PutMapping(value = "/actPublicacion/{id}")
    public ResponseEntity<ResponseActualizaPubDTO> actPubl(@PathVariable(required = true) int id, @RequestBody CrearPublicacionDTO pubAct){
        log.info("Inicia Actualizaciòn");
        return new ResponseEntity<ResponseActualizaPubDTO>(gestionPublicacionesSvc.actPublicacion(id,pubAct),HttpStatus.OK);
    }
}
