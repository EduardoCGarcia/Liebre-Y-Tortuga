/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author EduardoCGarcia
 */
public class Pista extends javax.swing.JFrame {

    /**
     * Creates new form Pista
     */
    public Pista() {
        crearCorredores();
        initComponents();
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInicio = new javax.swing.JButton();
        lblMensajeGanador = new javax.swing.JLabel();
        lblMensajePerdedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInicio.setText("Iniciar Carrera");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        lblMensajeGanador.setText(" ");

        lblMensajePerdedor.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 694, Short.MAX_VALUE)
                .addComponent(btnInicio))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMensajeGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensajePerdedor, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(lblMensajeGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblMensajePerdedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        this.crearHilosDemonio();
        this.crearHilosCorredores();
    }//GEN-LAST:event_btnInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private static javax.swing.JLabel lblMensajeGanador;
    private static javax.swing.JLabel lblMensajePerdedor;
    // End of variables declaration//GEN-END:variables
    public Corredor t, o;
    public HiloCorredor tortuga, tor;
    private javax.swing.JLabel lblTortuga = new JLabel();
    private javax.swing.JLabel lblTor = new JLabel();
    private static boolean ganador;
    private JPanel pnlCamino = new JPanel();
    private JPanel pnlCaminoTor = new JPanel();

    public static synchronized void meta(String nombre) {
        if (ganador) {
            lblMensajePerdedor.setText(nombre + " llegó en segundo lugar");

        } else {
            ganador = true;
            lblMensajeGanador.setText(nombre + " llegó en primer lugar");
        }
    }

    public class FondoPanel extends JPanel {

        private Image imagen;

        public void pain(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/images/2.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(true);
            super.paint(g);
        }
    }
    
    public void crearCorredores(){
        t = new Corredor(0, 50, 100, 100);
        t.setRuta("tortuga.png");
        
        lblTortuga.setText("Makuin");
        lblTortuga.setBounds(0, 150, 100, 40);
        lblTortuga.setHorizontalAlignment(SwingConstants.CENTER);
        
        o = new Corredor(0, 200, 100, 100);
        o.setRuta("tortuga.png");
        
        lblTor.setText("Thor-Tuga");
        lblTor.setBounds(0, 300, 100, 40);
        lblTor.setHorizontalAlignment(SwingConstants.CENTER);
        
        pnlCamino.setBackground(Color.red);
        pnlCaminoTor.setBackground(Color.blue);
        
        this.add(pnlCamino);
        this.add(pnlCaminoTor);
        this.add(lblTortuga);
        this.add(lblTor);
        this.add(t);
        this.add(o);
    }
    
    public void crearHilosCorredores(){
        ganador = false;
        lblMensajeGanador.setText("");
        lblMensajePerdedor.setText("");
        
        tortuga = new HiloCorredor(t, 0, 50, "Makuin", lblTortuga,pnlCamino);
        tor = new HiloCorredor(o, 0, 200, "Thor-Tuga", lblTor,pnlCaminoTor);

        tor.start();
        tortuga.start();
        
        System.out.println("******");
        repaint();
    }
    
    public void crearHilosDemonio(){
        DaemonThread daemonThread = new DaemonThread(pnlCamino,1);
        daemonThread.setName("Hilo demonio 1");
        daemonThread.setDaemon(true);
        DaemonThread daemonThread2 = new DaemonThread(pnlCaminoTor,2);
        daemonThread2.setName("Hilo demonio 2");
        daemonThread2.setDaemon(true);
        daemonThread.start();
        daemonThread2.start();
    }
}
