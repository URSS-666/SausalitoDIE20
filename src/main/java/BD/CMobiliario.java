/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import BD.Database;
import com.toedter.calendar.JDateChooser;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CMobiliario{
public void agregarMobiliario(JTextField nombre, JTextField cantidad, JDateChooser fecha, JTextField descripcion) {
    Database objetoconexion = new Database();
    String consulta = "insert into prueba160225.mobiliario (nombre, cantidad, fecha, descripcion) values (?, ?, ?, ?);";
    System.out.println("Attempting to insert into table: prueba160225.mobiliario");
    System.out.println("Values: nombre=" + nombre.getText().trim() + ", cantidad=" + cantidad.getText().trim() +
                       ", fecha=" + (fecha.getDate() != null ? fecha.getDate().toString() : "null") +
                       ", descripcion=" + descripcion.getText().trim());

    try {
        java.sql.Connection conn = objetoconexion.establecerConexion();
        System.out.println("Connected to database: " + conn.getMetaData().getURL());
        System.out.println("Auto-commit: " + conn.getAutoCommit());
        CallableStatement cs = conn.prepareCall(consulta);
        cs.setString(1, nombre.getText().trim());
        cs.setInt(2, Integer.parseInt(cantidad.getText().trim()));
        Date fechaSeleccionada = fecha.getDate();
        if (fechaSeleccionada != null) {
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(3, fechaSQL);
        } else {
            cs.setNull(3, java.sql.Types.DATE);
        }
        cs.setString(4, descripcion.getText().trim());
        int rowsAffected = cs.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        JOptionPane.showMessageDialog(null, "Se guardó correctamente");
        cs.close();
        conn.close();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: La cantidad debe ser un número entero válido.");
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al guardar: " + e.toString());
        e.printStackTrace();
    }
}

    public void mostrarMobiliario(JTable tablaTotalMobiliario) {
    BD.Database objetoConexion = new BD.Database();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Nombre");
    modelo.addColumn("Cantidad");
    modelo.addColumn("Fecha");
    modelo.addColumn("Descripcion");

    try {
        String sql = "SELECT nombre, cantidad, fecha, descripcion FROM prueba160225.mobiliario";
        java.sql.PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(sql);
        java.sql.ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("nombre"),
                rs.getString("cantidad"),
                rs.getDate("fecha"),
                rs.getString("descripcion")
            });
        }
        tablaTotalMobiliario.setModel(modelo);
        rs.close();
        ps.close();
        objetoConexion.cerrarConexion();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar: " + e.toString());
        e.printStackTrace();
    }
}

}

/*
public class CMobiliario {
    public void agregarMobiliario(JTextField nombre, JTextField cantidad, JDateChooser fecha, JTextField descripcion){
        Database objetoconexion = new Database();
        String consulta = "insert into mobiliario (nombre,cantidad,fecha,descripcion) values (?,?,?,?);";
        try {
            CallableStatement cs = objetoconexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, nombre.getText());
            cs.setInt(2, Integer.parseInt(cantidad.getText()));
            Date fechaSeleccionada = fecha.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(3, fechaSQL);
            cs.setString(4, descripcion.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar"+e.toString());
        }
    }
    public void mostrarMobiliario(JTable tablaTotalMobiliario){
        BD.Database objetoConexion = new BD.Database();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql ="";
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
        tablaTotalMobiliario.setModel(modelo);
    }
}
*/