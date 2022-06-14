package com.gestionUsuarios.gestionUsuarios.controllers;


import com.gestionUsuarios.gestionUsuarios.models.*;
import com.gestionUsuarios.gestionUsuarios.services.gestionUsuariosService;
import com.gestionUsuarios.gestionUsuarios.services.impl.gestionUsuariosServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("gestion/usuarios/v1")
public class gestionUsuariosControllers {

    private static final Logger log = LoggerFactory.getLogger(gestionUsuariosControllers.class);

    @Autowired
    private gestionUsuariosService gestionUsuariosSvc;

    @Autowired
    gestionUsuariosServiceImpl gestionUsuarios;


    @PostMapping(value = "/crearUsuario")
    public ResponseEntity<responseUsuariosDTO> creaUsuario(@RequestBody usuariosDTO resAlta){
        log.info("Inicia proceso de agregar usuario");
        return new ResponseEntity<responseUsuariosDTO>(gestionUsuariosSvc.altaUsuario(resAlta), OK);
    }

    @DeleteMapping ("/eliminaUsuario/{id}")
    public ResponseEntity<responseUsuariosDTO> eliminarUsuario(@PathVariable(required = true) Integer id){
        //@PathVariable("id") String id
        log.info("Inicia proceso de eliminar usuario");
        return new ResponseEntity<responseUsuariosDTO>(gestionUsuariosSvc.bajaUsuario(id), OK);
    }

    @GetMapping(value = "/consultaUsuario")
    public ResponseEntity<List<responseConlUsuDTO>> consultaUsuario(){
        log.info("Inicia proceso de recuperar usuario");
        //return new ResponseEntity<responseConlUsuDTO>(gestionUsuariosSvc.consultarUsuario(), OK);
        return new ResponseEntity<>(gestionUsuariosSvc.consultarUsuario(), OK);
    }

    //crear amigos

    @PostMapping(value = "/agregarAmigo")
    public ResponseEntity<ResponseAmigosDTO> agregaAmigo(@RequestBody CrearAmigosDTO amigoNuevo){
        log.info("Inicia proceso de agregar Amigo");
        return ResponseEntity.ok(gestionUsuarios.agregaAmigo(amigoNuevo));
    }
    @DeleteMapping("/eliminaAmigo/{id}")
    public ResponseEntity<ResponseAmigosDTO> eliminaAmigo(@PathVariable(required = true) Integer id){
        log.info("Inicia proceso de eliminar Amigo");
        return ResponseEntity.ok(gestionUsuarios.eliminaAmigo(id));
    }

    @GetMapping(value = "/consultarAmigos/{id}")
    public ResponseEntity<List<ResponseListaAmigosDTO>> consultaAmigos(@PathVariable(required = true) Integer id){
        log.info("Inicia proceso de recuperar mensajes");
        return ResponseEntity.ok(gestionUsuarios.consultaAmigos(id));
    }

    //Crear Mensaje
    @PostMapping(value = "/crearMensaje")
    public ResponseEntity<ResponseMensajeDTO> creaMensajes(@RequestBody CrearMensajeDTO menNuevo){
        log.info("Inicia proceso de envio de mensajes");
        return ResponseEntity.ok(gestionUsuarios.creaMensajes(menNuevo));
    }
    @GetMapping(value = "/consultarMensajes/{id}")
    public ResponseEntity<List<ConsultaMensajesDTO>> consultaMensajes(@PathVariable(required = true) Integer id){
        log.info("Inicia proceso de recuperar mensajes");
        return ResponseEntity.ok(gestionUsuarios.consultaMensajes(id));
    }

    //Notificaciones
    @PostMapping(value = "/creaNotificacion")
    public ResponseEntity<ResponseCreaNotDTO> creaNotificacion(@RequestBody CrearNotificacionDTO creaNot){
        log.info("Inicia proceso de agregar publicacion");
        return ResponseEntity.ok(gestionUsuarios.creaNotificacion(creaNot));
    }

    //Puclicaciones
    @PostMapping(value = "/crearPublicacion")
    public ResponseEntity<ResponseAltaPubliDTO> agregaPublicacion(@RequestBody CrearPublicacionDTO pubAlta){
        log.info("Inicia proceso de agregar publicacion");
        return ResponseEntity.ok(gestionUsuarios.agregaPublicacion(pubAlta));
    }

    @PutMapping(value = "/actPublicacion/{id}")
    public ResponseEntity<ResponseActualizaPubDTO> actPubl(@PathVariable(required = true) int id, @RequestBody CrearPublicacionDTO pubAct){
        log.info("Inicia Actualizaciòn");
       return ResponseEntity.ok(gestionUsuarios.actPubl(id,pubAct));
    }
}
