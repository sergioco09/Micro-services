package com.gestionUsuarios.gestionUsuarios.FeignClients;

import com.gestionUsuarios.gestionUsuarios.models.CrearPublicacionDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseActualizaPubDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseAltaPubliDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "publicaciones-service", url = "http://localhost:8084", path = "gestion/publicaciones/v1")
public interface PublicacionesFeignClients {

    @PostMapping(value = "/crearPublicacion")
    ResponseAltaPubliDTO agregaPublicacion(@RequestBody CrearPublicacionDTO pubAlta);

    @PutMapping(value = "/actPublicacion/{id}")
    ResponseActualizaPubDTO actPubl(@PathVariable(required = true) int id, @RequestBody CrearPublicacionDTO pubAct);
}
