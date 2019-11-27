package Inicio;

import static esecuele.conexion.getConnection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vistaAdmin.Crear_CLector;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    public Connection con = getConnection();

    public Principal() {
        initComponents();
        mostrarTabla();
        //validarSoloLetras(buscarpor);
    }

    /**public void validarSoloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    public void validarSoloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c)) {
                    e.consume();
                }
            }
        });
    }**/

    public void filtrarDatos(String valor) {
        String[] titulos = {"Folio", "Titulo", "Autor", "Edición", "Año", "Unidades", "Area", "Num Pags", "Origen"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
                        String sql = "select * from Libros where folio like '%" + valor + "%' or isbn like '%" + valor + "%' or titulo like '%" + valor + "%' or autor like '%" + valor + "%' or edicion like '%" + valor + "%' or anio like '%" + valor + "%' or unidades like '%" + valor + "%' or area like '%" + valor + "%'  ";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            registros[0] = rs.getString(1);
                            registros[1] = rs.getString(3);
                            registros[2] = rs.getString(4);
                            registros[3] = rs.getString(5);
                            registros[4] = rs.getString(6);
                            registros[5] = rs.getString(7);
                            registros[6] = rs.getString(8);
                            registros[7] = rs.getString(9);
                            registros[8] = rs.getString(10);
                            modelo.addRow(registros);
                        }
                        consultaPrincipal.setModel(modelo);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
                    }
        /**if (seleccion.equals("selecciona")) {
            JOptionPane.showMessageDialog(null, "selecciona un parametro de busqueda");
            buscarpor.setText(null);
        } else {
            switch (seleccion) {
                case "titulo":
                    try {
                        String sql = "select * from Libros where titulo like '%" + valor + "%' ";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            registros[0] = rs.getString(1);
                            registros[1] = rs.getString(3);
                            registros[2] = rs.getString(4);
                            registros[3] = rs.getString(5);
                            registros[4] = rs.getString(6);
                            registros[5] = rs.getString(7);
                            registros[6] = rs.getString(8);
                            registros[7] = rs.getString(9);
                            registros[8] = rs.getString(10);
                            modelo.addRow(registros);
                        }
                        consultaPrincipal.setModel(modelo);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
                    }
                    break;
                case "autor":
                    try {
                        String sql = "select * from Libros where autor like '%" + valor + "%' ";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            registros[0] = rs.getString(1);
                            registros[1] = rs.getString(3);
                            registros[2] = rs.getString(4);
                            registros[3] = rs.getString(5);
                            registros[4] = rs.getString(6);
                            registros[5] = rs.getString(7);
                            registros[6] = rs.getString(8);
                            registros[7] = rs.getString(9);
                            registros[8] = rs.getString(10);
                            modelo.addRow(registros);
                        }
                        consultaPrincipal.setModel(modelo);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
                    }
                    break;
            }
        }**/
    }

    void mostrarTabla() {
        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("Folio");
        modelo2.addColumn("Titulo");
        modelo2.addColumn("Autor");
        modelo2.addColumn("Edicion");
        modelo2.addColumn("Año");
        modelo2.addColumn("Unidades");
        modelo2.addColumn("Área");
        modelo2.addColumn("Num Paginas");
        modelo2.addColumn("Origen");
        String sql = "SELECT * FROM Libros";

        String datos[] = new String[9];
        PreparedStatement pt;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(7);
                datos[6] = rs.getString(8);
                datos[7] = rs.getString(9);
                datos[8] = rs.getString(10);
                modelo2.addRow(datos);
            }
            consultaPrincipal.setModel(modelo2);
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        buscarpor = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        consultaPrincipal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Buscar libros por:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        buscarpor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buscarpor.setForeground(new java.awt.Color(0, 204, 204));
        buscarpor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarporKeyPressed(evt);
            }
        });
        jPanel1.add(buscarpor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 470, 30));

        consultaPrincipal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        consultaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        consultaPrincipal.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(consultaPrincipal);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 980, 210));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Bitacora");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 160, 50));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Circulo Lector");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 160, 50));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("Iniciar sesion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 160, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Bitacora ventana = new Bitacora();
        ventana.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Crear_CLector v = new Crear_CLector();
        v.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarporKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarporKeyPressed
        filtrarDatos(buscarpor.getText());
    }//GEN-LAST:event_buscarporKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarpor;
    private javax.swing.JTable consultaPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
