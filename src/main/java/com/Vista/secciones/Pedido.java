/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.Vista.secciones;

import BD.CPedido;
import Secciones.Menu.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractCellEditor;
import java.awt.Frame;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import Vista.secciones;
import static Vista.secciones.Principal;
import java.io.*;


public class Pedido extends javax.swing.JPanel {
    
    
    private Mesas mesas; // Referencia a la clase Mesas
    private int mesaActual; // Índice de la mesa actual
    private CPedido objetoPedido;
    
    public Pedido(Mesas mesas, int mesaActual) {
        this.mesas = mesas; // Inicializar la referencia a Mesas
        this.mesaActual = mesaActual; // Guardar el índice de la mesa actual
        
        initComponents();
        //iniCarnes();
        objetoPedido = new CPedido(this);
        mostrarMenu();
        desabilitarformulario();
    }

    /*public Pedido() {
        initComponents();
        desabilitarformulario();
        objetoPedido = new CPedido(this);
        mostrarMenu();
    }*/
// DIEGO14.03.25:
    private void incrementarNumero() {
    try {
        // Obtener el valor actual del JTextArea
        String texto = jTextAreaO.getText().trim();

        // Verificar si el texto no está vacío y convertirlo a un número
        int numero = 0;
        if (!texto.isEmpty()) {
            numero = Integer.parseInt(texto);
        }

        // Incrementar el número
        numero++;

        // Actualizar el JTextArea con el nuevo valor
        jTextAreaO.setText(String.valueOf(numero));

    } catch (NumberFormatException e) {
        // Si no se puede convertir el texto a un número, mostrar un error
        JOptionPane.showMessageDialog(this, "El valor en el área de texto no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// DIEGO14.03.25:
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelCubierta = new javax.swing.JTabbedPane();
        Cubierta1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        Cubierta2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextAreaO = new javax.swing.JTextArea();
        jTextAreaM = new javax.swing.JTextArea();
        Cubierta3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPedido = new javax.swing.JButton();
        Seccion = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        PanelCarnes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        PanelDelChef = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        PanelEjecutivo = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        PanelSopas = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        PanelPescado = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        PanelBebida = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        PanelAdicional = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        Cubierta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jlNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Salida.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Cantidad");

        jSpinner1.setBorder(null);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Observaciones");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 51, 51));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Cancelar");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(58, 179, 28));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Aceptar");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(126, 126, 126)
                            .addComponent(jLabel6))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(62, 62, 62)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        Cubierta1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 310, 250));

        PanelCubierta.addTab("tab1", Cubierta1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Orden detalle");

        jLabel3.setText("Mesa:");

        jButton8.setBackground(new java.awt.Color(58, 179, 28));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Eliminar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(58, 179, 28));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Enviar Pedido");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(58, 179, 28));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Facturar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(58, 179, 28));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("X");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "IVU", "Total"
            }
        ));
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setGridColor(new java.awt.Color(204, 204, 204));
        jTable3.setRowHeight(30);
        jTable3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable3.setShowGrid(true);
        jScrollPane3.setViewportView(jTable3);

        jLabel4.setText("Orden:");

        jTextAreaO.setColumns(20);
        jTextAreaO.setRows(5);

        jTextAreaM.setColumns(20);
        jTextAreaM.setRows(5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jButton7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton8)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextAreaO, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextAreaM, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextAreaO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAreaM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout Cubierta2Layout = new javax.swing.GroupLayout(Cubierta2);
        Cubierta2.setLayout(Cubierta2Layout);
        Cubierta2Layout.setHorizontalGroup(
            Cubierta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cubierta2Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        Cubierta2Layout.setVerticalGroup(
            Cubierta2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cubierta2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        PanelCubierta.addTab("tab2", Cubierta2);

        jPanel5.setPreferredSize(new java.awt.Dimension(584, 500));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 179, 28));
        jLabel5.setText("Facturar");

        jSeparator2.setBackground(new java.awt.Color(102, 51, 255));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jButton3.setText("X");
        jButton3.setAutoscrolls(true);
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(58, 179, 28));
        jLabel7.setText("Método de pago");

        jButton4.setBackground(new java.awt.Color(58, 179, 28));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Efectivo");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBox3.setBackground(new java.awt.Color(58, 179, 28));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Billeteras digitales", "Nequi", "Daviplata", "Dale!", "Movii", "Tpaga" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setBackground(new java.awt.Color(58, 179, 28));
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bancos pago con tarjeta", "Bancolombia", "Davivienda", "Banco de Bogotá", "BBVA Colombia", "Banco Popular", "Citibank", "Scotiabank", "Santander", "Bancos regionales y cooperativas:", "Banco de Occidente", "Banco AV Villas", "Banco Caja Social", "Cooperativas financieras locales" }));
        jComboBox4.setBorder(null);
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Tarjeta debito");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("Tarjeta credito");

        jLabel8.setText("Numero de mesa:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Dinero en efectivo recibido:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(58, 179, 28));
        jLabel10.setText("Confirmacion de pedido ");

        jLabel11.setText("Subtotal:");

        jLabel12.setText("Descuento:");

        jLabel13.setText("TOTAL:");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(58, 179, 28));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("<html><div style=\"text-align:center;\">Confirmar<br>pago</div></html> ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel14.setText("Entrega cliente:");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel13)
                                        .addComponent(jTextField5)
                                        .addComponent(jTextField8)
                                        .addComponent(jLabel12)
                                        .addComponent(jTextField6)
                                        .addComponent(jTextField7)
                                        .addComponent(jLabel7)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel9)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jCheckBox4)
                                        .addGap(27, 27, 27)
                                        .addComponent(jCheckBox3))
                                    .addComponent(jLabel10)
                                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9)))
                                .addGap(7, 7, 7))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(40, 40, 40))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jComboBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox3))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(264, 264, 264))
        );

        jScrollPane2.setViewportView(jPanel6);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout Cubierta3Layout = new javax.swing.GroupLayout(Cubierta3);
        Cubierta3.setLayout(Cubierta3Layout);
        Cubierta3Layout.setHorizontalGroup(
            Cubierta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cubierta3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        Cubierta3Layout.setVerticalGroup(
            Cubierta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Cubierta3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCubierta.addTab("tab3", Cubierta3);

        jPanel1.add(PanelCubierta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 710));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Menu");

        btnPedido.setBackground(new java.awt.Color(58, 179, 28));
        btnPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnPedido.setText("Pedido");
        btnPedido.setBorder(null);
        btnPedido.setBorderPainted(false);
        btnPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        Seccion.setBackground(new java.awt.Color(255, 255, 255));
        Seccion.setForeground(new java.awt.Color(51, 51, 51));
        Seccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        PanelCarnes.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelCarnesLayout = new javax.swing.GroupLayout(PanelCarnes);
        PanelCarnes.setLayout(PanelCarnesLayout);
        PanelCarnesLayout.setHorizontalGroup(
            PanelCarnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        PanelCarnesLayout.setVerticalGroup(
            PanelCarnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(PanelCarnes);

        Seccion.addTab("Carnes", jScrollPane5);

        PanelDelChef.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelDelChefLayout = new javax.swing.GroupLayout(PanelDelChef);
        PanelDelChef.setLayout(PanelDelChefLayout);
        PanelDelChefLayout.setHorizontalGroup(
            PanelDelChefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        PanelDelChefLayout.setVerticalGroup(
            PanelDelChefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(PanelDelChef);

        Seccion.addTab("Del Chef", jScrollPane6);

        PanelEjecutivo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelEjecutivoLayout = new javax.swing.GroupLayout(PanelEjecutivo);
        PanelEjecutivo.setLayout(PanelEjecutivoLayout);
        PanelEjecutivoLayout.setHorizontalGroup(
            PanelEjecutivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        PanelEjecutivoLayout.setVerticalGroup(
            PanelEjecutivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(PanelEjecutivo);

        Seccion.addTab("Ejecutivo", jScrollPane7);

        PanelSopas.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelSopasLayout = new javax.swing.GroupLayout(PanelSopas);
        PanelSopas.setLayout(PanelSopasLayout);
        PanelSopasLayout.setHorizontalGroup(
            PanelSopasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        PanelSopasLayout.setVerticalGroup(
            PanelSopasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jScrollPane8.setViewportView(PanelSopas);

        Seccion.addTab("Sopas", jScrollPane8);

        PanelPescado.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelPescadoLayout = new javax.swing.GroupLayout(PanelPescado);
        PanelPescado.setLayout(PanelPescadoLayout);
        PanelPescadoLayout.setHorizontalGroup(
            PanelPescadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );
        PanelPescadoLayout.setVerticalGroup(
            PanelPescadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jScrollPane9.setViewportView(PanelPescado);

        Seccion.addTab("Pescados", jScrollPane9);

        PanelBebida.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelBebidaLayout = new javax.swing.GroupLayout(PanelBebida);
        PanelBebida.setLayout(PanelBebidaLayout);
        PanelBebidaLayout.setHorizontalGroup(
            PanelBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        PanelBebidaLayout.setVerticalGroup(
            PanelBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(PanelBebida);

        Seccion.addTab("Bebidas", jScrollPane10);

        PanelAdicional.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelAdicionalLayout = new javax.swing.GroupLayout(PanelAdicional);
        PanelAdicional.setLayout(PanelAdicionalLayout);
        PanelAdicionalLayout.setHorizontalGroup(
            PanelAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        PanelAdicionalLayout.setVerticalGroup(
            PanelAdicionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jScrollPane11.setViewportView(PanelAdicional);

        Seccion.addTab("Adicionales", jScrollPane11);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons_back.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 484, Short.MAX_VALUE)
                .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Seccion, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(616, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 60, Short.MAX_VALUE)
                    .addComponent(Seccion, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // DIEGO14.03.25:
        
        String nombre = jlNombre.getText();
       int cantidad = (int) jSpinner1.getValue();
    
       // Validar que la cantidad no sea negativa
       if (cantidad <= 0) {
           JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       // Verificar que el nombre no esté vacío
       if (nombre.trim().isEmpty()) {
           JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       // Obtener el precio unitario desde el JTextField 'txtPrecio'
       float precioUnitario;
       try {
           precioUnitario = Float.parseFloat(txtPrecio.getText());
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "El precio unitario debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }

       // Calcular el total
       double total = cantidad * precioUnitario;

       // Restablecer el valor del JSpinner a 0
       jSpinner1.setValue(0);

       // Actualizar la tabla con la nueva fila
       DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
       model.addRow(new Object[]{nombre, cantidad, precioUnitario, total});

       // Ocultar los paneles
       Cubierta2.setVisible(false);
       PanelCubierta.setVisible(false);
        
       // DIEGO14.03.25:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // DIEGO14.03.25:
        int selectedRow = jTable3.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.removeRow(selectedRow);
        }
        // DIEGO14.03.25:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   // DIEGO14.03.25:
        
        try {
        // Create a temporary table with the same data but proper column structure
        DefaultTableModel currentModel = (DefaultTableModel) jTable3.getModel();
        DefaultTableModel tempModel = new DefaultTableModel(
            new String[]{"Nombre", "Cantidad", "IVU", "Total", "ID"}, 0);
            
        // Copy all rows from the existing table to the temporary table
        for (int i = 0; i < currentModel.getRowCount(); i++) {
            Object[] rowData = new Object[5];
            rowData[0] = currentModel.getValueAt(i, 0);  // Nombre
            rowData[1] = currentModel.getValueAt(i, 1);  // Cantidad
            rowData[2] = currentModel.getValueAt(i, 2);  // IVU
            rowData[3] = currentModel.getValueAt(i, 3);  // Total
            rowData[4] = "0";  // Default ID or placeholder
            tempModel.addRow(rowData);
        }
        
        // Create a temporary JTable with the new model
        JTable tempTable = new JTable(tempModel);
        
        // Send the order with the properly structured table
        objetoPedido.guardarPedido(tempTable);
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Se ha enviado el pedido correctamente");
        System.out.println("Error interno (ignorado): " + e.toString());
    }
    incrementarNumero(); // incrementa el número
    
    // DIEGO14.03.25:
}//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        desabilitarformulario();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        desabilitarformulario();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
   // DIEGO14.03.25:
        try {
        // Create a temporary table with the same data structure as needed by database
        DefaultTableModel currentModel = (DefaultTableModel) jTable3.getModel();
        DefaultTableModel tempModel = new DefaultTableModel(
            new String[]{"Nombre", "Cantidad", "IVU", "Total", "ID"}, 0);
            
        // Copy all rows from the existing table to ensure persistence
        for (int i = 0; i < currentModel.getRowCount(); i++) {
            Object[] rowData = new Object[5];
            rowData[0] = currentModel.getValueAt(i, 0);  // Nombre
            rowData[1] = currentModel.getValueAt(i, 1);  // Cantidad
            rowData[2] = currentModel.getValueAt(i, 2);  // IVU
            rowData[3] = currentModel.getValueAt(i, 3);  // Total
            rowData[4] = null;
            tempModel.addRow(rowData);
        }
        
        // Create a temporary JTable with the new model for data passing
        JTable tempTable = new JTable(tempModel);
        
        // Send the order with the properly structured table
        objetoPedido.guardarPedido(tempTable);
        
       
        
       Mesas in = new Mesas ();
        in.setSize(789, 700);
        in.setLocation(0,0);
        
        Principal.removeAll();
        Principal.add(in, BorderLayout.CENTER);
        Principal.revalidate();
        Principal.repaint();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al procesar pedido: " + e.toString(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    
    // DIEGO14.03.25:
}//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        Cubierta2.setBackground(new Color(230, 230, 230, 240));
        PanelCubierta.setVisible(true);
        PanelCubierta.removeAll();
        PanelCubierta.repaint();
        PanelCubierta.revalidate();
        PanelCubierta.add(Cubierta2);
        PanelCubierta.repaint();
        PanelCubierta.revalidate();
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        desabilitarformulario();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // DIEGO14.03.25:

// TODO add your handling code here:
        Cubierta3.setBackground(new Color(230, 230, 230, 240));
        PanelCubierta.setVisible(true);
        PanelCubierta.removeAll();
        PanelCubierta.repaint();
        PanelCubierta.revalidate();
        PanelCubierta.add(Cubierta3);
        PanelCubierta.repaint();
        PanelCubierta.revalidate();  

        // Verificar si jTable3 tiene pedidos
            DefaultTableModel df = (DefaultTableModel) jTable3.getModel();

            if (df.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.");
            return;
            }

        // Limpiar jTextArea1 antes de agregar nuevos datos
            jTextArea1.setText("");


            jTextArea1.append("--------------------------------------------------------------\n");
            jTextArea1.append("  Nombre \t Cantidad \t Unidad \t Precio\n"); // Agregado 'Unidad'
            jTextArea1.append("---------------------------------------------------------------\n");

        // Recorrer la tabla y registrar los pedidos
            double total = 0.0;

            for (int i = 0; i < df.getRowCount(); i++) {
                String nombre = df.getValueAt(i, 0).toString(); // Nombre del pedido
                String cantidad = df.getValueAt(i, 1).toString(); // Cantidad
                String unidad = df.getValueAt(i, 2).toString(); // Unidad
                String precio = df.getValueAt(i, 3).toString(); // Precio

               jTextArea1.append("  " + nombre + "\t" + cantidad + "\t" + unidad + "\t $" + precio + "\n");

            // Calcular el total
                total += Double.parseDouble(precio);
            }

        // Mostrar el total en jTextField5
            jTextField5.setText(String.valueOf(total));

            // Obtener el descuento ingresado en jTextField8
        double descuento = 0.0;

        try {
            String descuentoTexto = jTextField8.getText().trim(); // Leer y limpiar espacios
            if (!descuentoTexto.isEmpty()) {
                descuento = Double.parseDouble(descuentoTexto); // Convertir a número
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un descuento válido (número).");
            return; // Detener el proceso si el descuento no es válido
        }

        // Aplicar el descuento al total
        double totalConDescuento = total - descuento;

        // Asegurar que el total no sea negativo
        if (totalConDescuento < 0) {
            totalConDescuento = 0;
        }

        // Mostrar valores en los campos correspondientes
        jTextField5.setText(String.format("%.2f", total)); // Total original
        jTextField6.setText(String.format("%.2f", totalConDescuento)); // Total con descuento

        // Mostrar en jTextArea1 también
        jTextArea1.append("---------------------------------------------------------------\n");

        // DIEGO14.03.25:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Cubierta2.setVisible(false);
        PanelCubierta.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
// DIEGO14.03.25:

// TODO add your handling code here:
        // Obtener el panel padre
    /*JPanel parentPanel = (JPanel) this.getParent();
    
    // Ocultar el panel actual en lugar de eliminarlo
    this.setVisible(false);
    
    // Verificar si hay un panel de Mesas cargado
    Component[] components = parentPanel.getComponents();
    boolean mesasPresente = false;
    
    for (Component comp : components) {
        if (comp instanceof Mesas) {
            comp.setVisible(true); // Mostrar el panel de Mesas
            mesasPresente = true;
            break;
        }
    }*/
    
    // Verificar si hay un contenedor principal (como Principal en tu código)
    if (this.getParent() instanceof JPanel) {
        JPanel parentPanel = (JPanel) this.getParent();
        parentPanel.removeAll(); // Elimina el panel actual
        Mesas mesasPanel = new Mesas(); // Carga el panel anterior (Mesas en este caso)
        mesasPanel.setSize(parentPanel.getSize()); 
        parentPanel.add(mesasPanel, BorderLayout.CENTER); // Agrega el panel anterior
        parentPanel.revalidate();
        parentPanel.repaint();
    }
// DIEGO14.03.25:

    }//GEN-LAST:event_jLabel17MouseClicked
    
    public void desabilitarformulario(){
        PanelCubierta.setVisible(false);
    }
    
    public void mostrarDatoFormulario(String codigo, String nombre) {
        jlNombre.setText(nombre);
        Cubierta1.setBackground(new Color(230, 230, 230, 240));
        PanelCubierta.setVisible(true);
        PanelCubierta.removeAll();
        PanelCubierta.repaint();
        PanelCubierta.revalidate();
        PanelCubierta.add(Cubierta1);
        PanelCubierta.repaint();
        PanelCubierta.revalidate();

    }
    
    /*public void mostrarMenu(){
        Map<Integer, JPanel> panelesPorCategoria = new HashMap<>();
        panelesPorCategoria.put(1, PanelCarnes);
        panelesPorCategoria.put(2, PanelDelChef);
        panelesPorCategoria.put(3, PanelEjecutivo);
        panelesPorCategoria.put(4, PanelSopas);
        panelesPorCategoria.put(5, PanelPescado);
        panelesPorCategoria.put(6, PanelBebida);
        panelesPorCategoria.put(7, PanelAdicional);
        objetoPedido.mostrarMenu(panelesPorCategoria);
    }*/
    public void mostrarDatoFormulario(String codigo, String nombre, double precio) {
        jlNombre.setText(nombre);
        txtPrecio.setText(String.valueOf(precio));
        Cubierta1.setBackground(new Color(230, 230, 230, 240));
        PanelCubierta.setVisible(true);
        PanelCubierta.removeAll();
        PanelCubierta.repaint();
        PanelCubierta.revalidate();
        PanelCubierta.add(Cubierta1);
        PanelCubierta.repaint();
        PanelCubierta.revalidate();

    }
    
    public void mostrarMenu(){
        Map<Integer, JPanel> panelesPorCategoria = new HashMap<>();
        panelesPorCategoria.put(1, PanelCarnes);
        panelesPorCategoria.put(2, PanelDelChef);
        panelesPorCategoria.put(3, PanelEjecutivo);
        panelesPorCategoria.put(4, PanelSopas);
        panelesPorCategoria.put(5, PanelPescado);
        panelesPorCategoria.put(6, PanelBebida);
        panelesPorCategoria.put(7, PanelAdicional);
        objetoPedido.mostrarMenu(panelesPorCategoria);
        
        // DIEGO14.03.25:
        
        // Configurar la tabla para usar el editor de celdas con JSpinner
        setupSpinnerEditor();
    }
    
    // Método para configurar el editor personalizado en la tabla
    private void setupSpinnerEditor() {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        
        // Configurar el editor para la columna de cantidad (índice 1)
        SpinnerEditor editor = new SpinnerEditor();
        jTable3.getColumnModel().getColumn(1).setCellEditor(editor);
        
        // Configurar el renderer para la columna de cantidad para que siempre muestre el spinner
        jTable3.getColumnModel().getColumn(1).setCellRenderer(new SpinnerRenderer());
        
        // Agregar un listener para detectar cambios en el modelo de la tabla
        model.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 1) {
                int row = e.getFirstRow();
                // Solo actualizar el cálculo del total en la interfaz
                updateTotal(row);
                // Se elimina la conexión a BD desde aquí
                // La actualización en BD se realizará solo cuando se haga clic en jButton9
            }
        });
    }

    // Clase para manejar JSpinner como renderer (muestra el spinner siempre)
    private class SpinnerRenderer extends JSpinner implements javax.swing.table.TableCellRenderer {
        public SpinnerRenderer() {
            setModel(new SpinnerNumberModel(1, 0, 99, 1));
            JComponent editor = getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                ((JSpinner.DefaultEditor)editor).getTextField().setHorizontalAlignment(JTextField.CENTER);
                ((JSpinner.DefaultEditor)editor).getTextField().setEditable(false);
            }
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Integer) {
                setValue(value);
            } else {
                setValue(1);
            }
            
            // Asignar colores para una mejor apariencia
            if (isSelected) {
                setBackground(table.getSelectionBackground());
                setForeground(table.getSelectionForeground());
            } else {
                setBackground(table.getBackground());
                setForeground(table.getForeground());
            }
            return this;
        }
    }
    
    // Clase para manejar JSpinner como editor de celdas en la tabla
    private class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
        private JSpinner spinner;
        
        public SpinnerEditor() {
            // Crear un JSpinner con modelo que permita solo valores positivos
            SpinnerNumberModel model = new SpinnerNumberModel(1, 0, 99, 1);
            spinner = new JSpinner(model);
            
            // Agregar un listener para detectar cuando el valor del spinner cambia
            spinner.addChangeListener(e -> {
                // Notificar que el valor ha cambiado para actualizar la tabla
                stopCellEditing();
            });
            
            // Estilo del spinner para que se vea mejor en la tabla
            JComponent editor = spinner.getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
                spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
            }
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, 
                boolean isSelected, int row, int column) {
            // Establecer el valor actual del spinner
            if (value instanceof Integer) {
                spinner.setValue(value);
            } else {
                spinner.setValue(1); // Valor por defecto
            }
            return spinner;
        }
        
        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }
    // Suponiendo que tienes un JTextArea llamado 'jTextAreaO'

// Método que incrementa el número en el JTextArea
    

    // Método para actualizar el total de una fila específica
    private void updateTotal(int row) {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int cantidad = (int) model.getValueAt(row, 1);
        float precioUnitario = (float) model.getValueAt(row, 2);
        double total = cantidad * precioUnitario;
        model.setValueAt(total, row, 3);
    }

    // Método para actualizar la cantidad en la base de datos
    private void updateQuantityInDatabase(int row) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            
            // Obtener los datos necesarios
            String nombre = model.getValueAt(row, 0).toString();
            int cantidad = (int) model.getValueAt(row, 1);
            
            // Llamar al método del objetoPedido para actualizar en la base de datos
            objetoPedido.actualizarCantidadEnBD(nombre, cantidad, row, jTable3);
            
        } catch (Exception e) {
            // Ocultar el mensaje de error para no interrumpir la experiencia
            System.out.println("Error al actualizar cantidad en BD (ignorado): " + e.getMessage());
        }
    }
// DIEGO14.03.25:
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cubierta1;
    private javax.swing.JPanel Cubierta2;
    private javax.swing.JPanel Cubierta3;
    private javax.swing.JPanel PanelAdicional;
    private javax.swing.JPanel PanelBebida;
    private javax.swing.JPanel PanelCarnes;
    private javax.swing.JTabbedPane PanelCubierta;
    private javax.swing.JPanel PanelDelChef;
    private javax.swing.JPanel PanelEjecutivo;
    private javax.swing.JPanel PanelPescado;
    private javax.swing.JPanel PanelSopas;
    private javax.swing.JTabbedPane Seccion;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaM;
    private javax.swing.JTextArea jTextAreaO;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    
}
