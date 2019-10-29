package vistaAdmin;

import static esecuele.conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class LibrosAdmin extends javax.swing.JFrame {

    Connection con = getConnection();

    /**
     * Creates new form Libros
     */
    public LibrosAdmin() {
        initComponents();
        mostrarTabla();
    }

    public void filtrarDatos(String valor) {
        String[] titulos = {"Folio", "Titulo", "Autor", "Edición", "Año", "Unidades", "Area", "Num Pags", "Origen"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String seleccion = camposeleccion.getSelectedItem().toString();
        if (seleccion.equals("selecciona")) {
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
                        campoconsullibros.setModel(modelo);
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
                        campoconsullibros.setModel(modelo);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
                    }
                    break;
            }
        }
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
            campoconsullibros.setModel(modelo2);
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

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        buscarpor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        campoconsullibros = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        camposeleccion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        campoNumPag = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        campoISBN = new javax.swing.JTextField();
        comboOrigen = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoNombreLibro = new javax.swing.JTextField();
        campoAutor = new javax.swing.JTextField();
        campoEdicion = new javax.swing.JTextField();
        campoAño = new javax.swing.JTextField();
        campoUnidades = new javax.swing.JTextField();
        campoArea = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jTabbedPane4.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Buscar libros por:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        buscarpor.setBackground(new java.awt.Color(255, 255, 255));
        buscarpor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buscarpor.setForeground(new java.awt.Color(0, 0, 0));
        buscarpor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarporKeyPressed(evt);
            }
        });
        jPanel2.add(buscarpor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 470, 30));

        jLabel10.setBackground(new java.awt.Color(0, 204, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Consultar libros");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        campoconsullibros.setBackground(new java.awt.Color(255, 255, 255));
        campoconsullibros.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        campoconsullibros.setForeground(new java.awt.Color(0, 0, 0));
        campoconsullibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        campoconsullibros.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(campoconsullibros);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 810, 310));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, -1));

        camposeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecciona", "titulo", "autor" }));
        camposeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camposeleccionActionPerformed(evt);
            }
        });
        jPanel2.add(camposeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 130, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoGrande.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Eliminar libro");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, 30));

        jTabbedPane4.addTab("Consultar libros", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNumPag.setBackground(new java.awt.Color(255, 255, 255));
        campoNumPag.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoNumPag.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoNumPag, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del libro");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Edición");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Autor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Ingresar nuevos libros");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 120, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Año");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("ISBN");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Unidades");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Origen");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        campoISBN.setBackground(new java.awt.Color(255, 255, 255));
        campoISBN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoISBN.setForeground(new java.awt.Color(0, 0, 0));
        campoISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoISBNActionPerformed(evt);
            }
        });
        jPanel1.add(campoISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 150, -1));

        comboOrigen.setBackground(new java.awt.Color(255, 255, 255));
        comboOrigen.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        comboOrigen.setForeground(new java.awt.Color(0, 0, 0));
        comboOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecciona", "Donación", "Compra", " " }));
        jPanel1.add(comboOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Numero de pags.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Area");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        campoNombreLibro.setBackground(new java.awt.Color(255, 255, 255));
        campoNombreLibro.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoNombreLibro.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoNombreLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 150, -1));

        campoAutor.setBackground(new java.awt.Color(255, 255, 255));
        campoAutor.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoAutor.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 150, -1));

        campoEdicion.setBackground(new java.awt.Color(255, 255, 255));
        campoEdicion.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoEdicion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 150, -1));

        campoAño.setBackground(new java.awt.Color(255, 255, 255));
        campoAño.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoAño.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 150, -1));

        campoUnidades.setBackground(new java.awt.Color(255, 255, 255));
        campoUnidades.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoUnidades.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 150, -1));

        campoArea.setBackground(new java.awt.Color(255, 255, 255));
        campoArea.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        campoArea.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(campoArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 150, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoGrande.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -40, 610, 520));

        jTabbedPane4.addTab("Alta libros", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String folio, isbn, titulo, autor, edicion, año, unidades, area, numPaginas, origen, sql;
        Connection con = getConnection();
        PreparedStatement ps;
        isbn = campoISBN.getText();
        titulo = campoNombreLibro.getText();
        autor = campoAutor.getText();
        edicion = campoEdicion.getText();
        año = campoAño.getText();
        area = campoArea.getText();
        origen = comboOrigen.getSelectedItem().toString();

        unidades = campoUnidades.getText();
        numPaginas = campoNumPag.getText();
        int Unidades = Integer.parseInt(unidades), numPags = Integer.parseInt(numPaginas);
        if (campoISBN.getText().isEmpty() || campoNombreLibro.getText().isEmpty()
                || campoAutor.getText().isEmpty() || campoEdicion.getText().isEmpty() || campoAño.getText().isEmpty()
                || campoArea.getText().isEmpty() || comboOrigen.equals("selecciona")) {
            JOptionPane.showMessageDialog(null, "Algunos campos están vacíos");
        } else {
            try {
                sql = "INSERT INTO Libros (isbn, titulo, autor, edicion, anio, unidades, area, num_paginas, origen) values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, isbn);
                ps.setString(2, titulo);
                ps.setString(3, autor);
                ps.setString(4, edicion);
                ps.setString(5, año);
                ps.setInt(6, Unidades);
                ps.setString(7, area);
                ps.setInt(8, numPags);
                ps.setString(9, origen);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nuevo libro subido correctamente");
                mostrarTabla();
                campoISBN.setText(null);
                campoNombreLibro.setText(null);
                campoAutor.setText(null);
                campoEdicion.setText(null);
                campoAño.setText(null);
                campoArea.setText(null);
                campoUnidades.setText(null);
                campoNumPag.setText(null);
            } catch (SQLException sqex) {
                JOptionPane.showMessageDialog(null, sqex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Menu_admin ventana = new Menu_admin();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscarporKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarporKeyPressed
        filtrarDatos(buscarpor.getText());
    }//GEN-LAST:event_buscarporKeyPressed

    private void camposeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camposeleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camposeleccionActionPerformed

    private void campoISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoISBNActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(LibrosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarpor;
    private javax.swing.JTextField campoArea;
    private javax.swing.JTextField campoAutor;
    private javax.swing.JTextField campoAño;
    private javax.swing.JTextField campoEdicion;
    private javax.swing.JTextField campoISBN;
    private javax.swing.JTextField campoNombreLibro;
    private javax.swing.JTextField campoNumPag;
    private javax.swing.JTextField campoUnidades;
    private javax.swing.JTable campoconsullibros;
    private javax.swing.JComboBox<String> camposeleccion;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane4;
    // End of variables declaration//GEN-END:variables
}
