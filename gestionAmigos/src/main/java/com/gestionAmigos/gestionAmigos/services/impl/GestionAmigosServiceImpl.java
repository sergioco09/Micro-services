package com.gestionAmigos.gestionAmigos.services.impl;

import com.gestionAmigos.gestionAmigos.models.CrearAmigosDTO;
import com.gestionAmigos.gestionAmigos.models.ResponseAmigosDTO;
import com.gestionAmigos.gestionAmigos.models.ResponseListaAmigosDTO;
import com.gestionAmigos.gestionAmigos.services.GestionAmigosService;
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
public class GestionAmigosServiceImpl implements GestionAmigosService {
    private static final Logger log = LoggerFactory.getLogger(GestionAmigosServiceImpl.class);

    private static String user = "postgres";
    private static String pass = "123456789";
    private static Connection connection;
    ResponseAmigosDTO resMensaje = new ResponseAmigosDTO();

    public static void iniConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RED_SOCIAL_MICROS",user,pass);
            log.info("Conectado con exito");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public ResponseAmigosDTO agregarAmigo(CrearAmigosDTO obj){
        ResultSet resultado = null;
        String nomAmigo = null;
        try{
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("SELECT * FROM usuarios where idusuario = ?");
            stmn.setInt(1, obj.getIdAmigo());
            resultado = stmn.executeQuery();
            while(resultado.next()){
                nomAmigo = resultado.getString("nomusuario");
            }

            log.info("Recuperta amigo");

            stmn = connection.prepareStatement("INSERT INTO amigos (idusuario,idamigo,nomamigo) VALUES (?,?,?)");
            stmn.setInt(1,obj.getIdUsuario());
            stmn.setInt(2,obj.getIdAmigo());
            stmn.setString(3,nomAmigo);
            stmn.executeUpdate();
            stmn.close();
            //connection.commit();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        resMensaje.setMensaje("Se agrego a: " + nomAmigo);
        log.info("Amigo Agregado");
        return resMensaje;
    }

    public ResponseAmigosDTO eliminarAmigo(int id){
        try {
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("DELETE FROM amigos where idamigo = ?");
            stmn.setInt(1,id);
            int count = stmn.executeUpdate();
            if(count == 0){
                log.info("No se elimino el registro");
            }else{
                log.info("Se elimino el registro de manera correcta");
            }
            stmn.close();
            //stmn.executeUpdate();
            //connection.commit();
            connection.close();
            resMensaje.setMensaje("Se elimino el Amigo: " + id);
            System.out.println("Proceso completado");

        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return resMensaje;
    }

    public List<ResponseListaAmigosDTO> consultarAmigos(int id){
        ResultSet resultado = null;
        List<ResponseListaAmigosDTO> testList = new ArrayList<>();
        try{
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("SELECT * FROM amigos where idusuario = ?");
            stmn.setInt(1, id);
            resultado = stmn.executeQuery();
            log.info("Recupera regisros");
            while(resultado.next()){
                ResponseListaAmigosDTO resConsulta2 = new ResponseListaAmigosDTO();
                resConsulta2.setNomAmigo(resultado.getString("nomamigo"));
                testList.add(resConsulta2);
            }
            stmn.close();
            //connection.commit();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return testList;
    }
}
