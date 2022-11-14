package ChefM;

import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
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

    private String watchedValue = " ";

    @FXML
    private RadioButton rdyToCook;

    @FXML
    private RadioButton cooking;

    @FXML
    private RadioButton ready;


    public String findStatus() {
        return watchedValue;
    }

    @FXML
    public void cookingStatus(ActionEvent event) {
        //1 in database
        if (cooking.isSelected()) {
            OrderConnection.updateStatus("Cooking", 1);
            OrderConnection.PrintDB();
            watchedValue = "Cooking";
            setChanged();
        }
    }

    @FXML
    void finishStatus(ActionEvent event) {
    //2 in database
        if (ready.isSelected()) {
            OrderConnection.updateStatus("Ready", 1);
            OrderConnection.PrintDB();
            watchedValue = "Ready";
            setChanged();
        }
    }

    @FXML
    void readyStatus(ActionEvent event) {
    //0 in database
        if (rdyToCook.isSelected()) {
            OrderConnection.updateStatus("Ready to Cook", 1);
            OrderConnection.PrintDB();
            watchedValue = "Ready to Cook";
            setChanged();
        }
    }
}
