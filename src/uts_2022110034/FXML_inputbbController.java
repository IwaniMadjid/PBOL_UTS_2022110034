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
public class FXML_inputbbController implements Initializable {

    @FXML
    private TextField txtbb;
    @FXML
    private TextField txtnamabb;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;

        boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelBb d){
        if(!d.getIDBB().isEmpty()){
          editdata=true;
          txtbb.setText(d.getIDBB());
          txtnamabb.setText(d.getNAMABB());
          txtbb.setEditable(false);
          txtnamabb.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelBb s=new ModelBb();
        s.setIDBB(txtbb.getText());
        s.setNAMABB(txtnamabb.getText());
        FXML_menuController.dtBb.setModelBb(s);
        if(editdata){
            if(FXML_menuController.dtBb.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtbb.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtBb.validasi(s.getIDBB())<=0){
            if(FXML_menuController.dtBb.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtbb.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtbb.setText("");
        txtnamabb.setText("");
        txtbb.requestFocus();
    }
    
}
