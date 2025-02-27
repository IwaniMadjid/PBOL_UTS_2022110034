/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_2022110034;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Muhamad Iwani Madjid
 */
public class Koneksi {
    public Connection dbKoneksi;
    public Statement statement;
    public PreparedStatement preparedStatement;
    public Koneksi() {        
        this.dbKoneksi = null;    
    }
    
    public void bukaKoneksi() {
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            dbKoneksi = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/uts?user=root"); // nama database
        } catch (Exception e) {
            e.printStackTrace();        
        }    
    }
    
    public void tutupKoneksi() {
        try { 
            if (statement != null) {   
                statement.close();           
            }
            if (preparedStatement != null) {     
                preparedStatement.close();            
            }
            if (dbKoneksi != null) {            
                dbKoneksi.close();            
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());        
        }    
    }
}

