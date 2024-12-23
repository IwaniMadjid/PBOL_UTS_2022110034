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
public class DBBb {
    private ModelBb dt=new ModelBb();    
    public ModelBb getModelBb(){ 
        return(dt);
    }
    public void setModelBb(ModelBb s){ dt=s;}
    public ObservableList<ModelBb>  Load() {
        try {   
            ObservableList<ModelBb> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDBB, NAMABB from bb"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelBb d=new ModelBb();
                d.setIDBB(rs.getString("IDBB")); 
                d.setNAMABB(rs.getString("NAMABB"));


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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from bb where IDBB = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into bb (IDBB, NAMABB) values (?,?)");
            con.preparedStatement.setString(1, getModelBb().getIDBB());
            con.preparedStatement.setString(2, getModelBb().getNAMABB());
            con.preparedStatement.executeUpdate();
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from bb where IDBB  = ? ");
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
                    "update bb set NAMABB = ?,  where  IDBB = ? ; ");
            con.preparedStatement.setString(1, getModelBb().getIDBB());
            con.preparedStatement.setString(2, getModelBb().getNAMABB());
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
    Koneksi con = new Koneksi();  String is = "./src/uts_2022110034/LaporanBb.jrxml";
Map map = new HashMap();    map.put("p_periode", "Desember"); con.bukaKoneksi();
  try {  JasperPrint jasperPrint = JasperFillManager.fillReport(is, map,  con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) { ex.printStackTrace();  }   con.tutupKoneksi();          }

}
