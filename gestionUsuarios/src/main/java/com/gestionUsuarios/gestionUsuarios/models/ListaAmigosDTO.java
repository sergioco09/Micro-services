package com.gestionUsuarios.gestionUsuarios.models;

import java.util.List;

public class ListaAmigosDTO {
    private List<ResponseListaAmigosDTO> resAmigos;

    public ListaAmigosDTO() {
    }

    public List<ResponseListaAmigosDTO> getResAmigos() {
        return resAmigos;
    }

    public void setResAmigos(List<ResponseListaAmigosDTO> resAmigos) {
        this.resAmigos = resAmigos;
    }
}
