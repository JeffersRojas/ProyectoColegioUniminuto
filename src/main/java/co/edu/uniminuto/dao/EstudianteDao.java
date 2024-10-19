
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
import javax.swing.JTable;
import javax.swing.JTextField;


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
        String query = "SELECT * FROM estudiantes WHERE est_estatus = 1;";
    
        try {
            this.statement = myCon.prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            return this.resultSet; 
        } catch (SQLException ex) {
            System.out.println("Error Code: " + ex.getErrorCode());
            return null; 
            }
    }
    
   public void registrarEstudiante (Estudiante estudiante){
               Connection myCon = this.conexionDB.getConexionDB();
        String query = "INSERT INTO estudiantes VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
        try {
            if (this.statement == null) {
                this.statement = myCon.prepareStatement(query);
                this.statement.setString(1, estudiante.getEstudianteNombre());
                this.statement.setString(2, estudiante.getEstudianteApellidos());
                this.statement.setInt(3, estudiante.getEstudianteEdad());
                this.statement.setString(4, estudiante.getEstudianteDireccion());
                this.statement.setInt(5, estudiante.getEstudianteTelefono()); 
                this.statement.setString(6, estudiante.getEstudianteGrado());
                this.statement.setInt(7, estudiante.getEstudianteCurso());
                this.statement.setString(8, estudiante.getEstudianteJornada());
                this.statement.setString(9, estudiante.getEstudianteCorreo());
                this.statement.setInt(10, 1);
                int response = this.statement.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "Alumno registrado correctamente " + response);
                }
            }
} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo registrar");
            System.out.println("" + e.getMessage());
        } 
    }
   
   public void SeleccionarAlumnos (JTable paramtableestudiantes, JTextField paramid, JTextField paramnombre, JTextField paramapellido, JTextField paramedad, JTextField paramdirreccion, JTextField paramtelefono, JTextField paramGrado, JTextField paramcurso, JTextField paramjornada, JTextField paramcorreo, JTextField parid){
       try {
           int fila=paramtableestudiantes.getSelectedRow();
           
           if (fila >=0){
            paramid.setText((String)paramtableestudiantes.getValueAt(fila, 0).toString());
            paramnombre.setText((String)paramtableestudiantes.getValueAt(fila, 1).toString());
            paramapellido.setText((String) paramtableestudiantes.getValueAt(fila, 2).toString());
            paramedad.setText((String)paramtableestudiantes.getValueAt(fila, 3).toString());
            paramdirreccion.setText((String)paramtableestudiantes.getValueAt(fila, 4).toString());
            paramtelefono.setText((String)paramtableestudiantes.getValueAt(fila, 5).toString());
            paramGrado.setText((String)paramtableestudiantes.getValueAt(fila, 6).toString());
            paramcurso.setText((String)paramtableestudiantes.getValueAt(fila, 7).toString());
            paramjornada.setText((String)paramtableestudiantes.getValueAt(fila, 8).toString());
            paramcorreo.setText((String)paramtableestudiantes.getValueAt(fila, 9).toString());
            parid.setText((String)paramtableestudiantes.getValueAt(fila, 0).toString());
           }
           else{
           JOptionPane.showMessageDialog(null, "Fila no seleccionada");
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
       }
   }
 
    public void ActualizarAlumnos(Estudiante estudiante, JTextField paramid) {
    Connection myCon = this.conexionDB.getConexionDB();
    String query = "UPDATE estudiantes SET est_nombre = ?, est_apellidos = ?, est_edad = ?, "
            + "est_direccion = ?, est_telefono = ?, est_grado = ?, est_curso = ?, est_jornada = ?, "
            + "est_correo = ? WHERE est_id = ?";

    try {
        if (this.statement == null) {
            this.statement = myCon.prepareStatement(query);
            this.statement.setString(1, estudiante.getEstudianteNombre());
            this.statement.setString(2, estudiante.getEstudianteApellidos());
            this.statement.setInt(3, estudiante.getEstudianteEdad());
            this.statement.setString(4, estudiante.getEstudianteDireccion());
            this.statement.setInt(5, estudiante.getEstudianteTelefono());
            this.statement.setString(6, estudiante.getEstudianteGrado());
            this.statement.setInt(7, estudiante.getEstudianteCurso());
            this.statement.setString(8, estudiante.getEstudianteJornada());
            this.statement.setString(9, estudiante.getEstudianteCorreo());
            this.statement.setInt(10, Integer.parseInt(paramid.getText())); // ID del estudiante a actualizar

            int response = this.statement.executeUpdate();
            if (response > 0) {
                JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar estudiante: " + ex.getMessage());
    } finally {
        try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (myCon != null) {
                myCon.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
   public void DardebajaAlumnos (Estudiante estudiante,JTable paramtableestudiantes, JTextField paramid){
       Connection myCon = this.conexionDB.getConexionDB();
       String SQL = "UPDATE estudiantes SET est_estatus = 0 WHERE est_id = ?;";
       
       try {
            
            this.statement = myCon.prepareStatement(SQL);
            this.statement.setInt(1, Integer.parseInt(paramid.getText()));
            
            int response = this.statement.executeUpdate();
            if (response > 0) {
                JOptionPane.showMessageDialog(null, "Estudiante dado de baja");
            }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
       }
       
   
   }
}
