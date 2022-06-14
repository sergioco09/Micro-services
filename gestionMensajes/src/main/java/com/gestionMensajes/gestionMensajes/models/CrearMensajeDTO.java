package com.gestionMensajes.gestionMensajes.models;

public class CrearMensajeDTO {
    private Integer id;
    private Integer idReceptor;
    private Integer idEmisor;
    private String nomEmisor;
    private String mensaje;


    public CrearMensajeDTO() {
    }

    public CrearMensajeDTO(Integer id, Integer idReceptor, Integer idEmisor, String nomEmisor, String mensaje) {
        this.id = id;
        this.idReceptor = idReceptor;
        this.idEmisor = idEmisor;
        this.nomEmisor = nomEmisor;
        this.mensaje = mensaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    public Integer getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Integer idEmisor) {
        this.idEmisor = idEmisor;
    }

    public String getNomEmisor() {
        return nomEmisor;
    }

    public void setNomEmisor(String nomEmisor) {
        this.nomEmisor = nomEmisor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
