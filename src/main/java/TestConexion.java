/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jrojas
 */

import co.edu.uniminuto.conexion.ConexionDB;
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        ConexionDB conexion = new ConexionDB();
        Connection con = conexion.getConexionDB();

        if (con != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}

