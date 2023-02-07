package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private Conexion(){

    }

    //Variable que almacena el estado de la conexion de la base de datos
    private static Connection connection;

    //Creamos una variable para crear una sola instancia
    private static Conexion instancia;
    private static final String URL = "jdbc:mysql://localhost:3306/mensajes_app";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public Connection getConnectionX(){


        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            System.out.println("Conexión establecida.");
            if (connection.isValid(5)) {
                System.out.println("La conexión es válida.");
            } else {
                System.out.println("La conexión no es válida.");
            }
            return connection;

        }catch (HeadlessException | SQLException e) {

            System.out.println("Error al establecer la conexión: " + e.getMessage());
            System.exit(0);
        }
        return connection;
    }

    //Creamos metodo para cerrar la conexion
    public void cerrarConexion() throws SQLException {
        try {
            connection.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }

    //Patron Singleton
    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

}
