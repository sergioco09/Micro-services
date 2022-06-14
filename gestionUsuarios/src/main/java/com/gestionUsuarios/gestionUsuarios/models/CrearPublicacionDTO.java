package com.gestionUsuarios.gestionUsuarios.models;

public class CrearPublicacionDTO {
    private Integer idPublicacion;
    private Integer idUsuario;
    private String publicacion;

    public CrearPublicacionDTO() {
    }

    public CrearPublicacionDTO(Integer idPublicacion, Integer idUsuario, String publicacion) {
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
        this.publicacion = publicacion;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }
}
