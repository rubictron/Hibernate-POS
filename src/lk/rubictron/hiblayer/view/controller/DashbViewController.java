/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class DashbViewController implements Initializable {

    @FXML
    private AnchorPane ap;

    @FXML
    private AnchorPane apmain;

    @FXML
    private AnchorPane apleft;
    @FXML
    private AnchorPane aptop;
    @FXML
    private JFXButton btnItem;
    @FXML
    private JFXButton btnCustomer;
    @FXML
    private JFXButton btnReport;
    @FXML
    private JFXButton btnPlaseOrder;
    @FXML
    private JFXButton btnManageOrder;


    public DashbViewController() {
        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadAnchor("order");
    }


    @FXML
    private void clickBtnItem(MouseEvent event) {
        loadAnchor("item");

    }

    @FXML
    private void clickBtnCustomer(MouseEvent event) {
        loadAnchor("customer");

    }

    @FXML
    private void clickBtnReport(MouseEvent event) {
        loadAnchor("report");
    }

    @FXML
    private void clickBtnPlaseOrder(MouseEvent event) {
        loadAnchor("order");

    }

    @FXML
    private void clickBtnManageOrder(MouseEvent event) {

        loadAnchor("orderManage");

    }

    private void loadAnchor(String name) {
        try {
            apmain.getChildren().clear();
            Parent loder = FXMLLoader.load(getClass().getResource("/lk/rubictron/hiblayer/view/ui/" + name + ".fxml"));
            apmain.getChildren().add(loder);

            Node n = (Node) loder;
            AnchorPane.setTopAnchor(n, 0.0);
            AnchorPane.setRightAnchor(n, 0.0);
            AnchorPane.setLeftAnchor(n, 0.0);
            AnchorPane.setBottomAnchor(n, 0.0);
        } catch (IOException ex) {
            Logger.getLogger(DashbViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void alart(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
