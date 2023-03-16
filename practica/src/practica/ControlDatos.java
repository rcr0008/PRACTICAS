package practica;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlDatos {

    private Conectar conectar;
    private ModeloDatos modelo;
    private Connection con;

    public ControlDatos() {
        conectar = new Conectar();
        modelo = new ModeloDatos();
    }

    public void insertar(String nombre, String apellidos, int nota, int NumClase) {
        PreparedStatement ps;
        String sql;
        modelo.setNombre(nombre);
        modelo.setApellidos(apellidos);
        modelo.setNota(nota);
        modelo.setNumClase(NumClase);
        try {
            con = conectar.getConexion();
            sql = "insert into alumnos(nombre , apellidos , nota ,NumClase) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellidos());
            ps.setInt(3, modelo.getNota());
            ps.setInt(4, modelo.getNumClase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }

    public void borrar(int NumClase) {
        PreparedStatement ps;
        String sql;
        modelo.setNumClase(NumClase);
        try {
            con = conectar.getConexion();
            sql = "DELETE FROM alumnos WHERE NumClase=?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, modelo.getNumClase());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado correctamente" + e.getMessage());
        }
    }

    public void modificar(int NumClase, int Nota) {
        
        PreparedStatement ps;
        String sql;
        modelo.setNumClase(NumClase);
        modelo.setNota(Nota);
        try {
            con = conectar.getConexion();
            sql = "UPDATE alumnos SET Nota = ? WHERE NumClase= ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, modelo.getNota());

            ps.setInt(2, modelo.getNumClase());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha modificado correctamente" + e.getMessage());
        }
    }
}
