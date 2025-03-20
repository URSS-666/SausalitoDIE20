package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CMesas {
    private final Database db;

    public CMesas() {
        this.db = new Database();
    }

    // Agregar mesa
    public void agregarMesa(JTextField id, JTextField estado) {
        String consulta = "INSERT INTO prueba160225.Mesa (id, estado) VALUES (?, ?)";

        try (Connection conexion = db.establecerConexion();
             CallableStatement cs = conexion.prepareCall(consulta)) {

            if (!id.getText().trim().isEmpty()) {
                cs.setInt(1, Integer.parseInt(id.getText().trim()));
            } else {
                cs.setNull(1, java.sql.Types.INTEGER); // Usa SERIAL si está vacío
            }
            cs.setString(2, estado.getText().trim().toUpperCase()); // Convertir a mayúsculas para coincidir con enum

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardó correctamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ID debe ser un número entero.");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.toString());
            e.printStackTrace();
        } finally {
            db.cerrarConexion();
        }
    }

    // Mostrar mesas
    public void mostrarMesas(JTable tablaTotalMesas) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Estado");

        String sql = "SELECT id, estado FROM prueba160225.Mesa";

        try (Connection conexion = db.establecerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("estado");
                modelo.addRow(fila);
            }
            tablaTotalMesas.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar las mesas: " + e.toString());
            e.printStackTrace();
        } finally {
            db.cerrarConexion();
        }
    }

    // Modificar mesa
    public void modificarMesa(JTextField id, JTextField estado) {
        String consulta = "UPDATE prueba160225.Mesa SET estado = ? WHERE id = ?";

        try (Connection conexion = db.establecerConexion();
             CallableStatement cs = conexion.prepareCall(consulta)) {

            cs.setString(1, estado.getText().trim().toUpperCase());
            cs.setInt(2, Integer.parseInt(id.getText().trim()));

            int rowsAffected = cs.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la mesa con ese ID");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ID debe ser un número entero.");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.toString());
            e.printStackTrace();
        } finally {
            db.cerrarConexion();
        }
    }

    // Eliminar mesa
    public void eliminarMesa(JTable tablaMesas) {
        int[] filasSeleccionadas = tablaMesas.getSelectedRows();

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione al menos una mesa para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null,
            "¿Está seguro de eliminar las mesas seleccionadas?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        String consulta = "DELETE FROM prueba160225.Mesa WHERE id = ?";

        try (Connection conexion = db.establecerConexion()) {
            conexion.setAutoCommit(false);
            try (CallableStatement cs = conexion.prepareCall(consulta)) {
                for (int fila : filasSeleccionadas) {
                    int id = (int) tablaMesas.getValueAt(fila, 0);
                    cs.setInt(1, id);
                    cs.addBatch();
                }
                cs.executeBatch();
                conexion.commit();
                JOptionPane.showMessageDialog(null, "Mesas eliminadas correctamente.");
            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar mesas: " + e.toString());
            e.printStackTrace();
        } finally {
            db.cerrarConexion();
        }
    }

    // Buscar mesa
    public void buscarMesa(JTable tablaMesas, String criterio) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Estado");

        String sql = "SELECT id, estado FROM prueba160225.Mesa WHERE id::TEXT ILIKE ? OR estado ILIKE ?";

        try (Connection conexion = db.establecerConexion();
             CallableStatement cs = conexion.prepareCall(sql)) {

            String likeCriterio = "%" + criterio.trim() + "%";
            cs.setString(1, likeCriterio);
            cs.setString(2, likeCriterio);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[2];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("estado");
                modelo.addRow(fila);
            }
            tablaMesas.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar mesa: " + e.toString());
            e.printStackTrace();
        } finally {
            db.cerrarConexion();
        }
    }

    // Seleccionar mesa
    public void seleccionarMesa(JTable tablaMesas, JTextField id, JTextField estado) {
        int fila = tablaMesas.getSelectedRow();
        if (fila >= 0) {
            id.setText(tablaMesas.getValueAt(fila, 0).toString());
            estado.setText(tablaMesas.getValueAt(fila, 1).toString());
        }
    }
}