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
public class DBBbsj {
     private ModelBbsj dt=new ModelBbsj();    
    public ModelBbsj getModelBbsj(){ 
        return(dt);
    }
    public void setModelBbsj(ModelBbsj s){ dt=s;}
    public ObservableList<ModelBbsj>  Load() {
        try {   
            ObservableList<ModelBbsj> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDBBSJ, NAMABBSJ from bbsj"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelBbsj d=new ModelBbsj();
                d.setIDBBSJ(rs.getString("IDBBSJ")); 
                d.setNAMABBSJ(rs.getString("NAMABBSJ"));


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
