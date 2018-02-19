/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.rubictron.hiblayer.controller.CustomerController;
import lk.rubictron.hiblayer.controller.ItemController;
import lk.rubictron.hiblayer.controller.OrderController;
import lk.rubictron.hiblayer.controller.impl.CustomerControllerImpl;
import lk.rubictron.hiblayer.controller.impl.ItemControllerImpl;
import lk.rubictron.hiblayer.controller.impl.OrderControllerImpl;
import lk.rubictron.hiblayer.dto.CustomerDTO;
import lk.rubictron.hiblayer.dto.ItemDTO;
import lk.rubictron.hiblayer.dto.OrderDTO;
import lk.rubictron.hiblayer.dto.OrderDetailsDTO;
import lk.rubictron.hiblayer.view.util.tablemodel.OrderTM;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class OrderViewController implements Initializable {

    private static ItemDTO item;
    ObservableList<OrderTM> alorder;
    OrderController orderController;
    ItemController itemController;
    CustomerController customerController;
    ArrayList<OrderTM> orders = new ArrayList<>();

    @FXML
    private JFXButton btno_add;
    @FXML
    private JFXButton btno_delete;
    @FXML
    private JFXButton btno_confirm;
    @FXML
    private JFXButton btno_confirm1;
    @FXML
    private TableView<OrderTM> tableo;
    @FXML
    private JFXTextField textf_item;
    @FXML
    private JFXComboBox<Integer> cbox_item;
    @FXML
    private JFXTextField textf_orderId;
    @FXML
    private JFXTextField textf_cusname;
    @FXML
    private JFXComboBox<Integer> cbox_cus;
    @FXML
    private JFXDatePicker textf_date;
    @FXML
    private JFXButton btnSerchItem;
    @FXML
    private JFXButton btnSerchCustomer;
    @FXML
    private JFXTextField textf_itemQty;
    @FXML
    private JFXTextField textf_totalOfOne;
    @FXML
    private JFXTextField textf_total;

    public OrderViewController() {
        orderController = new OrderControllerImpl();
        itemController = new ItemControllerImpl();
        customerController = new CustomerControllerImpl();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableo.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableo.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tableo.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tableo.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableo.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

       // textf_date.getEditor().setText(String.valueOf(LocalDate.now()));

        try {
            ArrayList<ItemDTO> item = itemController.getAll();
            item.forEach((dto) -> {
                cbox_item.getItems().add(dto.getId());
            });

            ArrayList<CustomerDTO> customer = customerController.getAll();
            customer.forEach((dto) -> {
                cbox_cus.getItems().add(dto.getId());
            });

        } catch (Exception ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        cbox_cus.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                int id = observable.getValue();
                CustomerDTO cus = customerController.getById(id);
                String name = cus.getName();
                textf_cusname.setText(name);
            } catch (Exception ex) {
                Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        cbox_item.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                int id = observable.getValue();
                ItemDTO item1 = itemController.getById(id);
                textf_item.setText(item1.getName());
                textf_totalOfOne.setPromptText("Unit Price :" + item1.getUnitPrice());
                textf_itemQty.setPromptText("Select Quentity from :" + item1.getQuantity());
                OrderViewController.item = item1;
                textf_itemQty.clear();
                textf_totalOfOne.clear();
            } catch (Exception ex) {
                Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        tableo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrderTM>() {
            @Override
            public void changed(ObservableValue<? extends OrderTM> observable, OrderTM oldValue, OrderTM newValue) {

                OrderTM order = observable.getValue();
                cbox_item.getSelectionModel().select(order.getId());
                textf_itemQty.setText(String.valueOf(order.getQuantity()));
                textf_totalOfOne.setText(String.valueOf(order.getTotal()));

            }
        });

    }

    @FXML
    private void abtnAdd(ActionEvent event) {

        alorder = FXCollections.observableArrayList(orders);
        boolean update = false;
        double sum = 0;
        for (OrderTM oder : orders) {

            if (oder.getId() == cbox_item.getSelectionModel().getSelectedItem()) {

                update = true;

                oder.setItemName(textf_item.getText());
                oder.setQuantity(Integer.parseInt(textf_itemQty.getText()));
                oder.setTotal(Double.parseDouble(textf_totalOfOne.getText().substring(8)));
            }
            sum += oder.getTotal();

        }
        if (!update) {

            orders.add(new OrderTM(
                    cbox_item.getSelectionModel().getSelectedItem(),
                    textf_item.getText(),
                    item.getUnitPrice(),
                    Integer.parseInt(textf_itemQty.getText()),
                    Double.parseDouble(textf_totalOfOne.getText().substring(8))
            )
            );

            sum += Double.parseDouble(textf_totalOfOne.getText().substring(8));

        }

        textf_total.setText(String.valueOf(sum));
        alorder = FXCollections.observableArrayList(orders);
        tableo.setItems(alorder);
        tableo.refresh();

    }

    @FXML
    private void abtnDelete(ActionEvent event) {

        OrderTM remove = tableo.getSelectionModel().getSelectedItem();
        
        double sum = Double.parseDouble(textf_total.getText()) - remove.getTotal();
        
        textf_total.setText(String.valueOf(sum));
        
        orders.remove(remove);
        
        alorder = FXCollections.observableArrayList(orders);
        
        tableo.setItems(alorder);
        
        tableo.refresh();
    }

    @FXML
    private void abtnConfirm(ActionEvent event) {

        try {
            List<OrderTM> orderTM = tableo.getItems();
            ArrayList<OrderDetailsDTO> orderArray = new ArrayList<>();

            for (OrderTM order : orderTM) {

                orderArray.add(new OrderDetailsDTO(
                        //Integer.parseInt(textf_orderId.getText()),
                        order.getId(),
                        order.getQuantity())
                );

            }
           
            OrderDTO orderDto = new OrderDTO(
                    textf_date.getEditor().getText(),
                    cbox_cus.getSelectionModel().getSelectedItem(),
                    Double.parseDouble(textf_total.getText()));

            orderController.placeOrder(orderDto, orderArray);
            textf_item.clear();
            textf_itemQty.clear();
            textf_totalOfOne.clear();
            textf_total.clear();

        } catch (Exception ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnSerchItem(ActionEvent event) {
        cbox_item.getItems().clear();
        try {
            ArrayList<ItemDTO> item = itemController.search(textf_cusname.getText());
            for (ItemDTO dto : item) {
                cbox_item.getItems().add(dto.getId());
                cbox_item.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnSerchCustomer(ActionEvent event) {
        cbox_cus.getItems().clear();
        try {
            ArrayList<CustomerDTO> customer = customerController.search(textf_cusname.getText());
            customer.forEach((dto) -> {
                cbox_cus.getItems().add(dto.getId());
                cbox_cus.show();
            });
        } catch (Exception ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void atextfUnitPrice(InputMethodEvent event) {

    }

    @FXML
    private void onkeyInQty(KeyEvent event) {
        setTotal();
    }

    private void setTotal() {

        if (Integer.parseInt(textf_itemQty.getText()) <= item.getQuantity()) {
            textf_totalOfOne.setText("Total = " + (OrderViewController.item.getUnitPrice() * Integer.parseInt(textf_itemQty.getText())));
        } else {
            textf_totalOfOne.setText("Out of Available Quentity");

        }
    }

    @FXML
    private void abtnCancel(ActionEvent event) {
    }

    @FXML
    private void clicktextf_cusname(MouseEvent event) {
    }

    @FXML
    private void key_on(KeyEvent event) {
    }

    @FXML
    private void click_cboxcus(MouseEvent event) {
    }

}
