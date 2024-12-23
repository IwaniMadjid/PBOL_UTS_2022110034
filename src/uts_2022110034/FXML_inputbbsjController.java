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
public class FXML_inputbbsjController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtnamabbsj;
    @FXML
    private TextField txtbbsj;

     boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelBbsj d){
        if(!d.getIDBBSJ().isEmpty()){
          editdata=true;
          txtbbsj.setText(d.getIDBBSJ());
          txtnamabbsj.setText(d.getNAMABBSJ());
          txtbbsj.setEditable(false);
          txtnamabbsj.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelBbsj s=new ModelBbsj();
        s.setIDBBSJ(txtbbsj.getText());
        s.setNAMABBSJ(txtnamabbsj.getText());
        FXML_menuController.dtBbsj.setModelBbsj(s);
        if(editdata){
            if(FXML_menuController.dtBbsj.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtbbsj.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtBbsj.validasi(s.getIDBBSJ())<=0){
            if(FXML_menuController.dtBbsj.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtbbsj.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtbbsj.setText("");
        txtnamabbsj.setText("");
        txtbbsj.requestFocus();
    }
    
}
