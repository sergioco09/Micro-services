package com.gestionNotificaciones.gestionNotificaciones.services.Impl;

import com.gestionNotificaciones.gestionNotificaciones.models.CrearNotificacionDTO;
import com.gestionNotificaciones.gestionNotificaciones.models.ResponseCreaNotDTO;
import com.gestionNotificaciones.gestionNotificaciones.services.GestionNotificacionesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;

@Service
public class GestionNotificacionesServicesImpl implements GestionNotificacionesServices {

    private static final Logger log = LoggerFactory.getLogger(GestionNotificacionesServicesImpl.class);

    //credenciales db
    private static String user = "postgres";
    private static String pass = "123456789";

    private static Connection connection;
    ResponseCreaNotDTO respuesta = new ResponseCreaNotDTO();

    public static void iniConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RED_SOCIAL_MICROS",user,pass);
            log.info("Conectado con exito");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public ResponseCreaNotDTO crearNotificacion(CrearNotificacionDTO obj) {
        try {
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("INSERT INTO notificaciones (idusuario,nomusuario,notificaciones) VALUES (?,?,?)");
            stmn.setInt(1,obj.getIdUsuario());
            stmn.setString(2,obj.getNomUsuario());
            stmn.setString(3,obj.getNotificacion());
            stmn.executeUpdate();
            stmn.close();
            //connection.commit();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        respuesta.setMensaje("Notificacion Creada");
        respuesta.setHoraCreacion(String.valueOf(LocalDateTime.now()));
        log.info("Proceso completado");
        return respuesta;
    }

}
