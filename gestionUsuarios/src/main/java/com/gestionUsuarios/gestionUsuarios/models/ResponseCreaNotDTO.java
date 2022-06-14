package com.gestionUsuarios.gestionUsuarios.models;

public class ResponseCreaNotDTO {
    private String mensaje;
    private String horaCreacion;

    public ResponseCreaNotDTO() {
    }

    public ResponseCreaNotDTO(String mensaje, String horaCreacion) {
        this.mensaje = mensaje;
        this.horaCreacion = horaCreacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }
}
