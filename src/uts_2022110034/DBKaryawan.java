/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_2022110034;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
}
