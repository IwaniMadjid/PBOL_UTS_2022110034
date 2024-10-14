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
public class DBBeli {
      private ModelBeli dt=new ModelBeli();    
    public ModelBeli getModelBbsj(){ 
        return(dt);
    }
    public void setModelBbsj(ModelBeli s){ dt=s;}
    public ObservableList<ModelBeli>  Load() {
        try {   
            ObservableList<ModelBeli> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDBELI, IDSUPPLIER,TGLBELI,WKTBELI from beli"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelBeli d=new ModelBeli();
                d.setIDBELI(rs.getString("IDBELI")); 
                d.setIDSUPPLIER(rs.getString("IDSUPPLIER"));
                d.setTGLBELI(rs.getString("TGLBELI"));
                d.setWKTBELI(rs.getString("WKTBELI"));


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
