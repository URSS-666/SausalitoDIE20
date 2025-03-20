
package com.Vista.secciones;

import static Vista.secciones.Principal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Sofia Useche
 */
public class Mesas extends javax.swing.JPanel {

    public static Pedido TomaMenu;
    private JButton btnOcupadas;
    private JButton btnTotalMesas;
    private JButton btnDesocupadas;
    private JPanel panelMesas;
    private final int TOTAL_MESAS = 100;
    private int ocupadas = 0;
    private JButton[] mesasBotones;
    private boolean[] estadoMesas;
    private ImageIcon mesaIcono;
    
    public Mesas() {
        inicializarComponentes();
        btnOcupadas.setText("Ocupadas: " + ocupadas);
        btnTotalMesas.setText("Total Mesas: " + TOTAL_MESAS);
        btnDesocupadas.setText("Desocupadas: " + (TOTAL_MESAS - ocupadas));

       /* TomaMenu = new Pedido();
        TomaMenu.setVisible(true);    
        Pedido menu = new Pedido();
        menu.setVisible(true);*/
    
    }
    

     private void inicializarComponentes() {
        setLayout(new BorderLayout());

        // Panel de botones superiores
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnOcupadas = new JButton("Ocupadas: " + ocupadas);
        btnTotalMesas = new JButton("Total Mesas: " + TOTAL_MESAS);
        btnDesocupadas = new JButton("Desocupadas: " + (TOTAL_MESAS - ocupadas));

        panelBotones.add(btnOcupadas);
        panelBotones.add(btnTotalMesas);
        panelBotones.add(btnDesocupadas);
        add(panelBotones, BorderLayout.NORTH);
        panelBotones.setBackground(Color.white);

        // Panel de mesas
        panelMesas = new JPanel(new GridLayout(0, 5, 5, 5));
        add(new JScrollPane(panelMesas), BorderLayout.CENTER);

        // Inicialización de mesas y estados
        mesasBotones = new JButton[TOTAL_MESAS];
        estadoMesas = new boolean[TOTAL_MESAS];

        // Cargar imagen
        URL imgURL = getClass().getResource("/mesaComedor5.png");
        if (imgURL == null) {
            System.out.println("Imagen no encontrada");
        } else {
            mesaIcono = new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH));
        }

        // Generar mesas
        generarMesas();
    }

    private void generarMesas() {
        for (int i = 0; i < TOTAL_MESAS; i++) {
            final int index = i;
            mesasBotones[i] = new JButton("Mesa " + (i + 1), mesaIcono);
            mesasBotones[i].setHorizontalTextPosition(SwingConstants.CENTER);
            mesasBotones[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            mesasBotones[i].setPreferredSize(new Dimension(30, 130));
            mesasBotones[i].setBackground(Color.WHITE);

            // Evitar que el fondo tape la imagen
            mesasBotones[i].setOpaque(true);
            mesasBotones[i].setContentAreaFilled(true);
            mesasBotones[i].setBorderPainted(true);

            // Acción de los botones
            mesasBotones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    abrirPedido(index); // Pasar el índice de la mesa
                }
            });

            panelMesas.add(mesasBotones[i]);
            panelMesas.setBackground(Color.WHITE);
        }
    }

    private void abrirPedido(int mesaIndex) {
        TomaMenu = new Pedido(this, mesaIndex); // Pasar la referencia de Mesas y el índice de la mesa
        Principal.removeAll();
        Principal.add(TomaMenu, BorderLayout.CENTER);
        Principal.revalidate();
        Principal.repaint();
    }

    public void cambiarEstadoMesa(int index, boolean ocupada) {
        estadoMesas[index] = ocupada; // Cambiar el estado

        if (ocupada) {
            mesasBotones[index].setBackground(new Color(144, 238, 144)); // Verde claro
            ocupadas++;
        } else {
            mesasBotones[index].setBackground(Color.WHITE);
            ocupadas--;
        }
    // Actualizar los contadores
        btnOcupadas.setText("Ocupadas: " + ocupadas);
        btnDesocupadas.setText("Desocupadas: " + (TOTAL_MESAS - ocupadas));
    }

    public void actualizarEstadoMesas() {
        for (int i = 0; i < TOTAL_MESAS; i++) {
            if (estadoMesas[i]) {
                mesasBotones[i].setBackground(new Color(144, 238, 144)); // Verde claro
            } else {
                mesasBotones[i].setBackground(Color.WHITE);
            }
        }
    }


    private void initComponents2() {
        jScrollPane1 = new javax.swing.JScrollPane();
        setPreferredSize(new java.awt.Dimension(789, 700));
        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 1050));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
    }

    private javax.swing.JScrollPane jScrollPane1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(789, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
