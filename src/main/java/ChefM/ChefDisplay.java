package ChefM;

import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import jdk.jfr.TransitionFrom;
import CustomerM.CustomerDisplay;
import java.util.*;
import java.util.Observer;
import java.util.Observable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Stack;
import java.sql.*;
import static database.OrderConnection.getConnection;



@SuppressWarnings("deprecation")
public class ChefDisplay{

    private String watchedValue = " ";

    @FXML
    private RadioButton rdyToCook;

    @FXML
    private RadioButton cooking;

    @FXML
    private RadioButton ready;

    private int pizzaNumber = OrderConnection.getMin();

    public String findStatus() {
        return watchedValue;
    }

    @FXML
    public void cookingStatus(ActionEvent event) {
        //1 in database
        if (cooking.isSelected()) {
            pizzaNumber = OrderConnection.getMin();
            if(OrderConnection.acceptedStatus(pizzaNumber) == true) {
                OrderConnection.updateStatus("Cooking", pizzaNumber);
            }
        }
    }

    @FXML
    void finishStatus(ActionEvent event) {
    //2 in database
        if (ready.isSelected()) {
            pizzaNumber = OrderConnection.getMin();
            if(OrderConnection.acceptedStatus(pizzaNumber) == true) {
                OrderConnection.updateStatus("Ready", pizzaNumber);
                OrderConnection.DeleteRow(pizzaNumber);
            }
        }
    }

    @FXML
    void readyStatus(ActionEvent event) {
    //0 in database
        if (rdyToCook.isSelected()) {
            pizzaNumber = OrderConnection.getMin();
            if(OrderConnection.acceptedStatus(pizzaNumber) == true) {
                OrderConnection.updateStatus("Ready to cook", pizzaNumber);
            }
        }
    }
}
