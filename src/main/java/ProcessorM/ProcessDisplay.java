package ProcessorM;

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


    @FXML
    private Label PizzaType;
    @FXML
    private Label PizzaToppings;

    @FXML
    private Label PickupTime;
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
       String pickTime = OrderConnection.PizzaTime(pizzaN);
       PickupTime.setText(pickTime);
       String toppings = OrderConnection.PizzaToppings(pizzaN);
       PizzaToppings.setText(toppings);
       pizzaN++;
    }
    @FXML
    void processOrder(ActionEvent event) {
        labels();
        //adds one to PizzaNumber to shift the order that is pointed
    }

}
