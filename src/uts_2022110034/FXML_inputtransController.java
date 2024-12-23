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
public class FXML_inputtransController implements Initializable {

    @FXML
    private DatePicker dtptgltransaksi;
    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private TextField txtidkaryawan;
    @FXML
    private TextField txtidtransaksi;
    @FXML
    private TextField txtwkttransaksi;

 boolean editdata=false;

    /**
     * Initializes the controller class.
     */
        
    public void execute(ModelTrans d){
        if(!d.getIDTRANSAKSI().isEmpty()){
          editdata=true;
          txtidtransaksi.setText(d.getIDTRANSAKSI());
          txtidkaryawan.setText(d.getIDKARYAWAN());
          dtptgltransaksi.setValue(d.getTGLTRANSAKSI().toLocalDate());
          txtidtransaksi.setEditable(false);
          txtidkaryawan.setEditable(false);
          txtidtransaksi.requestFocus();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         ModelTrans s=new ModelTrans();
        s.setIDTRANSAKSI(txtidtransaksi.getText());
        s.setIDKARYAWAN(txtidkaryawan.getText());
        s.setTGLTRANSAKSI(Date.valueOf(dtptgltransaksi.getValue()));
        FXML_menuController.dtTrans.setModelTrans(s);
        if(editdata){
            if(FXML_menuController.dtTrans.update()){
        Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtidtransaksi.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXML_menuController.dtTrans.validasi(s.getIDTRANSAKSI())<=0){
            if(FXML_menuController.dtTrans.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtidtransaksi.requestFocus();
        }

    }


    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void batalklik(ActionEvent event) {
         txtidtransaksi.setText("");
        txtidkaryawan.setText("");
        dtptgltransaksi.getEditor().clear();
        txtidtransaksi.requestFocus();
    }
    
}
