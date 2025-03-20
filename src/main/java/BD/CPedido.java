/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import com.Vista.secciones.Menu;
import com.Vista.secciones.Pedido;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofia Useche
 */
public class CPedido {
    private JPanel panelSeleccionado;
    private Pedido PedidoInstance;

    public CPedido(Pedido PedidoInstance) {
        this.PedidoInstance = PedidoInstance;
    }

    public JPanel getPanelSeleccionado() {
        return panelSeleccionado;
    }
    
    public void mostrarMenu(Map<Integer, JPanel> panelesPorCategoria) {
        Database objetoConexion = new Database();
        String sql = "SELECT codigo, nombre, imagen, categoria_idcategorias FROM prueba160225.menu";

        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            for (JPanel panel : panelesPorCategoria.values()) {
                panel.removeAll();
                panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            }

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int categoriaId = rs.getInt("categoria_idcategorias");
                byte[] imgBytes = rs.getBytes("imagen");

                ImageIcon icon = null;
                if (imgBytes != null) {
                    Image img = Toolkit.getDefaultToolkit().createImage(imgBytes);
                    Image resizedImg = img.getScaledInstance(143, 120, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(resizedImg);
                }

                JPanel itemPanel = new JPanel();
                itemPanel.setPreferredSize(new Dimension(173, 200));
                itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
                itemPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1));
                itemPanel.setBackground(Color.WHITE);

                JLabel lblImagen = new JLabel(icon);
                lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel lblNombre = new JLabel(nombre);
                lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
                lblNombre.setForeground(Color.BLACK);
                lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel lblCodigo = new JLabel(codigo);
                lblCodigo.setVisible(false);

                itemPanel.add(Box.createVerticalStrut(10));
                itemPanel.add(lblImagen);
                itemPanel.add(Box.createVerticalStrut(20));
                itemPanel.add(lblNombre);
                itemPanel.add(lblCodigo);
                itemPanel.add(Box.createVerticalGlue());

                itemPanel.putClientProperty("codigo", codigo);
                itemPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        seleccionarPanel(itemPanel);
                    }
                });

                JPanel panelCategoria = panelesPorCategoria.get(categoriaId);
                if (panelCategoria != null) {
                    panelCategoria.add(itemPanel);
                }
            }

            for (JPanel panel : panelesPorCategoria.values()) {
                panel.revalidate();
                panel.repaint();
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar menú: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    
    public void seleccionarPanel(JPanel panel) {
        if (panelSeleccionado != null) {
            panelSeleccionado.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1));
        }
        panelSeleccionado = panel;
        panelSeleccionado.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 3));
        String codigoSeleccionado = obtenerCodigoDelItem();
        if (codigoSeleccionado != null) {
            obtenerDatosCompletos(codigoSeleccionado); 
        }
    }
    public String obtenerCodigoDelItem() {
        if (panelSeleccionado == null) {
            return null;
        }
        return (String) panelSeleccionado.getClientProperty("codigo"); 
    }
    public void obtenerDatosCompletos(String codigo) {
        BD.Database objetoConexion = new BD.Database();
        String sql = "SELECT nombre, precio FROM prueba160225.menu WHERE codigo = CAST(? AS INTEGER)";

        try {
            PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                        PedidoInstance.mostrarDatoFormulario(codigo, nombre, precio);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    // DIEGO14.03.25:

    public void enviarPedido(JTable jTable3) {
        Database objetoConexion = new Database();
        
        try (Connection conexion = objetoConexion.establecerConexion()) {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            
            // Now insert all rows from the table
            String insertSQL = "INSERT INTO pedido (nombre, cantidad, unidad, total) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    String nombre = model.getValueAt(i, 0).toString();
                    int cantidad = Integer.parseInt(model.getValueAt(i, 1).toString());
                    String unidad = model.getValueAt(i, 2).toString();
                    double total = Double.parseDouble(model.getValueAt(i, 3).toString());

                    ps.setString(1, nombre);
                    ps.setInt(2, cantidad);
                    ps.setString(3, unidad);
                    ps.setDouble(4, total);

                    ps.executeUpdate();
                    
                    // Get the generated key (ID) and store it in the table model
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        model.setValueAt(id, i, 4); // Store ID in hidden column
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, "Pedido enviado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al enviar pedido: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
// DIEGO14.03.25:
    public void guardarPedido(JTable jTable3) {
        Database objetoConexion = new Database();
        
        try (Connection conexion = objetoConexion.establecerConexion()) {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            
            // Now insert all rows from the table
            String insertSQL = "INSERT INTO pedido (nombre, cantidad, unidad, total) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    String nombre = model.getValueAt(i, 0).toString();
                    int cantidad = Integer.parseInt(model.getValueAt(i, 1).toString());
                    String unidad = model.getValueAt(i, 2).toString();
                    double total = Double.parseDouble(model.getValueAt(i, 3).toString());

                    ps.setString(1, nombre);
                    ps.setInt(2, cantidad);
                    ps.setString(3, unidad);
                    ps.setDouble(4, total);

                    ps.executeUpdate();
                    
                    // Get the generated key (ID) and store it in the table model
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        model.setValueAt(id, i, 4); // Store ID in hidden column
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, "Pedido guardado correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar pedido: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void actualizarCantidadEnBD(String nombreProducto, int cantidad, int rowIndex, JTable jTable3) {
        Database objetoConexion = new Database();
        
        try {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            
            // Get the database ID from the hidden column
            Object idObj = model.getValueAt(rowIndex, 4);
            
            if (idObj == null) {
                // This row hasn't been saved to the database yet
                System.out.println("No se puede actualizar: la fila aún no está guardada en la base de datos");
                return;
            }
            
            int id = Integer.parseInt(idObj.toString());
            Connection conn = objetoConexion.establecerConexion();
            
            // First, get the current unit price
            String selectSql = "SELECT unidad FROM pedido WHERE id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();
            
            if (rs.next()) {
                double unidad = rs.getDouble("unidad");
                double nuevoTotal = cantidad * unidad;
                
                // Update by ID to ensure only this specific row is updated
                String updateSql = "UPDATE pedido SET cantidad = ?, total = ? WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, cantidad);
                updateStmt.setDouble(2, nuevoTotal);
                updateStmt.setInt(3, id);
                
                updateStmt.executeUpdate();
                
                // Also update the total in the table model
                model.setValueAt(nuevoTotal, rowIndex, 3);
                
                updateStmt.close();
            }
            
            rs.close();
            selectStmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cantidad: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
// DIEGO14.03.25:
    public void actualizarCantidadEnBD(String nombre, int cantidad, int row, JTable table, boolean mostrarMensajes) {
        Database objetoConexion = new Database();
        
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            // Get the database ID from the hidden column
            Object idObj = model.getValueAt(row, 4);
            
            if (idObj == null) {
                // This row hasn't been saved to the database yet
                System.out.println("No se puede actualizar: la fila aún no está guardada en la base de datos");
                return;
            }
            
            int id = Integer.parseInt(idObj.toString());
            Connection conn = objetoConexion.establecerConexion();
            
            // First, get the current unit price
            String selectSql = "SELECT unidad FROM pedido WHERE id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();
            
            if (rs.next()) {
                double unidad = rs.getDouble("unidad");
                double nuevoTotal = cantidad * unidad;
                
                // Update by ID to ensure only this specific row is updated
                String updateSql = "UPDATE pedido SET cantidad = ?, total = ? WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, cantidad);
                updateStmt.setDouble(2, nuevoTotal);
                updateStmt.setInt(3, id);
                
                updateStmt.executeUpdate();
                
                // Also update the total in the table model
                model.setValueAt(nuevoTotal, row, 3);
                
                updateStmt.close();
            }
            
            rs.close();
            selectStmt.close();
            
            // Only show messages if mostrarMensajes is true
            if (mostrarMensajes) {
                JOptionPane.showMessageDialog(null, "Cantidad actualizada correctamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cantidad: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
// DIEGO14.03.25:
    private Connection obtenerConexion() throws Exception {
        Database objetoConexion = new Database();
        return objetoConexion.establecerConexion();
    }

    // Replace the example method with this implementation:
    public void actualizarCantidadDirecta(String nombre, int cantidad) {
        Database objetoConexion = new Database();
        
        try {
            Connection conn = objetoConexion.establecerConexion();
            
            // First find the product in the pedido table
            String selectSql = "SELECT id, unidad FROM pedido WHERE nombre = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setString(1, nombre);
            ResultSet rs = selectStmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                double unidad = rs.getDouble("unidad");
                double nuevoTotal = cantidad * unidad;
                
                // Update quantity and total
                String updateSql = "UPDATE pedido SET cantidad = ?, total = ? WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, cantidad);
            updateStmt.setDouble(2, nuevoTotal);
                updateStmt.setInt(3, id);
            
                updateStmt.executeUpdate();
updateStmt.close();
            }
            
            rs.close();
            selectStmt.close();
            
        } catch (Exception e) {
            System.out.println("Error en actualización directa: " + e.getMessage());
        }
    }
}
// DIEGO14.03.25: