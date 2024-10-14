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
}
