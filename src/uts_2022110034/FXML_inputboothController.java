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
public class FXML_inputboothController implements Initializable {

    @FXML
    private TextField txtidbooth;
    @FXML
    private TextField txtnamabooth;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;
    
 boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelBooth d){
        if(!d.getIDBOOTH().isEmpty()){
          editdata=true;
          txtidbooth.setText(d.getIDBOOTH());
          txtnamabooth.setText(d.getNAMABOOTH());
          txtidbooth.setEditable(false);
          txtnamabooth.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelBooth s=new ModelBooth();
        s.setIDBOOTH(txtidbooth.getText());
        s.setNAMABOOTH(txtnamabooth.getText());
        FXML_menuController.dtBooth.setModelBooth(s);
        if(editdata){
            if(FXML_menuController.dtBooth.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtidbooth.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtBooth.validasi(s.getIDBOOTH())<=0){
            if(FXML_menuController.dtBooth.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtidbooth.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtidbooth.setText("");
        txtnamabooth.setText("");
        txtidbooth.requestFocus();
    }
    
}
