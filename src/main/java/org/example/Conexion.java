package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.logging.Logger;


public class Conexion {

    public Connection get_connection(){
        Connection connection = null;
        final Logger LOGGER = Logger.getLogger(Main.class.getName());
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if (connection!=null){
                LOGGER.info("Successful Connection");
            }

        }catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return connection;
    }
}
