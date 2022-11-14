package ProcessorM;

import PizzaOrder.PizzaOrder;
import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import database.OrderConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;


public class ProcessDisplay {


    private PizzaOrder currentcustomer = new PizzaOrder();
    @FXML
    private Label PizzaType;


    public void labels(){
        PizzaType.setText("Hi");
        
    }
    @FXML
    void processOrder(ActionEvent event) {
        labels();
        //adds one to PizzaNumber to shift the order that is pointed
    }

}
