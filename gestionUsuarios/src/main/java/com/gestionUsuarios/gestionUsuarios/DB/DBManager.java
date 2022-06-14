package com.gestionUsuarios.gestionUsuarios.DB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    private static final Logger log = LoggerFactory.getLogger(DBManager.class);
    //credenciales db
    private static String user = "postgres";
    private static String pass = "sadmin";

    private static Connection connection;

    public static void iniConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RED_SOCIAL_MICROS",user,pass);
            log.info("Conectado con exito");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
