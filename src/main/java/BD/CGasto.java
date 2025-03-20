
package BD;

import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CGasto {
    int idProveedor;

    public void establecerIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public void mostrarProveedores(JComboBox comboProveedor){
        BD.Database objetoConexion = new BD.Database();
        String sql= "select * from prueba160225.proveedor";
        Statement st;
        
        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboProveedor.removeAllItems();
            while (rs.next()) {                
                String nombreProveedor = rs.getString("nombre");
                this.establecerIdProveedor(rs.getInt("idproveedor"));
                comboProveedor.addItem(nombreProveedor);
                comboProveedor.putClientProperty(nombreProveedor, idProveedor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar proveedor");
        }
        finally{
            objetoConexion.cerrarConexion();
        }
        }
    public void agregarGasto(JTextField producto, JTextField cantidad, JDateChooser fecha, JTextField precio, JTextField descripcion, JComboBox comboproveedor){
        Database objetoconexion = new Database();
        String consulta = "insert into prueba160225.gasto (producto,cantidad,fecha,precio,descripcion,proveedor_idproveedor) values (?,?,?,?,?,?);";
        try {
            CallableStatement cs = objetoconexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, producto.getText().trim());
            cs.setString(2, cantidad.getText().trim());
            Date fechaSeleccionada = fecha.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(3, fechaSQL);
            cs.setFloat(4, Float.parseFloat(precio.getText().trim()));
            cs.setString(5, descripcion.getText().trim());
            int idProveedor = (int) comboproveedor.getClientProperty(comboproveedor.getSelectedItem());
            cs.setInt(6, idProveedor);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar"+e.toString());
        }
    }
    public void mostrarGasto(JTable tablaTotalGasto){
        BD.Database objetoConexion = new BD.Database();
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) { 
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        String sql ="";
        modelo.addColumn("Seleccionar");
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Proveedor");
        tablaTotalGasto.setModel(modelo);
        sql = "select gasto.idgasto,gasto.producto,gasto.cantidad,gasto.fecha,gasto.precio,gasto.descripcion,proveedor.nombre from prueba160225.gasto INNER JOIN prueba160225.proveedor ON gasto.proveedor_idproveedor = proveedor.idproveedor ORDER BY gasto.idgasto ASC;";
        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {          
                String codigo = rs.getString("idgasto");
                String producto = rs.getString("producto");
                String cantidad = rs.getString("cantidad");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fechaSQL = rs.getDate("fecha");
                String nuevaFecha = sdf.format(fechaSQL);
                String precio = rs.getString("precio");
                String descripcion = rs.getString("descripcion");
                String proveedor = rs.getString("nombre");
                modelo.addRow(new Object[]{false,codigo,producto,cantidad,nuevaFecha,precio,descripcion,proveedor});
                tablaTotalGasto.setModel(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar gastos"+e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
    }
    }
    public void Seleccionar(JTable totalGastos,JTextField codigo,JTextField producto,JTextField cantidad,JDateChooser fecha,JTextField precio,JTextField descripcion, JComboBox proveedores){
        int fila = -1; 
        for (int i = 0; i < totalGastos.getRowCount(); i++) {
            Boolean seleccionado = (Boolean) totalGastos.getValueAt(i, 0); 
            if (seleccionado) {
                fila = i; 
                break;  
            }
        }
        if (fila>=0) {
            codigo.setText(totalGastos.getValueAt(fila, 1).toString());
            producto.setText(totalGastos.getValueAt(fila, 2).toString());
            cantidad.setText(totalGastos.getValueAt(fila, 3).toString());
            String fechaString = totalGastos.getValueAt(fila, 4).toString();
            precio.setText(totalGastos.getValueAt(fila, 5).toString());
            descripcion.setText(totalGastos.getValueAt(fila, 6).toString());
            proveedores.setSelectedItem(totalGastos.getValueAt(fila, 7).toString());
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechDate = sdf.parse(fechaString);
                fecha.setDate(fechDate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar"+e.toString());
            }
        }
    }
    public void modificarGasto(JTextField codigo,JTextField producto, JTextField cantidad, JDateChooser fecha,JTextField precio, JTextField descripcion, JComboBox comboproveedor){
        Database objetoConexion = new Database();
        String consulta = "UPDATE prueba160225.gasto SET producto=?,cantidad=?,fecha=?,precio=?,descripcion=?,proveedor_idproveedor=? WHERE idgasto=?";
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
        String consulta = "DELETE FROM prueba160225.gasto WHERE gasto.idgasto=?;";
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

        String sql = "SELECT gasto.idgasto, gasto.producto, gasto.cantidad, gasto.fecha, gasto.precio, "
                   + "gasto.descripcion, proveedor.nombre FROM prueba160225.gasto "
                   + "INNER JOIN prueba160225.proveedor ON gasto.proveedor_idproveedor = proveedor.idproveedor "
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
