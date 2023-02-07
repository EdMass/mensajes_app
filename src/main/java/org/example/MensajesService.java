package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = scanner.nextLine();

        System.out.println("Escribe tu nombre");
        String nombre = scanner.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);

    }

    public static void listarMensaje() {
        MensajesDAO.leerMensajeDB();
    }

    public static void borrarMensaje() {

    }

    public static void editarMensaje() {

    }


}
