package vistaAdmin;

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

public class UsuariosAdmin extends javax.swing.JFrame {

    //COMENTAR ESTO SOBRE ESTA LINEA
    Connection con = getConnection();

    //HASTA AQUI - DESPUES BORRAR ESTA LINEA
    public UsuariosAdmin() {
        initComponents();
        validarSoloLetras(campoDeBusqueda);
        validarSoloLetras(campoNombre);
        mostrarTabla();
    }

    void mostrarTabla() {
        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Tipo de Usuario");
        modelo2.addColumn("Nivel de Privilegio");
        String sql = "SELECT * FROM usuarios";
        String datos[] = new String[3];
        PreparedStatement pt;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                modelo2.addRow(datos);
            }
            tablaConsulta.setModel(modelo2);
        } catch (Exception e) {

        }
    }

    public void validarSoloNumeros(JTextField campo) {
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
    }

    public void filtrarDatos(String valor) {
        String[] titulos = {"Nombre", "Tipo de Usuario", "Nivel de privilegio"};
        String[] registros = new String[3];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        try {
            String sql = "select * from usuarios where nombre like '%" + valor + "%' ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(4);
                modelo.addRow(registros);
            }
            tablaConsulta.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
        }

    }

    void borrarCamposdeAlta() {
        campoNombre.setText(null);
        campoContra.setText(null);
        campoContra2.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoDeBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        Eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tipoUsuario = new javax.swing.JComboBox<>();
        nivelPrivilegio = new javax.swing.JComboBox<>();
        campoContra2 = new javax.swing.JPasswordField();
        campoContra = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(875, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Consulta y Eliminar usuarios");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ingresa un usuario:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        campoDeBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDeBusquedaActionPerformed(evt);
            }
        });
        campoDeBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDeBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDeBusquedaKeyReleased(evt);
            }
        });
        jPanel2.add(campoDeBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 480, 30));

        tablaConsulta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaConsulta);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 840, 330));

        Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel2.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 100, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 20, 70, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoGrande.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 620, -1));

        jTabbedPane1.addTab("Consultar/Eliminar Usuarios", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Crear nuevo usuario");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nombre");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Seleccionar tipo de usuario:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, 20));

        campoNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        jPanel1.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 137, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Seleccionar nivel de privilegio:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, 20));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, 30));

        tipoUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alumno", "Docente" }));
        tipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(tipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 137, 30));

        nivelPrivilegio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nivelPrivilegio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estándar", "Administrador" }));
        jPanel1.add(nivelPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 137, 30));
        jPanel1.add(campoContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 140, 30));
        jPanel1.add(campoContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Repetir contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoGrande.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/800x600.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 840, 400));

        jTabbedPane1.addTab("Alta Usuarios", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoUsuarioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String nombre = campoNombre.getText();
            String valorCB1 = tipoUsuario.getSelectedItem().toString();
            String valorCB2 = nivelPrivilegio.getSelectedItem().toString();
            String contra = campoContra.getText();
            String contra2 = campoContra2.getText();
            if (!contra.equals(contra2)) {
                JOptionPane.showMessageDialog(null, "las contraseñas no son iguales");
            } else {

            }
            String cadena = "INSERT INTO usuarios(nombre, tipoUsuario, nivelPrivilegio, contraseña)values(?,?,?,?)";
            PreparedStatement ps;
            ps = con.prepareStatement(cadena);
            ps.setString(1, nombre);
            ps.setString(2, valorCB1);
            ps.setString(3, valorCB2);
            ps.setString(4, contra2);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Creado Exitosamente");
            borrarCamposdeAlta();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoDeBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDeBusquedaKeyPressed
        // realizar busqueda al presionar enter
    }//GEN-LAST:event_campoDeBusquedaKeyPressed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = tablaConsulta.getSelectedRow();
        String valor = tablaConsulta.getValueAt(fila, 0).toString();
        if (fila <= 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un usuario");
        } else {
            try {
                PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE nombre ='" + valor + "'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dato eliminado");
                mostrarTabla();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void campoDeBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDeBusquedaActionPerformed

    }//GEN-LAST:event_campoDeBusquedaActionPerformed

    private void campoDeBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDeBusquedaKeyReleased
        filtrarDatos(campoDeBusqueda.getText());
    }//GEN-LAST:event_campoDeBusquedaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu_admin ventana = new Menu_admin();
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
            java.util.logging.Logger.getLogger(UsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuariosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JPasswordField campoContra;
    private javax.swing.JPasswordField campoContra2;
    private javax.swing.JTextField campoDeBusqueda;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> nivelPrivilegio;
    private javax.swing.JTable tablaConsulta;
    private javax.swing.JComboBox<String> tipoUsuario;
    // End of variables declaration//GEN-END:variables
}
