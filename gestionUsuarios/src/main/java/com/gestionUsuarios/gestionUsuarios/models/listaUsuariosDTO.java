package com.gestionUsuarios.gestionUsuarios.models;

import java.util.List;

public class listaUsuariosDTO {
    private List<responseConlUsuDTO> respUsuarios;

    public listaUsuariosDTO() {
    }

    public List<responseConlUsuDTO> getRespUsuarios() {
        return respUsuarios;
    }

    public void setRespUsuarios(List<responseConlUsuDTO> respUsuarios) {
        this.respUsuarios = respUsuarios;
    }
}
