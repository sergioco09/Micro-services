package com.gestionPublicaciones.gestionPublicaciones.models;

public class ResponseAltaPubliDTO {
    private String mensaje;

    public ResponseAltaPubliDTO() {
    }

    public ResponseAltaPubliDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
