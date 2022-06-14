package com.gestionNotificaciones.gestionNotificaciones.models;

public class CrearNotificacionDTO {
    private Integer idNotificacion;
    private Integer idUsuario;
    private String nomUsuario;
    private String notificacion;

    public CrearNotificacionDTO() {
    }

    public CrearNotificacionDTO(Integer idNotificacion, Integer idUsuario, String nomUsuario, String notificacion) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.notificacion = notificacion;
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

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }
}
