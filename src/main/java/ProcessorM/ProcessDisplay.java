package ProcessorM;

import PizzaOrder.PizzaOrder;
import CustomerM.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ProcessDisplay {

<<<<<<< Updated upstream
    public Queue<Customer> CustomerList = new LinkedList<>();
=======
    private Queue<PizzaOrder> CustomerList = new LinkedList<>();
>>>>>>> Stashed changes
    @FXML
    private TextField tfTitle;
    private PizzaOrder currentcustomer = new PizzaOrder();


    @FXML
    void processOrder(ActionEvent event) {

        currentcustomer = CustomerList.remove();

    }

}
