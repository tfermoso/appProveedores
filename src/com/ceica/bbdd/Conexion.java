package com.ceica.bbdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Conexion {

    public static Connection conectar(){
        // Cargar la configuración desde el archivo de propiedades
        Properties propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream("config.properties")) {
            propiedades.load(entrada);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
