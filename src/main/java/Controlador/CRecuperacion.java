package Controlador;

import BD.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class CRecuperacion {
    private Database db = new Database();
    private String correo;
    private String codigoGenerado;  // Guardar el código enviado

    // Constructor sin parámetros
    public CRecuperacion() {
    }

    // Constructor con correo
    public CRecuperacion(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return this.correo;
    }

    // Validar formato de correo
    private boolean esCorreoValido(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return correo.matches(regex);
    }

    // Generar código aleatorio de 6 dígitos
    private String generarCodigo() {
        Random rand = new Random();
        return String.valueOf(100000 + rand.nextInt(900000));
    }

    // Buscar correo en la base de datos y enviar código
    public boolean buscarCorreo() {
        if (!esCorreoValido(correo)) {
        JOptionPane.showMessageDialog(null, "Ingrese un correo válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    Connection con = db.establecerConexion();
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    try {
        String sql = "SELECT rol FROM usuario WHERE correo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String rol = rs.getString("rol");

            if ("Administrador".equalsIgnoreCase(rol)) {
                String codigo = generarCodigo();

                // Guardar el código en la base de datos
                String updateSQL = "UPDATE usuario SET codigo_recuperacion = ? WHERE correo = ?";
                PreparedStatement psUpdate = con.prepareStatement(updateSQL);
                psUpdate.setString(1, codigo);
                psUpdate.setString(2, correo);
                psUpdate.executeUpdate();

                if (enviarCorreo(correo, codigo)) {
                    JOptionPane.showMessageDialog(null, "Se ha enviado un código a tu correo.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al enviar el código.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Solo los administradores pueden recuperar la contraseña.", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El correo no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    } finally {
        db.cerrarConexion();
    }
}

    // Método para verificar si el código ingresado es correcto
    public boolean verificarCodigo(String codigoIngresado) {
    Connection con = db.establecerConexion();
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (correo == null || correo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: No se ha especificado un correo.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT codigo_recuperacion FROM usuario WHERE correo = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, correo);
        rs = ps.executeQuery();

        if (rs.next()) {
            String codigoGuardado = rs.getString("codigo_recuperacion");

            // Comparación con trim() para evitar problemas de espacios en blanco
            if (codigoIngresado.trim().equals(codigoGuardado.trim())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Código incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el correo en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Muestra el error en la consola para depuración
        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    } finally {
        // Cerrar ResultSet y PreparedStatement antes de cerrar la conexión
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            db.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

    // Configurar y enviar correo
    
    private boolean enviarCorreo(String destinatario, String codigo) {
        final String remitente = "asaderoyresturantesausalito@gmail.com";
        final String clave = "fyfn roky ekor eres"; // ⚠️ Usa autenticación de aplicaciones

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Código de Verificación");
            message.setText("Tu código de verificación es: " + codigo);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar la contraseña
    public boolean actualizarContraseña(String nuevaContraseña) {
    if (nuevaContraseña == null || nuevaContraseña.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese la nueva contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    Connection con = db.establecerConexion();
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    try {
        String sql = "UPDATE usuario SET contraseña = ? WHERE correo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nuevaContraseña); // Guardar sin encriptar
        ps.setString(2, correo);
        int filas = ps.executeUpdate();

        if (filas > 0) {
            JOptionPane.showMessageDialog(null, "Contraseña actualizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        db.cerrarConexion();
    }
}

    // Validar fortaleza de contraseña
    private boolean validarFortaleza(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}
