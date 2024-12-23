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
public class DBSupplier {
    private ModelSupplier dt=new ModelSupplier();    
    public ModelSupplier getModelSupplier(){ 
        return(dt);
    }
    public void setModelSupplier(ModelSupplier s){ dt=s;}
    public ObservableList<ModelSupplier>  Load() {
        try {   
            ObservableList<ModelSupplier> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDSUPPLIER, NAMASUPPLIER,ALAMATSUPPLIER,KONTAKSUPPLIER from supplier"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelSupplier d=new ModelSupplier();
                d.setIDSUPPLIER(rs.getString("IDSUPPLIER")); 
                d.setNAMASUPPLIER(rs.getString("NAMASUPPLIER"));
                d.setALAMATSUPPLIER(rs.getString("ALAMATSUPPLIER"));
                d.setKONTAKSUPPLIER(rs.getString("KONTAKSUPPLIER"));


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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from supplier where IDSUPPLIER = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into supplier (IDSUPPLIER, NAMASUPPLIER, ALAMATSUPPLIER,KONTAK) values (?,?,?,?)");
            con.preparedStatement.setString(1, getModelSupplier().getIDSUPPLIER());
            con.preparedStatement.setString(2, getModelSupplier().getNAMASUPPLIER());
            con.preparedStatement.setString(3, getModelSupplier().getALAMATSUPPLIER());
            con.preparedStatement.setString(3, getModelSupplier().getKONTAKSUPPLIER());

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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from supplier where IDSUPPLIER = ? ");
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
                    "update supplier set NAMASUPPLIER = ?, ALAMATSUPPLIER =?, KONTAKSUPPLIER = ? where  IDSUPPLIER = ? ; ");
            con.preparedStatement.setString(1, getModelSupplier().getIDSUPPLIER());
            con.preparedStatement.setString(2, getModelSupplier().getNAMASUPPLIER());
            con.preparedStatement.setString(2, getModelSupplier().getALAMATSUPPLIER());
            con.preparedStatement.setString(2, getModelSupplier().getKONTAKSUPPLIER());
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
    Koneksi con = new Koneksi();  String is = "./src/uts_2022110034/LaporanSupplier.jrxml";
Map map = new HashMap();    map.put("p_periode", "Desember"); con.bukaKoneksi();
  try {  JasperPrint jasperPrint = JasperFillManager.fillReport(is, map,  con.dbKoneksi);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) { ex.printStackTrace();  }   con.tutupKoneksi();          }

}
