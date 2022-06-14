package com.gestionAmigos.gestionAmigos.models;

public class CrearAmigosDTO {
    private Integer id;
    private Integer idUsuario;
    private Integer idAmigo;

    public CrearAmigosDTO() {
    }

    public CrearAmigosDTO(Integer id, Integer idUsuario, Integer idAmigo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idAmigo = idAmigo;
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
