package com.gestionUsuarios.gestionUsuarios.services;

import com.gestionUsuarios.gestionUsuarios.models.*;

import java.util.List;

public interface gestionUsuariosService {
    responseUsuariosDTO altaUsuario(usuariosDTO obj);
    responseUsuariosDTO bajaUsuario(int idUsu);
    List<responseConlUsuDTO> consultarUsuario();
}
