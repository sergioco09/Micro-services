package com.gestionPublicaciones.gestionPublicaciones.services;

import com.gestionPublicaciones.gestionPublicaciones.models.CrearPublicacionDTO;
import com.gestionPublicaciones.gestionPublicaciones.models.ResponseActualizaPubDTO;
import com.gestionPublicaciones.gestionPublicaciones.models.ResponseAltaPubliDTO;

public interface GestionPublicacionesService {
    ResponseAltaPubliDTO agregarPublicacion(CrearPublicacionDTO obj);
    ResponseActualizaPubDTO actPublicacion(int id,CrearPublicacionDTO obj);
}
