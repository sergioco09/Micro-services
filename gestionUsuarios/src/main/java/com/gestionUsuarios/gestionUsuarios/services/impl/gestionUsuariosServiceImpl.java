package com.gestionUsuarios.gestionUsuarios.services.impl;

import com.gestionUsuarios.gestionUsuarios.FeignClients.AmigosFeignClients;
import com.gestionUsuarios.gestionUsuarios.FeignClients.MensajesFeignClients;
import com.gestionUsuarios.gestionUsuarios.FeignClients.NotificacionesFeignClients;
import com.gestionUsuarios.gestionUsuarios.FeignClients.PublicacionesFeignClients;
import com.gestionUsuarios.gestionUsuarios.models.*;
import com.gestionUsuarios.gestionUsuarios.services.gestionUsuariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class gestionUsuariosServiceImpl implements gestionUsuariosService {

    @Autowired
    AmigosFeignClients AmigosFeignClients;

    @Autowired
    MensajesFeignClients MensajesFeignClients;

    @Autowired
    NotificacionesFeignClients NotificacionesFeignClients;

    @Autowired
    PublicacionesFeignClients PublicacionesFeignClients;

    private static final Logger log = LoggerFactory.getLogger(gestionUsuariosServiceImpl.class);

    //credenciales db
    private static String user = "postgres";
    private static String pass = "123456789";

    private static Connection connection;
    responseUsuariosDTO respuesta = new responseUsuariosDTO();
    responseConlUsuDTO resConsulta = new responseConlUsuDTO();
    listaUsuariosDTO resLista = new listaUsuariosDTO();

    public static void iniConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RED_SOCIAL_MICROS",user,pass);
            log.info("Conectado con exito");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public responseUsuariosDTO altaUsuario(usuariosDTO obj) {
        int idGenerado = 0;
        try {
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("INSERT INTO usuarios (nombre,apellidopat,apellidomat,edad,nomusuario,contrasena) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            stmn.setString(1, obj.getNombre());
            stmn.setString(2,obj.getApellidoPaterno());
            stmn.setString(3,obj.getApellidoMaterno());
            stmn.setInt(4,obj.getEdad());
            stmn.setString(5,obj.getUsuario());
            stmn.setString(6,obj.getContrasena());
            stmn.executeUpdate();
            ResultSet generateKeys = stmn.getGeneratedKeys();
            if (generateKeys.next()){
                idGenerado = generateKeys.getInt(1);
            }
            stmn.close();
            //connection.commit();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        respuesta.setMensaje("Usuario dado de alta correctamente");
        respuesta.setIdUsuario(idGenerado);
        respuesta.setNombreUsurario(obj.getUsuario());
        log.info("Proceso completado");
        return respuesta;
    }

    public responseUsuariosDTO bajaUsuario(int idUsu){
        try {
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("DELETE FROM usuarios where idusuario = ?");
            stmn.setInt(1,idUsu);
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
            respuesta.setMensaje("Se elimino el usuario: " + idUsu);
            respuesta.setIdUsuario(idUsu);
            System.out.println("Proceso completado");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return respuesta;
    }

    //public responseConlUsuDTO consultarUsuario(){
    public     List<responseConlUsuDTO> consultarUsuario(){
        ResultSet resultado = null;
        List<responseConlUsuDTO> testList = new ArrayList<>();

        try{
            iniConnection();
            PreparedStatement stmn = connection.prepareStatement("SELECT * FROM usuarios");
            resultado = stmn.executeQuery();
            log.info("Recupera regisros" + resultado);
            while(resultado.next()){
                responseConlUsuDTO resConsulta2 = new responseConlUsuDTO();
                resConsulta2.setIdUsuario(resultado.getInt("idusuario"));
                resConsulta2.setNombre(resultado.getString("nombre"));
                resConsulta2.setApellidoPaterno(resultado.getString("apellidopat"));
                resConsulta2.setApellidoMaterno(resultado.getString("apellidomat"));
                resConsulta2.setEdad(resultado.getInt("edad"));
                resConsulta2.setNombreUsuario(resultado.getString("nomusuario"));
                testList.add(resConsulta2);
                //resLista.setRespUsuarios(resConsulta);
            }
            stmn.close();
            //connection.commit();
            connection.close();
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return testList;
    }

    //Metodos de amigos

    public ResponseAmigosDTO agregaAmigo(@RequestBody CrearAmigosDTO obj){
        ResponseAmigosDTO CrearAmigosDTONew = AmigosFeignClients.agregaAmigo(obj);
        return CrearAmigosDTONew;
    }

    public ResponseAmigosDTO eliminaAmigo(@PathVariable(required = true) Integer id){
        ResponseAmigosDTO NewEminiarAmigosDTO = AmigosFeignClients.eliminaAmigo(id);
        return NewEminiarAmigosDTO;
    }

    public List<ResponseListaAmigosDTO> consultaAmigos(@PathVariable(required = true) Integer id){
        List<ResponseListaAmigosDTO> NewConListaAmigos = AmigosFeignClients.consultaAmigos(id);
        return NewConListaAmigos;
    }

    //Metodos de Mensajes

    public ResponseMensajeDTO creaMensajes(@RequestBody CrearMensajeDTO menNuevo){
        ResponseMensajeDTO NewResponseMensajeDTO = MensajesFeignClients.creaMensajes(menNuevo);
        return NewResponseMensajeDTO;
    }

    public List<ConsultaMensajesDTO> consultaMensajes(@PathVariable(required = true) Integer id){
        List<ConsultaMensajesDTO> NewListMensajes = MensajesFeignClients.consultaMensajes(id);
        return NewListMensajes;
    }

    //Metodos de notificaciones

    public ResponseCreaNotDTO creaNotificacion(@RequestBody CrearNotificacionDTO creaNot){
        ResponseCreaNotDTO NewResponseCreaNotDTO = NotificacionesFeignClients.creaNotificacion(creaNot);
        return NewResponseCreaNotDTO;
    }

    //Metodos de publicaciones

    public ResponseAltaPubliDTO agregaPublicacion(@RequestBody CrearPublicacionDTO pubAlta){
        ResponseAltaPubliDTO NewResponseAltaPubliDTO = PublicacionesFeignClients.agregaPublicacion(pubAlta);
        return NewResponseAltaPubliDTO;
    }

    public ResponseActualizaPubDTO actPubl(@PathVariable(required = true) int id, @RequestBody CrearPublicacionDTO pubAct){
        ResponseActualizaPubDTO NewResponseActualizaPubDTO = PublicacionesFeignClients.actPubl(id,pubAct);
        return NewResponseActualizaPubDTO;
    }

}
