package CustomerM;
import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.*;
import java.util.Observer;
import java.util.Observable;


import java.io.IOException;



public class CustomerDisplay implements Observer{

    private int PizzaNumber = 1;
    private int pizzaType; //0: pepperoni, 1: veggie, 2: cheese
    private boolean mushroom = false;
    private boolean onion = false;
    private boolean olives = false;
    private boolean extraCheese = false;
    private String pickupTime;
    private boolean acceptedStatus = false;
    private String cookStatus = "Processing";
    private String asuID;
    @FXML
    private TextField iD;

    @FXML
    private TextField pickTime;

    @FXML
    private Font x1;

    @FXML
    private Font x11;

    @FXML
    private Color x2;

    @FXML
    private Color x21;

    @FXML
    private Font x3;

    @FXML
    private Color x4;


    @FXML
    private CheckBox mushroomBox;

    @FXML
    private CheckBox extraCheeseBox;

    @FXML
    private CheckBox oliveBox;

    @FXML
    private CheckBox onionBox;

    @FXML
    private Label statuslabel;

    @FXML
    private RadioButton cheesePizza;

    @FXML
    private RadioButton pepPizza;

    @FXML
    private RadioButton veggiePizza;

    @Override
    public void update(Observable o, Object arg) {

        //check SQL database and update the javaFX
        String a = OrderConnection.PizzaStatus(1);
        statuslabel.setText(a);
    }


    public static Boolean checkID(String asuID) throws IOException {

        File file = new File(CustomerDisplay.class.getResource("data.txt").getFile());
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            if(scan.nextLine().equals(asuID)){
                return true;
            }
        }
        return false;
    }

    @FXML
    void CheckOut(ActionEvent event) throws IOException {
        asuID = iD.getText();
        if(checkID(asuID) == true) {
            System.out.println(asuID);
            pickupTime = pickTime.getText();
            PizzaNumber = OrderConnection.getMax() + 1;
            //store customerOrder in database
            OrderConnection.insertOrder(PizzaNumber, asuID, pizzaType, mushroom, onion, olives, extraCheese, pickupTime, acceptedStatus, cookStatus);
            FXMLLoader fxmlLoader = new FXMLLoader(CustomerDisplay.class.getResource("CustomerStatus.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
            System.out.println(PizzaNumber);
        }
        else iD.setText("Invalid ASUID");
    }

    @FXML
    void pickTime(ActionEvent event) {

    }

    @FXML
    void topExtraCheese(ActionEvent event) {
        if(extraCheeseBox.isSelected())

            extraCheese = true;
        else extraCheese = false;
    }

    @FXML
    void topMushroom(ActionEvent event) {

        if(mushroomBox.isSelected())

            mushroom = true;
        else mushroom = false;
    }

    @FXML
    void orderStatus(ActionEvent event) {
        String a = OrderConnection.PizzaStatus(PizzaNumber);
        statuslabel.setText(a);
    }

    @FXML
    void topOlives(ActionEvent event) {
        if(oliveBox.isSelected())
            olives = true;
        else olives = false;
    }

    @FXML
    void topOnion(ActionEvent event) {
        if(onionBox.isSelected())
            onion = true;
        else onion = false;
    }

    @FXML
    void typeCheese(ActionEvent event) {
        if(cheesePizza.isSelected())
            pizzaType = 2;
    }

    @FXML
    void typePepperoni(ActionEvent event) {
        if(pepPizza.isSelected())
            pizzaType = 0;
    }

    @FXML
    void typeVeggie(ActionEvent event) {
        if(veggiePizza.isSelected())
            pizzaType = 1;
    }

/*
    public static void main(String[] args) {

        ChefDisplay watched = new ChefDisplay();

        CustomerDisplay watcher = new CustomerDisplay();

        watched.addObserver(watcher);

        watched.findStatus();

        if (watched.hasChanged())
            watcher.changeLabel(watched.findStatus());
        else
            System.out.println("Value not changed");
    }
    public void changeLabel(String value) {
        statuslabel.setText(value);
    }

    @Override
    public void update(Observable o, Object arg) {
        changeLabel(OrderConnection.PizzaStatus(1));
    }*/
}

