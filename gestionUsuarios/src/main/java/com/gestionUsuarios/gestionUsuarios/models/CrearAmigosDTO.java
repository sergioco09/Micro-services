package com.gestionUsuarios.gestionUsuarios.models;

public class CrearAmigosDTO {
    private Integer id;
    private Integer idUsuario;
    private Integer idAmigo;
    private String mensaje;

    public CrearAmigosDTO() {
    }

    public CrearAmigosDTO(Integer id, Integer idUsuario, Integer idAmigo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idAmigo = idAmigo;
    }

    public CrearAmigosDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }
}
