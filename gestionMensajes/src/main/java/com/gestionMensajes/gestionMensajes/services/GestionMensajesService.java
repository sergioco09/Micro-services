package com.gestionMensajes.gestionMensajes.services;

import com.gestionMensajes.gestionMensajes.models.ConsultaMensajesDTO;
import com.gestionMensajes.gestionMensajes.models.CrearMensajeDTO;
import com.gestionMensajes.gestionMensajes.models.ResponseMensajeDTO;

import java.util.List;

public interface GestionMensajesService {
    ResponseMensajeDTO mensajeNuevo(CrearMensajeDTO obj);
    List<ConsultaMensajesDTO> consultarMensajes(int id);
}
