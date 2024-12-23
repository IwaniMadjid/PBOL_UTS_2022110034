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
public class FXML_displaysupplierController implements Initializable {

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
    private TableView<ModelSupplier> tbvsupplier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ObservableList<ModelSupplier> data=FXMLDocumentController.dtsupplier.Load();
        if(data!=null){            
            tbvsupplier.getColumns().clear();
            tbvsupplier.getItems().clear();
            TableColumn col=new TableColumn("IDSUPPLIER");
            col.setCellValueFactory(new PropertyValueFactory<ModelSupplier, String>("IDSUPPLIER"));
            tbvsupplier.getColumns().addAll(col);
            col=new TableColumn("NAMASUPPLIER");
            col.setCellValueFactory(new PropertyValueFactory<ModelSupplier, String>("NAMASUPPLIER"));
            tbvsupplier.getColumns().addAll(col);
            col=new TableColumn("ALAMATSUPPLIER");
            col.setCellValueFactory(new PropertyValueFactory<ModelSupplier, String>("ALAMATSUPPLIER"));
            tbvsupplier.getColumns().addAll(col);
            col=new TableColumn("KONTAKSUPPLIER");
            col.setCellValueFactory(new PropertyValueFactory<ModelSupplier, String>("KONTAKSUPPLIER"));
            tbvsupplier.getColumns().addAll(col);
            tbvsupplier.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvsupplier.getScene().getWindow().hide();
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
