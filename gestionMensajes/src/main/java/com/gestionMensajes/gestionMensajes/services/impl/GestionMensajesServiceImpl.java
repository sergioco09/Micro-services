package com.gestionMensajes.gestionMensajes.services.impl;

import com.gestionMensajes.gestionMensajes.models.ConsultaMensajesDTO;
import com.gestionMensajes.gestionMensajes.models.CrearMensajeDTO;
import com.gestionMensajes.gestionMensajes.models.ResponseMensajeDTO;
import com.gestionMensajes.gestionMensajes.services.GestionMensajesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class GestionMensajesServiceImpl implements GestionMensajesService {
    private static final Logger log = LoggerFactory.getLogger(GestionMensajesServiceImpl.class);

    private static String user = "postgres";
    private static String pass = "123456789";

    private static Connection connection;

    ResponseMensajeDTO resMensaje = new ResponseMensajeDTO();

    public static void iniConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RED_SOCIAL_MICROS",user,pass);
            log.info("Conectado con exito");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public ResponseMensajeDTO mensajeNuevo(CrearMensajeDTO obj){
        try{
            iniConnection();
            log.info("Inicia conexión");
            PreparedStatement stmn = connection.prepareStatement("INSERT INTO mensajes (idreceptor,idemisor,nomemisor,mensaje) VALUES (?,?,?,?)");
            stmn.setInt(1,obj.getIdReceptor());
            stmn.setInt(2,obj.getIdEmisor());
            stmn.setString(3, obj.getNomEmisor());
            stmn.setString(4,obj.getMensaje());
            stmn.executeUpdate();

            stmn.close();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        resMensaje.setMensaje("Se envio el mensaje de manera correcta");
        log.info("Mensaje Enviado");
        return resMensaje;
    }



    public List<ConsultaMensajesDTO> consultarMensajes(int id){
        ResultSet resultado = null;
        List<ConsultaMensajesDTO> testList = new ArrayList<>();
        try{
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("SELECT * FROM mensajes where idreceptor = ?");
            stmn.setInt(1, id);
            resultado = stmn.executeQuery();
            log.info("Recupera regisros");
            while(resultado.next()){
                ConsultaMensajesDTO resConsulta2 = new ConsultaMensajesDTO();
                resConsulta2.setEnviado(resultado.getInt("idemisor"));
                resConsulta2.setMensaje(resultado.getString("mensaje"));
                testList.add(resConsulta2);
            }
            stmn.close();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return testList;
    }
}
