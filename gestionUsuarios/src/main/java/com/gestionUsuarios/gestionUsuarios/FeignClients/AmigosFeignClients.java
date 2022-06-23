package com.gestionUsuarios.gestionUsuarios.FeignClients;

import com.gestionUsuarios.gestionUsuarios.models.CrearAmigosDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseAmigosDTO;
import com.gestionUsuarios.gestionUsuarios.models.ResponseListaAmigosDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "amigos-service", url="http://localhost:8082", path = "gestion/amigos/v1")
//@RequestMapping("gestion/amigos/v1")
public interface AmigosFeignClients {
    @PostMapping(value = "/agregarAmigo")
    ResponseAmigosDTO agregaAmigo(@RequestBody CrearAmigosDTO obj);

    @DeleteMapping("/eliminaAmigo/{id}")
    ResponseAmigosDTO eliminaAmigo(@PathVariable(required = true) Integer id);

    @GetMapping(value = "/consultarAmigos/{id}")
    List<ResponseListaAmigosDTO> consultaAmigos(@PathVariable(required = true) Integer id);

}
