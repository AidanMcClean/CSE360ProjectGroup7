package ProcessorM;

import PizzaOrder.PizzaOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.Queue;


public class ProcessDisplay {

    public Queue<PizzaOrder> CustomerList = new LinkedList<>();
    @FXML
    private TextField tfTitle;
    private PizzaOrder currentcustomer = new PizzaOrder();


    @FXML
    void processOrder(ActionEvent event) {

        currentcustomer = CustomerList.remove();

    }

}
