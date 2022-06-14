package com.gestionUsuarios.gestionUsuarios.models;

public class ResponseActualizaPubDTO {
    private String mensaje;
    private String pubActualizada;
    private String horaAct;

    public ResponseActualizaPubDTO() {
    }

    public ResponseActualizaPubDTO(String mensaje, String pubActualizada, String horaAct) {
        this.mensaje = mensaje;
        this.pubActualizada = pubActualizada;
        this.horaAct = horaAct;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPubActualizada() {
        return pubActualizada;
    }

    public void setPubActualizada(String pubActualizada) {
        this.pubActualizada = pubActualizada;
    }

    public String getHoraAct() {
        return horaAct;
    }

    public void setHoraAct(String horaAct) {
        this.horaAct = horaAct;
    }
}
