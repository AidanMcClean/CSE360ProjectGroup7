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

    public Queue<Customer> CustomerList = new LinkedList<>();
    @FXML
    private TextField tfTitle;
    private Customer currentcustomer = new Customer();


    @FXML
    void processOrder(ActionEvent event) {

        currentcustomer = CustomerList.remove();

    }

}
