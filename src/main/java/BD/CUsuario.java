
package BD;

import BD.Database;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

public class CUsuario {

    private String usuarioRol = ""; // Variable que almacena el rol del usuario
    
    public String getUsuarioRol() {
        return usuarioRol;
    
}
    //Agregar usuarios
    public void agregarUsuario(JTextField documento, JTextField rol, JTextField nombre, JTextField apellido,
                               JTextField usuario, JTextField contraseña, JTextField correo) {
        
        Database objetoconexion = new Database();
        String consulta = "INSERT INTO usuario (documento, rol, nombre, apellido, usuario,"
                + " contraseña, correo) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (Connection conexion = objetoconexion.establecerConexion();
             CallableStatement cs = conexion.prepareCall(consulta)) {

            // Convertimos el documento a entero  
            cs.setInt(1, Integer.parseInt(documento.getText()));
            cs.setString(2, rol.getText());
            cs.setString(3, nombre.getText());
            cs.setString(4, apellido.getText());
            cs.setString(5, usuario.getText());
            cs.setString(6, contraseña.getText());
            cs.setString(7, correo.getText());

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardó correctamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Documento debe ser un número");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    //Mostrar usuarios 
    public void mostrarUsuarios(JTable tablaTotalUsuario) {
        Database objetoConexion = new Database();
        DefaultTableModel modelo = new DefaultTableModel();

        // Agregar columnas al modelo
        modelo.addColumn("Documento");
        modelo.addColumn("Rol");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Correo");
        modelo.addColumn("Estado");
        String sql = "SELECT * FROM usuario";
        try (Connection conexion = objetoConexion.establecerConexion(); Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("documento");
                fila[1] = rs.getString("rol");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido");
                fila[4] = rs.getString("usuario");
                fila[5] = rs.getString("contraseña");
                fila[6] = rs.getString("correo");
                fila[7] = rs.getString("estado");
                modelo.addRow(fila);
            }
            tablaTotalUsuario.setModel(modelo);
            tablaTotalUsuario.setDefaultRenderer(Object.class, new EstadoRenderer());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los usuarios: " + e.getMessage());
        }
    }

    class EstadoRenderer extends DefaultTableCellRenderer {
        @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean
        isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica si esta es la columna "Estado"
        if (table.getColumnName(column).equals("Estado")) {
            String estado = value.toString();
            if (estado.equals("Activo")) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else if (estado.equals("Inactivo")) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
        } else {
            // Otras columnas mantienen su color normal
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
        }

        return cell;
    }
    }
   
    public boolean iniciarSesion(String usuario, String contraseña) {
        
        Database objetoConexion = new Database();
    String consulta = "SELECT contraseña, rol, estado FROM usuario WHERE usuario = ?";

    try (Connection conexion = objetoConexion.establecerConexion();
         PreparedStatement ps = conexion.prepareStatement(consulta)) {

        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) { 
            String contraseñaBD = rs.getString("contraseña");
            usuarioRol = rs.getString("rol");
            String estado = rs.getString("estado");

            // Verificar si el usuario está inactivo
            if (!estado.equalsIgnoreCase("Activo")) {
                JOptionPane.showMessageDialog(null, "Tu cuenta está inactiva. Contacta al administrador.", "Cuenta Inactiva", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Verificar si la contraseña es correcta
            if (contraseñaBD.equals(contraseña)) {
                return true; // Inicio de sesión exitoso
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

    public void seleccionarUsuario(JTable tablaUsuarios, JTextField documento, JTextField rol, 
            JTextField nombre, JTextField apellido, JTextField usuario, JTextField contraseña, JTextField correo) {
        int fila = tablaUsuarios.getSelectedRow();
        if (fila >= 0) {
            documento.setText(tablaUsuarios.getValueAt(fila, 0).toString());
            rol.setText(tablaUsuarios.getValueAt(fila, 1).toString());
            nombre.setText(tablaUsuarios.getValueAt(fila, 2).toString());
            apellido.setText(tablaUsuarios.getValueAt(fila, 3).toString());
            usuario.setText(tablaUsuarios.getValueAt(fila, 4).toString());
            contraseña.setText(tablaUsuarios.getValueAt(fila, 5).toString());
            correo.setText(tablaUsuarios.getValueAt(fila, 6).toString());
        }
    }

    public void modificarUsuario(JTextField documento, JTextField rol, JTextField nombre, JTextField apellido, 
                             JTextField usuario, JTextField contraseña, JTextField correo) {

        Database objetoConexion = new Database();
        String consulta = "UPDATE usuario SET usuario.documento=?,usuario.rol=?,usuario.nombre=?,usuario.apellido=?,"
                + "usuario.usuario=?,usuario.contraseña=?, usuario.correo=? WHERE usuario.documento=?";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, documento.getText());
            cs.setString(2, rol.getText());
            cs.setString(3, nombre.getText());
            cs.setString(4, apellido.getText());
            cs.setString(5, usuario.getText());
            cs.setString(6, contraseña.getText());
            cs.setString(7, correo.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se modifico correctamente"+e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    };

    public void eliminarUsuario(JTable tablaUsuarios) {
        Database objetoConexion = new Database();
    int[] filasSeleccionadas = tablaUsuarios.getSelectedRows();

    if (filasSeleccionadas.length == 0) { // Validar si se seleccionaron filas
        JOptionPane.showMessageDialog(null, "Seleccione al menos un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Object[] opciones = {"Sí", "No"};
    int confirmacion = JOptionPane.showOptionDialog(
        null,
        "¿Está seguro de eliminar los usuarios seleccionados?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[1]
    );

    if (confirmacion != JOptionPane.YES_OPTION) {
        return; // No se ejecuta la eliminación si el usuario elige "No"
    }

    String consulta = "DELETE FROM usuario WHERE documento=?";

    try {
        Connection conexion = objetoConexion.establecerConexion();
        conexion.setAutoCommit(false); // Desactivar auto-commit para transacción
        PreparedStatement ps = conexion.prepareStatement(consulta);

        for (int fila : filasSeleccionadas) {
            String documento = tablaUsuarios.getValueAt(fila, 0).toString();
            ps.setInt(1, Integer.parseInt(documento));
            ps.addBatch(); // Agregar la consulta al lote
        }

        ps.executeBatch(); // Ejecutar todas las consultas en lote
        conexion.commit(); // Confirmar la transacción
        JOptionPane.showMessageDialog(null, "Usuarios eliminados correctamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        objetoConexion.cerrarConexion();
    }
}


    public void buscarUsuario(JTable tablaUsuarios, String documento) {
        Database objetoConexion = new Database();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Documento");
        modelo.addColumn("Rol");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Correo");

        String sql = "SELECT * FROM usuario WHERE documento = ?";

        try (Connection conexion = objetoConexion.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(documento)); // Convertir a número

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("documento");
                fila[1] = rs.getString("rol");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido");
                fila[4] = rs.getString("usuario");
                fila[5] = rs.getString("contraseña");
                fila[6] = rs.getString("correo");
                modelo.addRow(fila);
            }
            tablaUsuarios.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar usuario: " + e.getMessage());
        }
    }
    public void actualizarEstado(String documento, String nuevoEstado) {
        Database objetoConexion = new Database();
        String consulta = "UPDATE usuario SET estado = ? WHERE documento = ?";

        try (Connection conexion = objetoConexion.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, nuevoEstado);
            ps.setString(2, documento);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar estado: " + e.getMessage());
        }
    }
    public void cambiarEstadoUsuario(JTable tablaUsuarios) {
    int fila = tablaUsuarios.getSelectedRow();
    if (fila < 0) {
        JOptionPane.showMessageDialog(null, "Seleccione un usuario para cambiar su estado.");
        return;
    }

    String documento = tablaUsuarios.getValueAt(fila, 0).toString();
    String estadoActual = tablaUsuarios.getValueAt(fila, 7).toString();
    String nuevoEstado = estadoActual.equalsIgnoreCase("Activo") ? "Inactivo" : "Activo";

    int confirmacion = JOptionPane.showConfirmDialog(null, 
        "¿Desea cambiar el estado del usuario a " + nuevoEstado + "?", 
        "Confirmar", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion != JOptionPane.YES_OPTION) {
        return;
    }

    Database objetoConexion = new Database();
    String consulta = "UPDATE usuario SET estado = ? WHERE documento = ?";

    try (Connection conexion = objetoConexion.establecerConexion(); 
         PreparedStatement ps = conexion.prepareStatement(consulta)) {

        ps.setString(1, nuevoEstado);
        ps.setInt(2, Integer.parseInt(documento));
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
        
        // Refrescar la tabla después del cambio de estado
        mostrarUsuarios(tablaUsuarios);
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cambiar estado: " + e.getMessage());
    }
}
    
}