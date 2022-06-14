package com.gestionPublicaciones.gestionPublicaciones.services.Impl;

import com.gestionPublicaciones.gestionPublicaciones.controllers.GestionPublicacionesControllers;
import com.gestionPublicaciones.gestionPublicaciones.models.CrearPublicacionDTO;
import com.gestionPublicaciones.gestionPublicaciones.models.ResponseActualizaPubDTO;
import com.gestionPublicaciones.gestionPublicaciones.models.ResponseAltaPubliDTO;
import com.gestionPublicaciones.gestionPublicaciones.services.GestionPublicacionesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;

@Service
public class GestionPublicacionServiceImpl implements GestionPublicacionesService {

    private static final Logger log = LoggerFactory.getLogger(GestionPublicacionesControllers.class);
    //credenciales db
    private static String user = "postgres";
    private static String pass = "123456789";

    private static Connection connection;
    ResponseAltaPubliDTO respuesta = new ResponseAltaPubliDTO();
    ResponseActualizaPubDTO respuestaAct = new ResponseActualizaPubDTO();

    public static void iniConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RED_SOCIAL_MICROS",user,pass);
            log.info("Conectado con exito");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public ResponseAltaPubliDTO agregarPublicacion(CrearPublicacionDTO obj){
        try {
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("INSERT INTO publicaciones (idusuario,menpublicacion) VALUES (?,?)");
            stmn.setInt(1, obj.getIdUsuario());
            stmn.setString(2,obj.getPublicacion());
            stmn.executeUpdate();
            stmn.close();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        respuesta.setMensaje("Publicacion generada correctamente");
        log.info("Proceso completado");
        return respuesta;
    }
    public ResponseActualizaPubDTO actPublicacion(int id,CrearPublicacionDTO obj){
        try{
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("UPDATE publicaciones SET idusuario=?,menpublicacion=? WHERE idpublicacion = ?");
            stmn.setInt(1,obj.getIdUsuario());
            stmn.setString(2,obj.getPublicacion());
            stmn.setInt(3,id);
            stmn.executeUpdate();
            stmn.close();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        respuestaAct.setMensaje("Publicaciòn actualizada");
        respuestaAct.setPubActualizada(obj.getPublicacion());
        respuestaAct.setHoraAct(String.valueOf(LocalDateTime.now()));
        log.info("Proceso completado");
        return respuestaAct;
    }

}
