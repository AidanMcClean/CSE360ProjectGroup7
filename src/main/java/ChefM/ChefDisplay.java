package ChefM;

import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jdk.jfr.TransitionFrom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Stack;
import java.sql.*;
import static database.OrderConnection.getConnection;


public class ChefDisplay {  

    @FXML
    void cookingStatus(ActionEvent event) {
        //1 in database
        OrderConnection.updateStatus("Cooking", 1);
        OrderConnection.PrintDB();
    }

    @FXML
    void finishStatus(ActionEvent event) {
    //2 in database
        OrderConnection.updateStatus("Ready", 1);
        OrderConnection.PrintDB();
    }

    @FXML
    void readyStatus(ActionEvent event) {
    //0 in database
        OrderConnection.updateStatus("Ready to Cook", 1);
        OrderConnection.PrintDB();
    }
}
