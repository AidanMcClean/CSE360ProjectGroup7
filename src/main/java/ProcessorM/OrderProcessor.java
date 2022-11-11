package ProcessorM;
import CustomerM.Customer;
import java.util.Queue;

import java.util.*;
public class OrderProcessor {

    private Queue<Customer> CustomerList = new LinkedList<>();

    public OrderProcessor() {
        CustomerList = null;
    }

    public void pushCustomer(Customer order) {
        CustomerList.add(order);
    }

    public Customer popCustomer() {
        return CustomerList.remove();
    }

}

