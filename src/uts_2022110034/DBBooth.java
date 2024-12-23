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
public class DBBooth {
    private ModelBooth dt=new ModelBooth();    
    public ModelBooth getModelBooth(){ 
        return(dt);
    }
    public void setModelBooth(ModelBooth s){ dt=s;}
    public ObservableList<ModelBooth>  Load() {
        try {   
            ObservableList<ModelBooth> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDBOOTH, NAMABOOTH from booth"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelBooth d=new ModelBooth();
                d.setIDBOOTH(rs.getString("IDBOOTH")); 
                d.setNAMABOOTH(rs.getString("NAMABOOTH"));


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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from booth where IDBOOTH = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into booth (IDBOOTH, NAMABOOTH) values (?,?)");
            con.preparedStatement.setString(1, getModelBooth().getIDBOOTH());
            con.preparedStatement.setString(2, getModelBooth().getNAMABOOTH());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from booth where IDBOOTH = ? ");
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
                    "update booth set NAMABOOTH = ? where  IDBOOTH = ? ; ");
            con.preparedStatement.setString(1, getModelBooth().getIDBOOTH());
            con.preparedStatement.setString(2, getModelBooth().getNAMABOOTH());
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
    Koneksi con = new Koneksi();  String is = "./src/uts_2022110034/LaporanBooth.jrxml";
Map map = new HashMap();    map.put("p_periode", "Desember"); con.bukaKoneksi();
  try {  JasperPrint jasperPrint = JasperFillManager.fillReport(is, map,  con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) { ex.printStackTrace();  }   con.tutupKoneksi();          }

}



