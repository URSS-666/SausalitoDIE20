
package Vista;

import BD.CUsuario;
import Controlador.OlvidoContraseña;
import Controlador.Sesion;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;



public class Login extends javax.swing.JFrame {
private CUsuario usuarioActual;

    
    public Login() {
      initComponents();
      setVisible(true);
      setLocationRelativeTo(null); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelDegradado = new javax.swing.JPanel();
        ingreso = new javax.swing.JPanel();
        Entrar = new javax.swing.JButton();
        Mostrar = new javax.swing.JCheckBox();
        InicioSesion = new javax.swing.JLabel();
        OlvidoContraseña = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txUsuario = new RSMaterialComponent.RSTextFieldMaterialIcon();
        TxtPassword = new RSMaterialComponent.RSPasswordMaterialIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        JPanelDegradado.setBackground(java.awt.SystemColor.controlShadow);
        JPanelDegradado.setForeground(new java.awt.Color(242, 242, 242));
        JPanelDegradado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanelDegradadoMouseClicked(evt);
            }
        });

        ingreso.setBackground(new java.awt.Color(255, 255, 255));
        ingreso.setForeground(new java.awt.Color(255, 255, 255));
        ingreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoMouseClicked(evt);
            }
        });
        ingreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Entrar.setBackground(new java.awt.Color(58, 179, 28));
        Entrar.setForeground(new java.awt.Color(255, 255, 255));
        Entrar.setText("Entrar");
        Entrar.setToolTipText("");
        Entrar.setBorder(null);
        Entrar.setBorderPainted(false);
        Entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });
        ingreso.add(Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 473, 171, 40));

        Mostrar.setBackground(new java.awt.Color(255, 255, 255));
        Mostrar.setForeground(new java.awt.Color(0, 0, 0));
        Mostrar.setText("Mostrar");
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        ingreso.add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 393, -1, -1));

        InicioSesion.setBackground(new java.awt.Color(153, 153, 153));
        InicioSesion.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        InicioSesion.setForeground(new java.awt.Color(102, 102, 102));
        InicioSesion.setText("Inicio de sesión");
        InicioSesion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ingreso.add(InicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 150, 40));

        OlvidoContraseña.setForeground(new java.awt.Color(58, 179, 28));
        OlvidoContraseña.setText("Olvido su contraseña");
        OlvidoContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OlvidoContraseñaMouseClicked(evt);
            }
        });
        ingreso.add(OlvidoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 441, -1, 20));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Usuario:");
        ingreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 272, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña:");
        ingreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 329, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo2.png"))); // NOI18N
        ingreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, 230));

        txUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txUsuario.setColorIcon(new java.awt.Color(153, 153, 153));
        txUsuario.setColorMaterial(new java.awt.Color(102, 102, 102));
        txUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON_OUTLINE);
        txUsuario.setPhColor(new java.awt.Color(51, 51, 51));
        txUsuario.setPlaceholder("Ingrese su usuario");
        txUsuario.setSelectionColor(new java.awt.Color(51, 51, 51));
        txUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUsuarioActionPerformed(evt);
            }
        });
        ingreso.add(txUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 294, -1, 30));

        TxtPassword.setForeground(new java.awt.Color(51, 51, 51));
        TxtPassword.setColorIcon(new java.awt.Color(102, 102, 102));
        TxtPassword.setColorMaterial(new java.awt.Color(102, 102, 102));
        TxtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TxtPassword.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK_OUTLINE);
        TxtPassword.setPhColor(new java.awt.Color(51, 51, 51));
        TxtPassword.setPlaceholder("Ingrese su contraseña");
        ingreso.add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 351, -1, 30));

        javax.swing.GroupLayout JPanelDegradadoLayout = new javax.swing.GroupLayout(JPanelDegradado);
        JPanelDegradado.setLayout(JPanelDegradadoLayout);
        JPanelDegradadoLayout.setHorizontalGroup(
            JPanelDegradadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelDegradadoLayout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        JPanelDegradadoLayout.setVerticalGroup(
            JPanelDegradadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelDegradadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelDegradado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelDegradado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
            
    String usuario = txUsuario.getText();
    String contraseña = String.valueOf(TxtPassword.getPassword());

    if (usuario.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    CUsuario objetoUsuario = new CUsuario();
    
    if (objetoUsuario.iniciarSesion(usuario, contraseña)) {
    Sesion.setUsuarioActual(objetoUsuario); // Guarda el usuario en la sesión

    String rolUsuario = objetoUsuario.getUsuarioRol(); 
    System.out.println("Usuario logueado como: " + rolUsuario);

    JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
    this.dispose();

    secciones ventanaPrincipal = new secciones();
    ventanaPrincipal.setVisible(true);
    
    // Verificar si la sesión está correctamente establecida antes de configurar la interfaz
    if (Sesion.getUsuarioActual() != null) {
        ventanaPrincipal.configurarInterfazSegunRol(Sesion.getUsuarioActual());
    } else {
        JOptionPane.showMessageDialog(null, "Error: No se pudo establecer la sesión.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_EntrarActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
        if (Mostrar.isSelected()) {
            TxtPassword.setEchoChar((char) 0);  // Muestra la contraseña
        } else {
            TxtPassword.setEchoChar('*');  // Oculta la contraseña
        }
    }//GEN-LAST:event_MostrarActionPerformed

    private void ingresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoMouseClicked
       
        ingreso.setOpaque(false);
    }//GEN-LAST:event_ingresoMouseClicked

    private void JPanelDegradadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanelDegradadoMouseClicked

    }//GEN-LAST:event_JPanelDegradadoMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        setLayout(new BorderLayout());
    }//GEN-LAST:event_formMouseClicked

    private void txUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUsuarioActionPerformed

    private void OlvidoContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OlvidoContraseñaMouseClicked
        OlvidoContraseña recuperar = new OlvidoContraseña();
        recuperar.setVisible(true);
        recuperar.setLocationRelativeTo(null);
          
    }//GEN-LAST:event_OlvidoContraseñaMouseClicked

    public static void main(String args[]) {
   
        try {
            UIManager.setLookAndFeel(new FlatGitHubIJTheme()); // Usa FlatLaf correctamente
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Luego, abre la ventana normalmente
        new Login().setVisible(true);
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatGitHubIJTheme.setup();

  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Entrar;
    private javax.swing.JLabel InicioSesion;
    private javax.swing.JPanel JPanelDegradado;
    private javax.swing.JCheckBox Mostrar;
    private javax.swing.JLabel OlvidoContraseña;
    private RSMaterialComponent.RSPasswordMaterialIcon TxtPassword;
    private javax.swing.JPanel ingreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private RSMaterialComponent.RSTextFieldMaterialIcon txUsuario;
    // End of variables declaration//GEN-END:variables
}
