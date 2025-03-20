/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import com.Vista.secciones.Menu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sofia Useche
 */
public class CMenu {

    private int id;
    private String nombre;
    private JPanel panelSeleccionado;
    private Menu menuInstance;

    public CMenu(Menu menuInstance) {
        this.menuInstance = menuInstance;
    }

    public JPanel getPanelSeleccionado() {
        return panelSeleccionado;
    }

    public CMenu(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public void mostrarCategorias(JComboBox<CMenu> comboCategoria) {
        BD.Database objetoConexion = new BD.Database();
        String sql = "SELECT * FROM prueba160225.categoria";
        Statement st;

        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboCategoria.removeAllItems();
            while (rs.next()) {
                String nombreCategoria = rs.getString("nombre");
                int id = rs.getInt("idcategorias");
                CMenu categoria = new CMenu(id, nombreCategoria);
                comboCategoria.addItem(categoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar categorias: " + e.getMessage());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void agregarMenu(JTextField nombre, JTextField precio, File imagen, JComboBox combocategoria) {
        Database objetoconexion = new Database();
        String consulta = "insert into prueba160225.menu (nombre,precio,imagen,categoria_idcategorias) values (?,?,?,?)";
        try {
            FileInputStream fis = new FileInputStream(imagen);
            CallableStatement cs = objetoconexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, nombre.getText());
            cs.setFloat(2, Float.parseFloat(precio.getText()));
            cs.setBinaryStream(3, fis, (int) imagen.length());
            CMenu categoriaSeleccionada = (CMenu) combocategoria.getSelectedItem();
            int idCategoria = categoriaSeleccionada.getId();
            cs.setInt(4, idCategoria);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar" + e.toString());
        }
    }

    public void mostrarMenu(Map<Integer, JPanel> panelesPorCategoria) {
        Database objetoConexion = new Database();
        String sql = "SELECT codigo, nombre, imagen, categoria_idcategorias FROM prueba160225.menu";

        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            for (JPanel panel : panelesPorCategoria.values()) {
                panel.removeAll();
                panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
                panel.setLayout(new GridLayout(0, 4, 10, 10));
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
    }

    public String obtenerCodigoDelItem() {
        if (panelSeleccionado == null) {
            return null;
        }
        return (String) panelSeleccionado.getClientProperty("codigo");
    }

    public void obtenerDatosCompletos(String codigo) {
        BD.Database objetoConexion = new BD.Database();
        String sql = "SELECT nombre, precio, imagen, categoria_idcategorias FROM prueba160225.menu WHERE codigo = ?";

        try {
            PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                int categoria = rs.getInt("categoria_idcategorias");
                byte[] imgBytes = rs.getBytes("imagen");

                ImageIcon icon = null;
                if (imgBytes != null) {
                    Image img = Toolkit.getDefaultToolkit().createImage(imgBytes);
                    Image resizedImg = img.getScaledInstance(214, 164, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(resizedImg);
                }

                menuInstance.mostrarDatoFormulario(codigo, nombre, precio, categoria, icon);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void modificarMenu(JTextField codigo, JTextField nombre, JTextField precio, File imagen, JComboBox combocategoria) {
        Database objetoConexion = new Database();
        String consulta;
        boolean actualizarImagen = (imagen != null && imagen.exists());

        if (actualizarImagen) {
            consulta = "UPDATE prueba160225.menu SET nombre=?, precio=?, imagen=?, Categoria_id=? WHERE codigo=?";
        } else {
            consulta = "UPDATE prueba160225.menu SET nombre=?, precio=?, Categoria_id=? WHERE codigo=?";
        }

        try {
            PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
            ps.setString(1, nombre.getText());
            ps.setFloat(2, Float.parseFloat(precio.getText()));

            int idCategoria = combocategoria.getSelectedIndex() + 1;
            if (actualizarImagen) {
                FileInputStream fis = new FileInputStream(imagen);
                ps.setBinaryStream(3, fis, (int) imagen.length());
                ps.setInt(4, idCategoria);
                ps.setString(5, codigo.getText());
            } else {
                ps.setInt(3, idCategoria);
                ps.setString(4, codigo.getText());
            }

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro a modificar.");
            }

            imagen = null;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se modificó correctamente: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void eliminarMenu() {
        if (panelSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento del menú para eliminar.");
            return;
        }

        String codigo = obtenerCodigoDelItem();

        Object[] opciones = {"Sí", "No"};
        int confirmacion = JOptionPane.showOptionDialog(
                null,
                "¿Está seguro de eliminar este registro?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[1]
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        Database objetoConexion = new Database();
        String consulta = "DELETE FROM prueba160225.menu WHERE codigo = ?";

        try {
            PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);
            ps.setString(1, codigo);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el menú.");

            Container parent = panelSeleccionado.getParent();
            if (parent != null) {
                parent.remove(panelSeleccionado);
                parent.revalidate();
                parent.repaint();
            }

            panelSeleccionado = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el menú: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    public void limpiarFormulario(JTextField nombre, JTextField precio, JTextField rutaImagen, JLabel imagen, JComboBox combocategoria) {
        nombre.setText("");
        precio.setText("");
        rutaImagen.setText("");
        imagen.setIcon(null);
    }
}
