/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts_2022110034;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 *
 * @author Muhamad Iwani Madjid
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
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
    private TableView<ModelMenu> tbvmenu;
    
    public static DBMenu dtmenu = new DBMenu();
    public static DBKaryawan dtkaryawan = new DBKaryawan();
    public static DBBooth dtbooth = new DBBooth();
    public static DBBb dtbb = new DBBb();
    public static DBBbsj dtbbsj = new DBBbsj();
        public static DBBeli dtbeli = new DBBeli();



    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
