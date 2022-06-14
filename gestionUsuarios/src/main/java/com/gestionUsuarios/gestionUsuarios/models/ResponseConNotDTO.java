package com.gestionUsuarios.gestionUsuarios.models;

public class ResponseConNotDTO {
    private Integer idNotificacion;
    private Integer idUsuario;
    private String nomUsuario;
    private String hora;

    public ResponseConNotDTO() {
    }

    public ResponseConNotDTO(Integer idNotificacion, Integer idUsuario, String nomUsuario, String hora) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.hora = hora;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
