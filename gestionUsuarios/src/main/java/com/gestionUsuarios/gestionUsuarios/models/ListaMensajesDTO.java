package com.gestionUsuarios.gestionUsuarios.models;

import java.util.List;

public class ListaMensajesDTO {
    private List<ResponseMensajeDTO> resMensajes;

    public ListaMensajesDTO() {
    }

    public List<ResponseMensajeDTO> getResMensajes() {
        return resMensajes;
    }

    public void setResMensajes(List<ResponseMensajeDTO> resMensajes) {
        this.resMensajes = resMensajes;
    }
}
