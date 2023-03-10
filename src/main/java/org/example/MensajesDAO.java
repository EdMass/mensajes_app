package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensajes){
        Conexion conexionDb = Conexion.getInstancia();
        Connection connection = conexionDb.getConnectionX();
        PreparedStatement preparedStatement = null;

        try {
            String query = "INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, mensajes.getMensaje());
            preparedStatement.setString(2, mensajes.getAutorMensaje());
            preparedStatement.executeUpdate();

            System.out.println("SMS CREADO!!!!");
            conexionDb.cerrarConexion();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void leerMensajeDB() {
        Conexion conexionDb = Conexion.getInstancia();
        Connection connection = conexionDb.getConnectionX();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM mensajes";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("ID: "+resultSet.getInt("id_mensaje"));
                System.out.println("Mensaje: "+resultSet.getString("mensaje"));
                System.out.println("Autor: "+resultSet.getString("autor_mensaje"));
                System.out.println("Fecha: "+resultSet.getString("fecha_mensaje"));
                System.out.println("");
            }

        }catch (SQLException ex){
            System.out.println("No fue posible traer los mensajes");
            System.out.println(ex);
        }

    }

    public static void borrarMensajeDB(int idMensaje) {
        Conexion conexionDb = Conexion.getInstancia();
        Connection connection = conexionDb.getConnectionX();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idMensaje);
            int countRowsUpdated = preparedStatement.executeUpdate();
            if (countRowsUpdated != 0) {
                System.out.println("El mensaje ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El mensaje no ha sido encontrado :(");
            }
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("El mensaje no pudo ser borrado");
        }

    }

    public static void actualizarMensajeDB(Mensajes mensajes) {

    }


}
