package co.edu.uniminuto.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionDB {
//1. Declaración de los atributos
    private String user;
    private String password;
    private String nameDatabase;
    private String portMotor;
    private String servidor;
    private String cadUrl;
    private Connection con;

    public ConexionDB() {

        this.user = "root";
        this.password = "";
        this.nameDatabase = "colegio";
        this.portMotor = "3306";
        this.servidor = "localhost";
        this.cadUrl = "jdbc:mysql://" + this.servidor + this.portMotor + "/" + this.nameDatabase;
        this.con = null;

    }

    private Connection conexionColegio() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.cadUrl, this.user, this.password);
            JOptionPane.showMessageDialog(null, "Bienvenido a la Base de Datos miColegio");

        } catch (Exception e) {

            System.out.println("*************Excepcion********" + e.getMessage());
            this.con = null;

        }

        return this.con;
    }

    public Connection getConexionDB() {
        return this.conexionColegio();
    }
}
