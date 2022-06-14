package com.gestionAmigos.gestionAmigos.models;

public class ResponseListaAmigosDTO {
    private String nomAmigo;

    public ResponseListaAmigosDTO() {
    }

    public ResponseListaAmigosDTO(String nomAmigo) {
        this.nomAmigo = nomAmigo;
    }

    public String getNomAmigo() {
        return nomAmigo;
    }

    public void setNomAmigo(String nomAmigo) {
        this.nomAmigo = nomAmigo;
    }
}
