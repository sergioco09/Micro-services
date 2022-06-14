package com.gestionAmigos.gestionAmigos.controllers;

import com.gestionAmigos.gestionAmigos.models.CrearAmigosDTO;
import com.gestionAmigos.gestionAmigos.models.ResponseAmigosDTO;
import com.gestionAmigos.gestionAmigos.models.ResponseListaAmigosDTO;
import com.gestionAmigos.gestionAmigos.services.GestionAmigosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/gestion/amigos/v1")
public class GestionAmigosControllers {
    private static final Logger log = LoggerFactory.getLogger(GestionAmigosControllers.class);

    @Autowired
    private GestionAmigosService gestionAmigosSvc;

    @PostMapping(value = "/agregarAmigo")
    public ResponseEntity<ResponseAmigosDTO> agregaAmigo(@RequestBody CrearAmigosDTO amigoNuevo){
        log.info("Inicia proceso de agregar usuario");
        return new ResponseEntity<ResponseAmigosDTO>(gestionAmigosSvc.agregarAmigo(amigoNuevo), OK);
    }

    @DeleteMapping("/eliminaAmigo/{id}")
    public ResponseEntity<ResponseAmigosDTO> eliminaAmigo(@PathVariable(required = true) Integer id){
        log.info("Inicia proceso de eliminar Amigo");
        return new ResponseEntity<ResponseAmigosDTO>(gestionAmigosSvc.eliminarAmigo(id), OK);
    }

    @GetMapping(value = "/consultarAmigos/{id}")
    public ResponseEntity<List<ResponseListaAmigosDTO>> consultaAmigos(@PathVariable(required = true) Integer id){
        log.info("Inicia proceso de recuperar mensajes");
        return new ResponseEntity<>(gestionAmigosSvc.consultarAmigos(id), OK);
    }
}
