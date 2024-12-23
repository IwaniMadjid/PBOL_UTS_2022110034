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
public class FXML_inputsupplierController implements Initializable {

    @FXML
    private TextField txtkontaksupplier;
    @FXML
    private TextField txtalamatsupplier;
    @FXML
    private TextField txtidsupplier;
    @FXML
    private TextField txtnamasupplier;
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
        
    public void execute(ModelSupplier d){
        if(!d.getIDSUPPLIER().isEmpty()){
          editdata=true;
          txtidsupplier.setText(d.getIDSUPPLIER());
          txtnamasupplier.setText(d.getNAMASUPPLIER());
          txtalamatsupplier.setText(d.getALAMATSUPPLIER());
          txtkontaksupplier.setText(d.getKONTAKSUPPLIER());
          txtidsupplier.setEditable(false);
          txtnamasupplier.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelSupplier s=new ModelSupplier();
        s.setIDSUPPLIER(txtidsupplier.getText());
        s.setNAMASUPPLIER(txtnamasupplier.getText());
        s.setALAMATSUPPLIER(txtalamatsupplier.getText());
        s.setKONTAKSUPPLIER(txtkontaksupplier.getText());
        FXML_menuController.dtSupplier.setModelSupplier(s);
        if(editdata){
            if(FXML_menuController.dtSupplier.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtidsupplier.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtSupplier.validasi(s.getIDSUPPLIER())<=0){
            if(FXML_menuController.dtSupplier.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtidsupplier.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtidsupplier.setText("");
        txtnamasupplier.setText("");
        txtalamatsupplier.setText("");
        txtkontaksupplier.setText("");
        txtidsupplier.requestFocus();
    }
    
}
