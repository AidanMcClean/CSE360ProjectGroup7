package CustomerM;
import PizzaOrder.PizzaOrder;
import ProcessorM.ProcessDisplay;
import database.OrderConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;

import CustomerM.CustomerEX;

import java.io.IOException;

public class CustomerDisplay {

    private int PizzaNumber = 1;
    private int pizzaType; //0: pepperoni, 1: veggie, 2: cheese
    private boolean mushroom = false;
    private boolean onion = false;
    private boolean olives = false;
    private boolean extraCheese = false;
    private String pickupTime;
    private boolean acceptedStatus = false;
    private String cookStatus;
    private String asuID;
    @FXML
    private TextField iD;

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
<<<<<<< Updated upstream
    private CheckBox Mushroombox;
=======
    private CheckBox mushroomBox;

    @FXML
    private CheckBox extraCheeseBox;

    @FXML
    private CheckBox oliveBox;

    @FXML
    private CheckBox onionBox;

>>>>>>> Stashed changes

    @FXML
    void CheckOut(ActionEvent event) throws IOException {
        asuID = iD.getText();
        System.out.println(asuID);
        //store customerOrder in database
        OrderConnection.insertOrder(PizzaNumber, asuID, pizzaType, mushroom,onion,olives,extraCheese,pickupTime,acceptedStatus,cookStatus); //test statement
        OrderConnection.PrintDB(); //test
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDisplay.class.getResource("CustomerStatus.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
        System.out.println(PizzaNumber);
        System.out.println(mushroom);
        PizzaNumber++; //if the order is successful ++ the key
    }

    @FXML
    void pickTime(ActionEvent event) {
            
    }

    @FXML
    void topExtraCheese(ActionEvent event) {
<<<<<<< Updated upstream

        if(extraCheese = false)
=======
        if(extraCheeseBox.isSelected())
>>>>>>> Stashed changes
            extraCheese = true;
        else extraCheese = false;
    }

    @FXML
    void topMushroom(ActionEvent event) {
<<<<<<< Updated upstream
        if(Mushroombox.isSelected())
=======
        if(mushroomBox.isSelected())
>>>>>>> Stashed changes
            mushroom = true;
        else mushroom = false;
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
        pizzaType = 2;
    }

    @FXML
    void typePepperoni(ActionEvent event) {
        pizzaType = 0;
    }

    @FXML
    void typeVeggie(ActionEvent event) {
        pizzaType = 1;
    }

}

