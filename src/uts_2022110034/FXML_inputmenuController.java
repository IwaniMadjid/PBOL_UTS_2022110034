/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_2022110034;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Muhamad Iwani Madjid
 */
public class FXML_inputmenuController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtidbooth;
    @FXML
    private TextField txtidmenu;
    @FXML
    private TextField txtnamamenu;
    @FXML
    private TextField txtharga;

 boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelMenu d){
        if(!d.getIDMENU().isEmpty()){
          editdata=true;
          txtidmenu.setText(d.getIDMENU());
          txtidbooth.setText(d.getIDBOOTH());
          txtnamamenu.setText(d.getNAMAMENU());
          txtharga.setText(String.valueOf(d.getHARGA()));
          txtidmenu.setEditable(false);
          txtidbooth.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelMenu s=new ModelMenu();
        s.setIDMENU(txtidmenu.getText());
        s.setIDBOOTH(txtidbooth.getText());
        s.setNAMAMENU(txtnamamenu.getText());
        s.setHARGA(Integer.parseInt(txtharga.getText()));
        FXML_menuController.dtMenu.setModelMenu(s);
        if(editdata){
            if(FXML_menuController.dtMenu.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtidmenu.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtMenu.validasi(s.getIDMENU())<=0){
            if(FXML_menuController.dtMenu.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtidmenu.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtidmenu.setText("");
        txtidbooth.setText("");
        txtnamamenu.setText("");
        txtharga.setText("");
        txtidmenu.requestFocus();
    }
    
}
