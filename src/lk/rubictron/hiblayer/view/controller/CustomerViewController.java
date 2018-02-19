/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.rubictron.hiblayer.controller.impl.CustomerControllerImpl;
import lk.rubictron.hiblayer.dto.CustomerDTO;
import lk.rubictron.hiblayer.view.util.tablemodel.CustomerTM;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class CustomerViewController implements Initializable {

    @FXML
    private AnchorPane root2;
    @FXML
    private JFXTextField textfCustomerId;
    @FXML
    private TableView<CustomerTM> tableCus;
    @FXML
    private JFXTextField textfName;
    @FXML
    private JFXButton btnSerch;
    @FXML
    private JFXTextField textfContact;
    @FXML
    private JFXTextField textfSalary;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnViewAll;

    CustomerControllerImpl customerController = new CustomerControllerImpl();

    public CustomerViewController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        tableCus.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableCus.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCus.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tableCus.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableCus.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {

            @Override
            public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {

                CustomerTM currentRow = observable.getValue();

                if (currentRow != null) {
                    textfCustomerId.setText(String.valueOf(currentRow.getId()));
                    textfName.setText(currentRow.getName());
                    textfContact.setText(currentRow.getContact());
                    textfSalary.setText(String.valueOf(currentRow.getSalary()));

                }

            }
        });

        ActionEvent event = new ActionEvent();
        clickBtnViewAll(event);

    }

    @FXML
    private void clickBtnSerch(MouseEvent event) {

        try {
            String id = textfCustomerId.getText();

            ArrayList<CustomerDTO> customer = customerController.search(id);
            ArrayList<CustomerTM> alcus = new ArrayList<CustomerTM>();
            for (CustomerDTO dto : customer) {
                alcus.add(new CustomerTM(dto.getId(), dto.getName(), dto.getContact(), dto.getSalary()));
            }
            ObservableList<CustomerTM> allcus = FXCollections.observableArrayList(alcus);

            tableCus.setItems(allcus);
            tableCus.refresh();
        } catch (Exception ex) {
            Logger.getLogger(CustomerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickBtnSave(MouseEvent event) {

        boolean update = false;
        
        int id=-1;
        
        try{
        id=Integer.parseInt(textfCustomerId.getText());
        }catch(Exception e){
            
        }
       
 
        
        if (id>0) {

            try {
                update = true;

                CustomerDTO dto = new CustomerDTO(Integer.parseInt(
                        textfCustomerId.getText()),
                        textfName.getText(),
                        textfContact.getText(),
                        Double.parseDouble(textfSalary.getText()));

                customerController.update(dto);
                clearall();
                ActionEvent event1 = new ActionEvent();
                clickBtnViewAll(event1);
            } catch (Exception ex) {
                Logger.getLogger(CustomerViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!update) {

            try {
                CustomerDTO dto = new CustomerDTO(
                        textfName.getText(),
                        textfContact.getText(),
                        Double.parseDouble(textfSalary.getText()));

                customerController.add(dto);
                clearall();
                ActionEvent event1 = new ActionEvent();
                clickBtnViewAll(event1);

            } catch (Exception ex) {
                Logger.getLogger(CustomerViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void clickBtnViewAll(ActionEvent event) {

        try {
            clearall();
            ArrayList<CustomerDTO> customer = customerController.getAll();
            ArrayList<CustomerTM> alcus = new ArrayList<CustomerTM>();
            for (CustomerDTO dto : customer) {
                alcus.add(new CustomerTM(dto.getId(), dto.getName(), dto.getContact(), dto.getSalary()));
            }
            ObservableList<CustomerTM> allcus = FXCollections.observableArrayList(alcus);

            tableCus.setItems(allcus);
            tableCus.refresh();
        } catch (Exception ex) {
            Logger.getLogger(CustomerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickBtnDelete(ActionEvent event) {

        try {
            int id = tableCus.getSelectionModel().getSelectedItem().getId();
            customerController.delete(id);
            clearall();
            clickBtnViewAll(event);

        } catch (Exception ex) {
            Logger.getLogger(CustomerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearall() {

        textfContact.clear();
        textfCustomerId.clear();
        textfName.clear();
        textfSalary.clear();

    }

    public void alart(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
