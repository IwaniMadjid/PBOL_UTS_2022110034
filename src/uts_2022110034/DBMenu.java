/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_2022110034;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Muhamad Iwani Madjid
 */
public class DBMenu {
    private ModelMenu dt=new ModelMenu();    
    public ModelMenu getModelMenu(){ 
        return(dt);
    }
    public void setModelMenu(ModelMenu s){ dt=s;}
    public ObservableList<ModelMenu>  Load() {
        try {   
            ObservableList<ModelMenu> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDMENU, IDBOOTH, NAMAMENU,HARGA from menu"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelMenu d=new ModelMenu();
                d.setIDMENU(rs.getString("IDMENU")); 
                d.setIDBOOTH(rs.getString("IDBOOTH"));
                d.setNAMAMENU(rs.getString("NAMAMENU"));
                d.setHARGA(rs.getInt("HARGA"));

            TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public int validasi(String nomor) {
        int val = 0;
        try {  
            Koneksi con = new Koneksi();     
            con.bukaKoneksi();   
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from menu where IDMENU = '" + nomor + "'");
            while (rs.next()) {   val = rs.getInt("jml");            }
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }        

     public boolean insert() {
        boolean berhasil = false;    
        Koneksi con = new Koneksi();
        try {         
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into menu (IDMENU, IDBOOTH, NAMAMENU, HARGA) values (?,?,?,?)");
            con.preparedStatement.setString(1, getModelMenu().getIDMENU());
            con.preparedStatement.setString(2, getModelMenu().getIDBOOTH());
            con.preparedStatement.setString(3, getModelMenu().getNAMAMENU());
            con.preparedStatement.setInt(4, getModelMenu().getHARGA());
            int executeUpdate = con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        }
    }
       public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from menu where IDMENU =?, ID BOOTH? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update menu set NAMAMENU = ?, HARGA =?  where  IDMENU =?, IDBOOTH = ? ; ");
            con.preparedStatement.setString(1, getModelMenu().getIDMENU());
            con.preparedStatement.setString(2, getModelMenu().getIDBOOTH());
            con.preparedStatement.setString(3, getModelMenu().getNAMAMENU());
            con.preparedStatement.setInt(4, getModelMenu().getHARGA());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
}
public void print(){
    Koneksi con = new Koneksi();  String is = "./src/uts_2022110034/LaporanMenu.jrxml";
Map map = new HashMap();    map.put("p_periode", "Desember"); con.bukaKoneksi();
  try {  JasperPrint jasperPrint = JasperFillManager.fillReport(is, map,  con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) { ex.printStackTrace();  }   con.tutupKoneksi();          }

}
