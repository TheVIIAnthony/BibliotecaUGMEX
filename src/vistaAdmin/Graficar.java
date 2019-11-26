/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaAdmin;

import static esecuele.conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jlgar
 */
public class Graficar {

    Connection con = getConnection();

    public DefaultTableModel mostrarAlumnos() {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Nombre", "Apellido P.0", "Apellido M."};
            String dts[] = new String[3];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select nombre, apellidoP, apellidoM from bitacora";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("nombre");
                dts[1] = rs.getString("apellidoP");
                dts[2] = rs.getString("apellidoM");
                miModelo.addRow(dts);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    public DefaultTableModel mostrarCarreras() {
        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Carrera", "Semestre"};
            String dts[] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select carrera, semestre from bitacora";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("carrera");
                dts[1] = rs.getString("semestre");
                miModelo.addRow(dts);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }
}
