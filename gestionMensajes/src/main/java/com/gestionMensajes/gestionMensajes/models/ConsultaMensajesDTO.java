package com.gestionMensajes.gestionMensajes.models;

public class ConsultaMensajesDTO {
    private Integer enviado;
    private String mensaje;

    public ConsultaMensajesDTO() {
    }

    public ConsultaMensajesDTO(Integer enviado, String mensaje) {
        this.enviado = enviado;
        this.mensaje = mensaje;
    }

    public Integer getEnviado() {
        return enviado;
    }

    public void setEnviado(Integer enviado) {
        this.enviado = enviado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
