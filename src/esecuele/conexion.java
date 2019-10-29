/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esecuele;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class conexion {    
    public static final String URL = "jdbc:mysql://65.99.225.14:3306/sisugxco_CID?useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "sisugxco";
    public static final String PASSWORD = "X7Lr5f39o]+OFb";
    public static Connection con;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
