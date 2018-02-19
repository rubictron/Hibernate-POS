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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.rubictron.hiblayer.view.util.tablemodel.ItemTM;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.MouseEvent;
import lk.rubictron.hiblayer.controller.ItemController;
import lk.rubictron.hiblayer.controller.impl.ItemControllerImpl;
import lk.rubictron.hiblayer.dto.ItemDTO;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class ItemViewController implements Initializable {

    @FXML
    private AnchorPane root2;
    @FXML
    private JFXTextField textfItemId=null;
    @FXML
    private JFXTextField textfName;
    @FXML
    private JFXButton btnSerch;
    @FXML
    private JFXTextField textfQuentity;
    @FXML
    private JFXTextField textfUnitPrice;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnViewAll;
    @FXML
    private TableView<ItemTM> tableItem;

    private final ItemController itemController;

    public ItemViewController() {

        itemController = new ItemControllerImpl();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        tableItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        
        
        viewAll();

        tableItem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemTM>() {

            @Override
            public void changed(ObservableValue<? extends ItemTM> observable, ItemTM oldValue, ItemTM newValue) {

                ItemTM currentRow = observable.getValue();
                if (currentRow != null) {
                    textfItemId.setText(String.valueOf(currentRow.getId()));
                    textfName.setText(currentRow.getName());
                    textfQuentity.setText(String.valueOf(currentRow.getQuantity()));
                    textfUnitPrice.setText(String.valueOf(currentRow.getUnitPrice()));

                }else tableItem.refresh();
            }
        });

    }

    @FXML
    private void abtnSerch(ActionEvent event) {
        
        try {
            ArrayList<ItemDTO> item = itemController.search(textfItemId.getText());
            ArrayList<ItemTM> alitem = new ArrayList<ItemTM>();
            for (ItemDTO dto : item) {
                alitem.add(new ItemTM(dto.getId(), dto.getName(), dto.getQuantity(), dto.getUnitPrice()));
            }
            ObservableList<ItemTM> allItem = FXCollections.observableArrayList(alitem);

            tableItem.setItems(allItem);
            tableItem.refresh();
        } catch (Exception ex) {
            Logger.getLogger(ItemViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @FXML
    private void abtnSave(ActionEvent event) {
        boolean update=true;
        int id=-1;
        
        try{
        id=Integer.parseInt(textfItemId.getText());
        }catch(Exception e){
            
        }
       
        if(id<0){
        update=false;
        
        try {
             ItemDTO dto = new ItemDTO(
                    textfName.getText(),
                    Integer.parseInt(textfQuentity.getText()),
                    Double.parseDouble(textfUnitPrice.getText()));
            itemController.add(dto);
            viewAll();
           

        } catch (Exception ex) {
            Logger.getLogger(ItemViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        else if(update){
        try {
            
             ItemDTO dto = new ItemDTO(
                    Integer.parseInt(textfItemId.getText()),
                    textfName.getText(),
                    Integer.parseInt(textfQuentity.getText()),
                    Double.parseDouble(textfUnitPrice.getText()));
            itemController.update(dto);
            viewAll();
           

        } catch (Exception ex) {
            Logger.getLogger(ItemViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }

    @FXML
    private void abtnDelete(ActionEvent event) {
        try {
            int id = tableItem.getSelectionModel().getSelectedItem().getId();
            itemController.delete(id);
            viewAll();

        } catch (Exception ex) {
            Logger.getLogger(ItemViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void abtnViewAll(MouseEvent event) {
        viewAll();
        tableItem.refresh();
    }

    private void viewAll() {

        try {
            ArrayList<ItemDTO> item = itemController.getAll();
            ArrayList<ItemTM> alitem = new ArrayList<ItemTM>();
            for (ItemDTO dto : item) {
                alitem.add(new ItemTM(dto.getId(), dto.getName(), dto.getQuantity(), dto.getUnitPrice()));
            }
            ObservableList<ItemTM> allitem = FXCollections.observableArrayList(alitem);
            tableItem.setItems(allitem);
            tableItem.refresh();

        } catch (Exception ex) {
            Logger.getLogger(ItemViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
