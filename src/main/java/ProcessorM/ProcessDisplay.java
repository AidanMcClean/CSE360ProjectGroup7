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
    private int pizzaN = 1;



    public void labels(){
        String type = " ";
       int a = OrderConnection.PizzaType(pizzaN);
       if(a == 0){
           type = "Pepperoni";
           PizzaType.setText(type);
       } else if (a == 1) {
           type = "Veggie";
           PizzaType.setText(type);
       } else if (a == 2) {
           type = "Cheese";
           PizzaType.setText(type);
       }else  System.out.println(");");
       OrderConnection.PrintDB();
        
    }
    @FXML
    void processOrder(ActionEvent event) {
        labels();
        //adds one to PizzaNumber to shift the order that is pointed
    }

}
