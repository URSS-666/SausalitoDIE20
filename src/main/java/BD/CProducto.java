/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofia Useche
 */
public class CProducto {
    private int idProveedor;
    private String nombre;
    private int idMarca;
    private int idPresentacion;
    private int idUnidadMedida;

    public void establecerMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    public void establecerPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }
    
    public void establecerUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public CProducto(int idProveedor, String nombre) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public void mostrarMarca(JComboBox comboMarca){
        BD.Database objetoConexion = new BD.Database();
        String sql= "select * from prueba160225.marca";
        Statement st;
        
        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboMarca.removeAllItems();
            while (rs.next()) {                
                String nombreMarca = rs.getString("nombre");
                this.establecerMarca(rs.getInt("idmarca"));
                comboMarca.addItem(nombreMarca);
                comboMarca.putClientProperty(nombreMarca, idMarca);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar marca");
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    public void mostrarPresentacion(JComboBox comboPresentacion){
        BD.Database objetoConexion = new BD.Database();
        String sql= "select * from prueba160225.presentacion";
        Statement st;
        
        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboPresentacion.removeAllItems();
            while (rs.next()) {                
                String nombrePresentacion = rs.getString("nombre");
                this.establecerMarca(rs.getInt("idpresentacion"));
                comboPresentacion.addItem(nombrePresentacion);
                comboPresentacion.putClientProperty(nombrePresentacion, idPresentacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar presentacion");
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    public void mostrarUnidadMedida(JComboBox comboUnidadMedida){
        BD.Database objetoConexion = new BD.Database();
        String sql= "select * from prueba160225.unidadmedida";
        Statement st;
        
        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboUnidadMedida.removeAllItems();
            while (rs.next()) {                
                String nombreUnidadMedida = rs.getString("nombre");
                this.establecerMarca(rs.getInt("idunidad_medida"));
                comboUnidadMedida.addItem(nombreUnidadMedida);
                comboUnidadMedida.putClientProperty(nombreUnidadMedida, idUnidadMedida);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar unidad de medida");
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    public void mostrarProveedores(JComboBox<CProducto> comboProveedores) {
        BD.Database objetoConexion = new BD.Database();
        String sql = "SELECT * FROM categoria";
        Statement st;
        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboProveedores.removeAllItems();
            while (rs.next()) {
                String nombreProveedor = rs.getString("nombre");
                int id = rs.getInt("id");
                CProducto proveedor = new CProducto(id, nombreProveedor);
                comboProveedores.addItem(proveedor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar categorias: " + e.getMessage());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    
    public void agregarBebidas(JTextField nombre, JTextField cantidad, JDateChooser fecha, JTextField precio, JTextField descripcion, JComboBox comboproveedor, JComboBox combomarca, JComboBox combopresentacion, JComboBox combounidadmedida){
        Database objetoconexion = new Database();
        String consulta = "insert into prueba160225.producto (nombre,cantidad,fecha,precio,descripcion,proveedor_idproveedor,presentacion_idpresentacion,marca_idmarca,unidadmedida_idunidad_medida) values (?,?,?,?,?,?,?,?,?);";
        try {
            CallableStatement cs = objetoconexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, nombre.getText());
            cs.setString(2, cantidad.getText());
            Date fechaSeleccionada = fecha.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(3, fechaSQL);
            cs.setFloat(4, Float.parseFloat(precio.getText()));
            cs.setString(5, descripcion.getText());
            int idProveedor = (int) comboproveedor.getClientProperty(comboproveedor.getSelectedItem());
            cs.setInt(6, idProveedor);
            int idMarca = (int) combomarca.getClientProperty(combomarca.getSelectedItem());
            cs.setInt(7, idMarca);
            int idPresentacion = (int) combopresentacion.getClientProperty(combopresentacion.getSelectedItem());
            cs.setInt(8, idPresentacion);
            int idUnidadMedida= (int) combounidadmedida.getClientProperty(combounidadmedida.getSelectedItem());
            cs.setInt(9, idUnidadMedida);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar"+e.toString());
        }
    }
    public void mostrarBebidas(JTable tablaStockBebida){
        BD.Database objetoConexion = new BD.Database();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql ="";
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Presentacion");
        modelo.addColumn("U.M");
        modelo.addColumn("Entradas");
        modelo.addColumn("Salidas");
        modelo.addColumn("Stock");
        tablaStockBebida.setModel(modelo);
        sql = "SELECT producto.codigo,producto.nombre,producto.cantidad,marca.nombre AS marca,presentacion.nombre AS presentacion,unidad_medida.nombre AS unidad_medida \n" +
                "FROM prueba160225.producto \n" +
                "INNER JOIN marca ON producto.marca_idmarca = marca.codigo \n" +
                "INNER JOIN presentacion ON producto.presentacion_idpresentacion = presentacion.codigo \n" +
                "INNER JOIN unidadmedida ON producto.unidadmedida_idunidad_medida = unidadmedida.codigo;";
        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {          
                String codigo = rs.getString("codigo");
                String producto = rs.getString("nombre");
                String cantidad = rs.getString("cantidad");
                String marca = rs.getString("marca");
                String presentacion = rs.getString("presentacion");
                String unidadMedida = rs.getString("unidad_medida");
                modelo.addRow(new Object[]{codigo,producto,marca,presentacion,unidadMedida,cantidad});
                tablaStockBebida.setModel(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar bebidas"+e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    public void Seleccionar(JTable totalGastos, JTextField codigo, JTextField producto, JTextField cantidad,JTextField precio,JDateChooser fecha, JTextField descripcion, JComboBox proveedores, JComboBox marca, JComboBox presectacion, JComboBox unidadMedida) {
        int fila = totalGastos.getSelectedRow();

        if (fila >= 0) {
            BD.Database objetoConexion = new BD.Database();

            try {
                String codigoGasto = totalGastos.getValueAt(fila, 0).toString();
                codigo.setText(codigoGasto);
                producto.setText(totalGastos.getValueAt(fila, 1).toString());
                
                cantidad.setText(totalGastos.getValueAt(fila, 2).toString());

                String sql = "SELECT descripcion, precio, proveedor_codigo FROM gasto WHERE codigo = ?";

                PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(sql);
                ps.setString(1, codigoGasto);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    descripcion.setText(rs.getString("descripcion"));
                    precio.setText(rs.getString("precio"));

                    String proveedorCodigo = rs.getString("proveedor_codigo");

                    for (int i = 0; i < proveedores.getItemCount(); i++) {
                        if (proveedores.getItemAt(i).toString().contains(proveedorCodigo)) {
                            proveedores.setSelectedIndex(i);
                            break;
                        }
                    }
                }

                rs.close();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar: " + e.toString());
            } finally {
                objetoConexion.cerrarConexion();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla.");
        }
    }

    public void modificarGasto(JTextField codigo,JTextField producto, JTextField cantidad, JDateChooser fecha,JTextField precio, JTextField descripcion, JComboBox comboproveedor){
        Database objetoConexion = new Database();
        String consulta = "UPDATE gasto SET gasto.producto=?,gasto.cantidad=?,gasto.fecha=?,gasto.precio=?,"
                + "gasto.descripcion=?,gasto.provedor_codigo=? WHERE gasto.codigo=?";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, producto.getText());
            cs.setString(2, cantidad.getText());
            Date fechaSeleccionada = fecha.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(3, fechaSQL);
            cs.setFloat(4, Float.parseFloat(precio.getText()));
            cs.setString(5, descripcion.getText());
            int idProveedor = (int) comboproveedor.getClientProperty(comboproveedor.getSelectedItem());
            cs.setInt(6, idProveedor);
            cs.setInt(7, Integer.parseInt(codigo.getText()));
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se modifico correctamente"+e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    public void elminarGasto(JTable tablaGastos){
        Database objetoConexion = new Database();
        int[] filasSeleccionadas = tablaGastos.getSelectedRows(); 

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Selecciono un registro.");
            return;
        }
        Object[] opciones = {"Sí", "No"};
        int confirmacion = JOptionPane.showOptionDialog(
            null, 
            "¿Está seguro de eliminar " + filasSeleccionadas.length + " registro(s)?", 
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
        String consulta = "DELETE FROM gasto WHERE gasto.codigo=?;";
        try {
            Connection conexion = objetoConexion.establecerConexion();
            conexion.setAutoCommit(false);
            PreparedStatement ps = conexion.prepareStatement(consulta);

            for (int fila : filasSeleccionadas) {
                String codigo = tablaGastos.getValueAt(fila, 0).toString();
                ps.setInt(1, Integer.parseInt(codigo));
                ps.addBatch(); 
            }
            ps.executeBatch();
            conexion.commit(); 
            JOptionPane.showMessageDialog(null, "Se elimino corretamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se elimino el registro"+e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    public void buscarGasto(JTable tablaUsuarios, String valorBusqueda) {
        Database objetoConexion = new Database();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Proveedor");

        // Evitar errores si el campo de búsqueda está vacío
        if (valorBusqueda.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un producto o proveedor válido.");
            return;
        }

        String sql = "SELECT gasto.codigo, gasto.producto, gasto.cantidad, gasto.fecha, gasto.precio, "
                   + "gasto.descripcion, proveedor.nombre FROM gasto "
                   + "INNER JOIN proveedor ON gasto.provedor_codigo = proveedor.codigo "
                   + "WHERE LOWER(gasto.producto) LIKE LOWER(?) OR LOWER(proveedor.nombre) LIKE LOWER(?)";

        try (Connection conexion = objetoConexion.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Configurar parámetros para buscar coincidencias parciales
            ps.setString(1, "%" + valorBusqueda + "%");
            ps.setString(2, "%" + valorBusqueda + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("codigo");
                fila[1] = rs.getString("producto");
                fila[2] = rs.getString("cantidad");

                // Convertir fecha a formato legible
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechaSQL = rs.getDate("fecha");
                String fechaFormateada = sdf.format(fechaSQL);
                fila[3] = fechaFormateada;

                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("descripcion");
                fila[6] = rs.getString("nombre"); // Proveedor

                modelo.addRow(fila);
            }

            tablaUsuarios.setModel(modelo);

            // Mostrar mensaje si no hay resultados
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados para: " + valorBusqueda);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar gasto: " + e.getMessage());
        }
    }
    public void limpiarFormulario(JTextField producto, JTextField cantidad, JDateChooser fecha, JTextField precio, JTextField descripcion, JComboBox comboproveedor){
        producto.setText("");
        cantidad.setText("");
        Calendar calendario = Calendar.getInstance();
        fecha.setDate(calendario.getTime());
        precio.setText("");
        descripcion.setText("");
    }
}
