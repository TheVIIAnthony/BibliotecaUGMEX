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
public class Bitacora extends javax.swing.JFrame {

    public Connection con = getConnection();

    public Bitacora() {
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
        String[] titulos = {"Matricula", "Nombre", "Apellido", "", "Carrera", "Semestre", "Fecha", "Ingreso","Salida"};
        String[] registros = new String[8];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
                        String sql = "select * from bitacora where matricula like '%" + valor + "%' or nombre like '%" + valor + "%' or apellidoP like '%" + valor + "%' or apellidoM like '%" + valor + "%' or carrera like '%" + valor + "%' or semestre like '%" + valor + "%' or fecha like '%" + valor + "%' ";
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
        modelo2.addColumn("Matricula");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Apellido");
        modelo2.addColumn("");
        modelo2.addColumn("Carrera");
        modelo2.addColumn("Semestre");
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Ingreso");
        modelo2.addColumn("Salida");
        String sql = "SELECT * FROM bitacora";

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
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Filtro de entrada:");
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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 980, 290));

        jLabel10.setBackground(new java.awt.Color(0, 204, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Bitácora");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 10, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarporKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarporKeyPressed
        filtrarDatos(buscarpor.getText());
    }//GEN-LAST:event_buscarporKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Principal ventana = new Principal();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Bitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bitacora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarpor;
    private javax.swing.JTable consultaPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
