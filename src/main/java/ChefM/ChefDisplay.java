package ChefM;

import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jdk.jfr.TransitionFrom;
import CustomerM.CustomerDisplay;
import java.util.*;
import java.util.Observer; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Stack;
import java.sql.*;
import static database.OrderConnection.getConnection;


public class ChefDisplay extends Observable {

    public void incre() {
        setChanged();
        notifyObservers();
    }

    @FXML
    public void cookingStatus(ActionEvent event) {
        //1 in database
        OrderConnection.updateStatus("Cooking", 1);
        OrderConnection.PrintDB();
        incre();
    }

    @FXML
    void finishStatus(ActionEvent event) {
    //2 in database
        OrderConnection.updateStatus("Ready", 1);
        OrderConnection.PrintDB();
        incre();
    }

    @FXML
    void readyStatus(ActionEvent event) {
    //0 in database
        OrderConnection.updateStatus("Ready to Cook", 1);
        OrderConnection.PrintDB();
        incre();
    }
}
