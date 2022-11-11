package CustomerM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CustomerDisplay {

    private int pizzaType; //0: pepperoni, 1: veggie, 2: cheese
    private boolean mushroom;
    private boolean onion;
    private boolean olives;
    private boolean extraCheese;
    private String pickupTime;
    private boolean acceptedStatus;
    private String cookStatus;

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
    void CheckOut(ActionEvent event) {

    }

    @FXML
    void asuID(ActionEvent event) {

    }

    @FXML
    void pickTime(ActionEvent event) {

    }

    @FXML
    void topExtraCheese(ActionEvent event) {
        boolean extraCheese = true;
    }

    @FXML
    void topMushroom(ActionEvent event) {
        boolean mushroom = true;
    }

    @FXML
    void topOlives(ActionEvent event) {
        boolean olives = true;
    }

    @FXML
    void topOnion(ActionEvent event) {
        boolean onion = true;
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

