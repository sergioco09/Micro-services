package com.gestionUsuarios.gestionUsuarios.models;

public class responseUsuariosDTO {
    private String mensaje;
    private Integer idUsuario;
    private String nombreUsurario;

    public responseUsuariosDTO() {
    }

    public responseUsuariosDTO(String mensaje, Integer idUsuario, String nombreUsurario) {
        this.mensaje = mensaje;
        this.idUsuario = idUsuario;
        this.nombreUsurario = nombreUsurario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsurario() {
        return nombreUsurario;
    }

    public void setNombreUsurario(String nombreUsurario) {
        this.nombreUsurario = nombreUsurario;
    }
}
