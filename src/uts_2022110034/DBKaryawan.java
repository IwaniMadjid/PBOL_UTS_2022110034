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
public class DBKaryawan {
    private ModelKaryawan dt=new ModelKaryawan();    
    public ModelKaryawan getModelKaryawan(){ 
        return(dt);
    }
    public void setModelKaryawan(ModelKaryawan s){ dt=s;}
    public ObservableList<ModelKaryawan>  Load() {
        try {   
            ObservableList<ModelKaryawan> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDKARYAWAN, NAMAKARYAWAN,ALAMAT, KONTAK from karyawan"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelKaryawan d=new ModelKaryawan();
                d.setIDKARYAWAN(rs.getString("IDKARYAWAN")); 
                d.setNAMAKARYAWAN(rs.getString("NAMAKARYAWAN"));
                d.setALAMAT(rs.getString("ALAMAT"));
                d.setKONTAK(rs.getString("KONTAK"));

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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from karyawan where IDKARYAWAN = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into karyawan (IDKARYAWAN, NAMAKARYAWAN, ALAMAT,KONTAK) values (?,?,?,?)");
            con.preparedStatement.setString(1, getModelKaryawan().getIDKARYAWAN());
            con.preparedStatement.setString(2, getModelKaryawan().getNAMAKARYAWAN());
            con.preparedStatement.setString(3, getModelKaryawan().getALAMAT());
            con.preparedStatement.setString(4, getModelKaryawan().getKONTAK());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from karyawan where IDKARYAWAN =? ");
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
                    "update karyawan set NAMAKARYAWAN = ?, ALAMAT =?, KONTAK= ?  where  IDKARYAWAN =? ; ");
            con.preparedStatement.setString(1, getModelKaryawan().getIDKARYAWAN());
            con.preparedStatement.setString(2, getModelKaryawan().getNAMAKARYAWAN());
            con.preparedStatement.setString(3, getModelKaryawan().getALAMAT());
            con.preparedStatement.setString(4, getModelKaryawan().getKONTAK());
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
    Koneksi con = new Koneksi();  String is = "./src/uts_2022110034/LaporanKaryawan.jrxml";
Map map = new HashMap();    map.put("p_periode", "Desember"); con.bukaKoneksi();
  try {  JasperPrint jasperPrint = JasperFillManager.fillReport(is, map,  con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) { ex.printStackTrace();  }   con.tutupKoneksi();          }

}

