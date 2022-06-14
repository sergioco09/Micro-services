package com.gestionAmigos.gestionAmigos.services;

import com.gestionAmigos.gestionAmigos.models.CrearAmigosDTO;
import com.gestionAmigos.gestionAmigos.models.ResponseAmigosDTO;
import com.gestionAmigos.gestionAmigos.models.ResponseListaAmigosDTO;

import java.util.List;

public interface GestionAmigosService {
    ResponseAmigosDTO agregarAmigo(CrearAmigosDTO obj);
    ResponseAmigosDTO eliminarAmigo(int id);
    List<ResponseListaAmigosDTO> consultarAmigos(int id);
}
