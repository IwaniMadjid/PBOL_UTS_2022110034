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
public class DBMenu {
    private ModelMenu dt=new ModelMenu();    
    public ModelMenu getModelMenu(){ 
        return(dt);
    }
    public void setModelMenu(ModelMenu s){ dt=s;}
    public ObservableList<ModelMenu>  Load() {
        try {   
            ObservableList<ModelMenu> 
                    TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                "Select IDMENU, IDBOOTH, NAMAMENU,HARGA from menu"); // query insert data
            int i = 1;
            while (rs.next()) {
                ModelMenu d=new ModelMenu();
                d.setIDMENU(rs.getString("IDMENU")); 
                d.setIDBOOTH(rs.getString("IDBOOTH"));
                d.setNAMAMENU(rs.getString("NAMAMENU"));
                d.setHARGA(rs.getString("HARGA"));

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
