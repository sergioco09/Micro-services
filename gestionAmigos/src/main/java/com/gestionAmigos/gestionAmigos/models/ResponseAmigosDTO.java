package com.gestionAmigos.gestionAmigos.models;

public class ResponseAmigosDTO {
    private String mensaje;

    public ResponseAmigosDTO() {
    }

    public ResponseAmigosDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
