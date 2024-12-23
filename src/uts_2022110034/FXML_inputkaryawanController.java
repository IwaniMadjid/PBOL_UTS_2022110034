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
public class FXML_inputkaryawanController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtnamakaryawan;
    @FXML
    private TextField txtidkaryawan;
    @FXML
    private TextField txtalamat;
    @FXML
    private TextField txtkontak;

 boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelKaryawan d){
        if(!d.getIDKARYAWAN().isEmpty()){
          editdata=true;
          txtidkaryawan.setText(d.getIDKARYAWAN());
          txtnamakaryawan.setText(d.getNAMAKARYAWAN());
          txtalamat.setText(d.getALAMAT());
          txtkontak.setText(d.getKONTAK());
          txtidkaryawan.setEditable(false);
          txtnamakaryawan.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelKaryawan s=new ModelKaryawan();
        s.setIDKARYAWAN(txtidkaryawan.getText());
        s.setNAMAKARYAWAN(txtnamakaryawan.getText());
        s.setALAMAT(txtalamat.getText());
        s.setKONTAK(txtkontak.getText());
        FXML_menuController.dtKaryawan.setModelKaryawan(s);
        if(editdata){
            if(FXML_menuController.dtKaryawan.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtidkaryawan.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtKaryawan.validasi(s.getIDKARYAWAN())<=0){
            if(FXML_menuController.dtKaryawan.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtidkaryawan.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtidkaryawan.setText("");
        txtnamakaryawan.setText("");
        txtalamat.setText("");
        txtkontak.setText("");
        txtidkaryawan.requestFocus();
    }
    
}
