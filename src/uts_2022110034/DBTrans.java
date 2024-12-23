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
public class DBTrans {
     private ModelTrans dt=new ModelTrans();    
    public ModelTrans getModelTrans(){ 
        return(dt);
    }
    public void setModelTrans(ModelTrans s){ dt=s;}
    public ObservableList<ModelTrans>  Load() {
        try {   
            ObservableList<ModelTrans> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDTRANSAKSI, IDKARYAWAN,TGLTRANSAKSI,WKTTRANSAKSI from transaksi"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelTrans d=new ModelTrans();
                d.setIDTRANSAKSI(rs.getString("IDTRANSAKSI")); 
                d.setIDKARYAWAN(rs.getString("IDKARYAWAN"));
                d.setTGLTRANSAKSI(rs.getDate("TGLTRANSAKSI"));
                d.setWKTTRANSAKSI(rs.getDate("WKTTRANSAKSI"));


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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from transaksi where IDTRANSAKSI = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into transaksi (IDTRANSAKSI, IDKARYAWAN, TGLTRANSAKSI,WKTTRANSAKSI) values (?,?,?,?)");
            con.preparedStatement.setString(1, getModelTrans().getIDTRANSAKSI());
            con.preparedStatement.setString(2, getModelTrans().getIDKARYAWAN());
            con.preparedStatement.setDate(3, getModelTrans().getTGLTRANSAKSI());
            con.preparedStatement.setDate(4, getModelTrans().getTGLTRANSAKSI());

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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from transaksi where IDTRANSAKSI = ?, IDKARYAWAN =? ");
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
                    "update transaksi set TGLTRANSAKSI = ?, WKTTRANSAKSI =?  where  IDTRANSAKSI = ?, IDKARYAWAN =? ; ");
            con.preparedStatement.setString(1, getModelTrans().getIDTRANSAKSI());
            con.preparedStatement.setString(2, getModelTrans().getIDKARYAWAN());
            con.preparedStatement.setDate(3, getModelTrans().getTGLTRANSAKSI());
            con.preparedStatement.setDate(4, getModelTrans().getWKTTRANSAKSI());
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
    Koneksi con = new Koneksi();  String is = "./src/uts_2022110034/LaporanTransaksi.jrxml";
Map map = new HashMap();    map.put("p_periode", "Desember"); con.bukaKoneksi();
  try {  JasperPrint jasperPrint = JasperFillManager.fillReport(is, map,  con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) { ex.printStackTrace();  }   con.tutupKoneksi();          }

}

