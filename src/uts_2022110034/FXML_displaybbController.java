/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_2022110034;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Muhamad Iwani Madjid
 */
public class FXML_displaybbController implements Initializable {

    @FXML
    private Button btnkeluar;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnawal;
    @FXML
    private TableView<ModelBb> tbvbb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<ModelBb> data=FXMLDocumentController.dtbb.Load();
        if(data!=null){            
            tbvbb.getColumns().clear();
            tbvbb.getItems().clear();
            TableColumn col=new TableColumn("IDBB");
            col.setCellValueFactory(new PropertyValueFactory<ModelBb, String>("IDBB"));
            tbvbb.getColumns().addAll(col);
            col=new TableColumn("NAMABB");
            col.setCellValueFactory(new PropertyValueFactory<ModelBb, String>("NAMABB"));
            tbvbb.getColumns().addAll(col);

            tbvbb.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvbb.getScene().getWindow().hide();
       }
    }
       

    @FXML
    private void keluarclick(ActionEvent event) {
    }

    @FXML
    private void ubahclick(ActionEvent event) {
    }

    @FXML
    private void hapusclick(ActionEvent event) {
    }

    @FXML
    private void tambahclick(ActionEvent event) {
    }

    @FXML
    private void akhirclick(ActionEvent event) {
    }

    @FXML
    private void sesudahclick(ActionEvent event) {
    }

    @FXML
    private void sebelumclick(ActionEvent event) {
    }

    @FXML
    private void awalclick(ActionEvent event) {
    }
    
}
