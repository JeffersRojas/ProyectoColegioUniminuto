
package co.edu.uniminuto.dao;

import co.edu.uniminuto.conexion.ConexionDB;
import co.edu.uniminuto.entity.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EstudianteDao {
    
    //atributos
    private ConexionDB conexionDB;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
        //constructor
    public EstudianteDao() {
        this.conexionDB = new ConexionDB();
        this. statement = null;
        this.resultSet = null;            
    }

    public ResultSet queryEstudiante() {
        Connection myCon = this.conexionDB.getConexionDB();
        String query = "SELECT * FROM estudiantes WHERE est_estatus = 1; ";
        try {
            this.statement = myCon.prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("" + ex.getErrorCode());
        }
        return this.resultSet;
    }
    
   public void registrarEstudiante (Estudiante estudiante){
               Connection myCon = this.conexionDB.getConexionDB();
        String query = "INSERT INTO estudiantes VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
        try {
            if (this.statement == null) {
                this.statement = myCon.prepareStatement(query);
                this.statement.setString(1, estudiante.getEstudianteNombre());
                this.statement.setString(2, estudiante.getEstudianteApellidos());
                this.statement.setInt(3, 1);
                this.statement.setString(4, estudiante.getEstudianteDireccion());
                this.statement.setInt(5, 1); 
                this.statement.setString(6, estudiante.getEstudianteGrado());
                this.statement.setInt(7, 1);
                this.statement.setString(8, estudiante.getEstudianteJornada());
                this.statement.setString(9, estudiante.getEstudianteCorreo());
                this.statement.setInt(10, 1);
                int response = this.statement.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "OK-200 " + response);
                }
            }
} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar");
            System.out.println("" + e.getMessage());
        } finally {
            if (myCon != null) {
                try {
                    this.statement.close();
                    myCon.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteDao.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
