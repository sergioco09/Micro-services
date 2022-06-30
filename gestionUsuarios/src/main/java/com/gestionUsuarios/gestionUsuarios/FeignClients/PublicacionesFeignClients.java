package com.gestionUsuarios.gestionUsuarios.FeignClients;

import com.gestionUsuarios.gestionUsuarios.models.CrearPublicacionDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseActualizaPubDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseAltaPubliDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "publicaciones-service", path = "gestion/publicaciones/v1")
//@RequestMapping("gestion/publicaciones/v1")
public interface PublicacionesFeignClients {

    @PostMapping(value = "/crearPublicacion")
    ResponseAltaPubliDTO agregaPublicacion(@RequestBody CrearPublicacionDTO pubAlta);

    @PutMapping(value = "/actPublicacion/{id}")
    ResponseActualizaPubDTO actPubl(@PathVariable(required = true) int id, @RequestBody CrearPublicacionDTO pubAct);
}
