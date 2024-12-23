/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_2022110034;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Muhamad Iwani Madjid
 */
public class FXML_inputbeliController implements Initializable {

    @FXML
    private TextField txtwktbeli;
    @FXML
    private TextField txtidbeli;
    @FXML
    private TextField txtidsupplier;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;
    @FXML
    private DatePicker dtptglbeli;

 boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelBeli d){
        if(!d.getIDBELI().isEmpty()){
          editdata=true;
          txtidbeli.setText(d.getIDBELI());
          txtidsupplier.setText(d.getIDSUPPLIER());
          dtptglbeli.setValue(d.getTGLBELI().toLocalDate());
          txtidbeli.setEditable(false);
          txtidsupplier.setEditable(false);
          txtidsupplier.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelBeli s=new ModelBeli();
        s.setIDBELI(txtidbeli.getText());
        s.setIDSUPPLIER(txtidsupplier.getText());
        s.setTGLBELI(Date.valueOf(dtptglbeli.getValue()));
        FXML_menuController.dtBeli.setModelBeli(s);
        if(editdata){
            if(FXML_menuController.dtBeli.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtidbeli.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtBeli.validasi(s.getIDBELI())<=0){
            if(FXML_menuController.dtBeli.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtidbeli.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
    System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtidbeli.setText("");
        txtidsupplier.setText("");
        dtptglbeli.getEditor().clear();
        txtwktbeli.setText("");
        txtidsupplier.requestFocus();
    }
    
}
