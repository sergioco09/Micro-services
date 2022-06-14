package com.gestionNotificaciones.gestionNotificaciones.services;

import com.gestionNotificaciones.gestionNotificaciones.models.CrearNotificacionDTO;
import com.gestionNotificaciones.gestionNotificaciones.models.ResponseCreaNotDTO;

public interface GestionNotificacionesServices {
    ResponseCreaNotDTO crearNotificacion(CrearNotificacionDTO obj);
}
