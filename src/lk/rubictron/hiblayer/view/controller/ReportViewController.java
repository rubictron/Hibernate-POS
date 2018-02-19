/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.hiblayer.view.controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import lk.rubictron.hiblayer.controller.OrderController;
import lk.rubictron.hiblayer.controller.impl.OrderControllerImpl;
import lk.rubictron.hiblayer.dto.OrderDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class ReportViewController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private JFXButton btnAllOrdersId;
    @FXML
    private JFXButton btnAllOrdersDate;

    OrderController orderController = new OrderControllerImpl();
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private JFXButton btnItemReport;

    /**
     * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            //OrderService servise = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
            ArrayList<OrderDTO> orders;

            orders = orderController.getAll();

            XYChart.Series series = new XYChart.Series();
            series.setName("All Orders");
            series.getData().clear();
            for (OrderDTO dto : orders) {

                series.getData().add(new XYChart.Data(dto.getDate(), dto.getTotalPrice()));
            }

            lineChart.getData().clear();
            lineChart.setVisible(false);
            barChart.getData().clear();
            barChart.getData().add(series);
            barChart.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(ReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnAllOrdersId(ActionEvent event) {

        try {
            // TODO
            barChart.setVisible(false);
            lineChart.setVisible(true);

            ArrayList<OrderDTO> orders;
            orders = orderController.getAll();
            XYChart.Series series = new XYChart.Series();
            series.setName("All Orders");
            series.getData().clear();
            for (OrderDTO dto : orders) {
                series.getData().add(new XYChart.Data(""+dto.getOrderId(), dto.getTotalPrice()));
            }
            lineChart.getData().clear();

            lineChart.getData().add(series);

        } catch (Exception ex) {
            Logger.getLogger(ReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnAllOrdersDate(ActionEvent event) {

        try {
            // TODO

            ArrayList<OrderDTO> orders;

            orders = orderController.getAll();
            
            
            XYChart.Series series = new XYChart.Series();
            series.setName("Daily income");
            series.getData().clear();
            int sumofday = 0;
            String pdate = null;
            for (OrderDTO dto : orders) {
                if (dto.getDate().equals(pdate)) {
                    sumofday += dto.getTotalPrice();
                } else {
                    sumofday = 0;
                    sumofday += dto.getTotalPrice();
                }
                series.getData().add(new XYChart.Data("" + dto.getDate(), sumofday));
                pdate = dto.getDate();
            }

            
            barChart.setVisible(true);
            lineChart.setVisible(false);
            barChart.getData().clear();
            barChart.getData().add(series);

        } catch (Exception ex) {
            Logger.getLogger(ReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    @SuppressWarnings("unchecked")
    private void abtnItemReport(ActionEvent event) {
        
        try {
            InputStream ism=getClass().getResourceAsStream("/lk/rubictron/hiblayer/view/util/report/Blank_A4.jasper");
            HashMap map=new HashMap();
            map.put("noOftem", 10);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hiblayer","root","1212");
            
            JasperViewer.viewReport(JasperFillManager.fillReport(ism,map,connection));

            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

}
