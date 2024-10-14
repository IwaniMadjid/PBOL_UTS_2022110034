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
}
