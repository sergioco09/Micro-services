package com.gestionMensajes.gestionMensajes.models;

public class ResponseMensajeDTO {
    private String mensaje;

    public ResponseMensajeDTO() {
    }

    public ResponseMensajeDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
