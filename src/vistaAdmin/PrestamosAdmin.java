package vistaAdmin;

import static esecuele.conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import static javafx.beans.binding.Bindings.or;
import static javax.management.Query.or;
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
public class PrestamosAdmin extends javax.swing.JFrame {

    Connection con = getConnection();

    /**
     * Creates new form Libros
     */
    public PrestamosAdmin() {
        initComponents();
        mostrarTabla();
    }

    public void filtrarDatos(String valor) {
        String[] titulos = {"Matricula", "Nombre", "Apellido", "", "Carrera", "Semestre", "Folio", "Libro", "Fecha de prestamo"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        try {
                        String sql = "select * from prestamos where matricula like '%" + valor + "%' or nombalum like '%" + valor + "%' or appat like '%" + valor + "%' or apmat like '%" + valor + "%' or carrera like '%" + valor + "%' or semestre like '%" + valor + "%' or foliolibro like '%" + valor + "%' or nomlibro like '%" + valor + "%' or fechaemi like '%" + valor + "%'";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            registros[0] = rs.getString(2);
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
                        TablaConsLib.setModel(modelo);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
                    }
        /**String[] titulos = {"Matricula", "Titulo", "Autor", "Edición", "Año", "Unidades", "Area", "Num Pags", "Origen"};
        String[] registros = new String[9];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String seleccion = camposeleccion.getSelectedItem().toString();
        if (seleccion.equals("selecciona")) {
            JOptionPane.showMessageDialog(null, "selecciona un parametro de busqueda");
            buscarpor.setText(null);
        } else {
            
            switch (seleccion) {
                case "Matricula":
                    try {
                        String sql = "select * from prestamos where titulo like '%" + valor + "%' ";
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
                        TablaConsLib.setModel(modelo);
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
                        TablaConsLib.setModel(modelo);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error de Busqueda" + ex.getMessage());
                    }
                    break;
            }
        }**/
    }

    void mostrarTabla() {
        DefaultTableModel modelo2 = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
        };
        modelo2.addColumn("Matricula");
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Apellido");
        modelo2.addColumn("Apellido");
        modelo2.addColumn("Carrera");
        modelo2.addColumn("Semestre");
        modelo2.addColumn("Folio");
        modelo2.addColumn("Libro");
        modelo2.addColumn("Autor");
        modelo2.addColumn("Area");
        modelo2.addColumn("Fecha");
        String sql = "SELECT * FROM prestamos";

        String datos[] = new String[11];
        PreparedStatement pt;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(7);
                datos[6] = rs.getString(8);
                datos[7] = rs.getString(9);
                datos[8] = rs.getString(10);
                datos[9] = rs.getString(11);
                datos[10] = rs.getString(12);
                modelo2.addRow(datos);
            }
            TablaConsLib.setModel(modelo2);
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
        TablaConsLib = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        libro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombalumn = new javax.swing.JTextField();
        app = new javax.swing.JTextField();
        apm = new javax.swing.JTextField();
        carrera = new javax.swing.JTextField();
        semestre = new javax.swing.JTextField();
        folio1 = new javax.swing.JTextField();
        campoFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        autor1 = new javax.swing.JTextField();
        area1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jTabbedPane4.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Buscar prestamos:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        buscarpor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buscarpor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarporActionPerformed(evt);
            }
        });
        buscarpor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarporKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarporKeyTyped(evt);
            }
        });
        jPanel2.add(buscarpor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 470, 30));

        jLabel10.setBackground(new java.awt.Color(0, 204, 204));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Consultar prestamos");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, 30));

        TablaConsLib.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        TablaConsLib.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaConsLib.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TablaConsLib);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 810, 310));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 173, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wsdw.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, -10, 440, 240));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/800x600.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 700, 560));

        jTabbedPane4.addTab("Consulta", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        libro.setEditable(false);
        libro.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del alumno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido Materno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido Paterno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Registrar prestamo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 120, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Carrera");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Matricula");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Semestre");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Fecha de emisión");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        matricula.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaActionPerformed(evt);
            }
        });
        jPanel1.add(matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nombre del libro");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Folio del libro");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        nombalumn.setEditable(false);
        nombalumn.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(nombalumn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 150, -1));

        app.setEditable(false);
        app.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(app, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 150, -1));

        apm.setEditable(false);
        apm.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(apm, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 150, -1));

        carrera.setEditable(false);
        carrera.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreraActionPerformed(evt);
            }
        });
        jPanel1.add(carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 150, -1));

        semestre.setEditable(false);
        semestre.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(semestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 150, -1));

        folio1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        folio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folio1ActionPerformed(evt);
            }
        });
        jPanel1.add(folio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 150, -1));
        jPanel1.add(campoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 150, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Area");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Autor");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        autor1.setEditable(false);
        autor1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jPanel1.add(autor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 150, -1));

        area1.setEditable(false);
        area1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        area1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                area1ActionPerformed(evt);
            }
        });
        jPanel1.add(area1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 150, -1));

        jTabbedPane4.addTab("Registros", jPanel1);

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
                .addComponent(jTabbedPane4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String folio, isbn, titulo, autor, edicion, año, unidades, area, numPaginas, areaf,autorf, origen, sql;
        Connection con = getConnection();
        PreparedStatement ps;
        isbn = matricula.getText();
        titulo = nombalumn.getText();
        autor = app.getText();
        edicion = apm.getText();
        año = carrera.getText();
        area = folio1.getText();
        Date date = campoFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        areaf= area1.getText();
        autorf=autor1.getText();
        unidades = semestre.getText();
        numPaginas = libro.getText();

        if (matricula.getText().isEmpty() || nombalumn.getText().isEmpty()
                || app.getText().isEmpty() || apm.getText().isEmpty() || carrera.getText().isEmpty()
                || folio1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos están vacíos");
        } else {
            try {
                sql = "INSERT INTO prestamos( matricula, nombalum, appat, apmat, carrera, semestre, foliolibro, nomlibro, autor, area, fechaemi)" + "values(?,?,?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, isbn);
                ps.setString(2, titulo);
                ps.setString(3, autor);
                ps.setString(4, edicion);
                ps.setString(5, año);
                ps.setString(6, unidades);
                ps.setString(7, area);
                ps.setString(8, numPaginas);
                ps.setString(9, autorf);
                ps.setString(10, areaf);
                ps.setDate(11, fecha);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nuevo registro subido correctamente");
                mostrarTabla();
                matricula.setText(null);
                nombalumn.setText(null);
                app.setText(null);
                apm.setText(null);
                carrera.setText(null);
                folio1.setText(null);
                semestre.setText(null);
                autor1.setText(null);
                area1.setText(null);
                libro.setText(null);
               
            } catch (SQLException sqex) {
                JOptionPane.showMessageDialog(null, sqex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Menu_admin ventana = new Menu_admin();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscarporKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarporKeyPressed
        filtrarDatos(buscarpor.getText());
    }//GEN-LAST:event_buscarporKeyPressed

    private void matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM Alumnos";

        String matricula1,nombre,apma,appa,sem,carr;
        int dato;
        PreparedStatement pt;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                matricula1= matricula.getText();
                dato = rs.getInt(1);
                String datos= String.valueOf(dato);
                nombre = rs.getString(2);
                 appa= rs.getString(3);
                apma = rs.getString(4);
                sem = rs.getString(5);
                carr = rs.getString(6);
                if (matricula!=null){
                    if(matricula1.equals(datos)){
                    nombalumn.setText(nombre);
                    app.setText(appa);
                    apm.setText(apma);
                    semestre.setText(sem);
                    carrera.setText(carr);
                    }
             }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Checa tu conexion totol");

        }
    }//GEN-LAST:event_matriculaActionPerformed

    private void buscarporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarporActionPerformed

    private void buscarporKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarporKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarporKeyTyped

    private void carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreraActionPerformed

    private void area1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_area1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_area1ActionPerformed

    private void folio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folio1ActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM Libros";

        PreparedStatement pt;
        String Folio2,Libro1,Autor,Area;
        int datos;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Folio2= folio1.getText();
                datos = rs.getInt(1);
                String datos1= String.valueOf(datos);
                Libro1 = rs.getString(3);
                 Autor= rs.getString(4);
                Area = rs.getString(8);
                
                if (folio1!=null){
                    if(Folio2.equals(datos1)){
                    libro.setText(Libro1);
                    autor1.setText(Autor);
                    area1.setText(Area);
                    }
             }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Checa tu conexion totol");

        }
    }//GEN-LAST:event_folio1ActionPerformed

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
            java.util.logging.Logger.getLogger(PrestamosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrestamosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrestamosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrestamosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrestamosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConsLib;
    private javax.swing.JTextField apm;
    private javax.swing.JTextField app;
    private javax.swing.JTextField area1;
    private javax.swing.JTextField autor1;
    private javax.swing.JTextField buscarpor;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField carrera;
    private javax.swing.JTextField folio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField libro;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField nombalumn;
    private javax.swing.JTextField semestre;
    // End of variables declaration//GEN-END:variables
}
