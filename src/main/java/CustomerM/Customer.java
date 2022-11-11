package CustomerM;
import PizzaOrder.PizzaOrder;

import java.util.*;

public class Customer {
	//Instance Variables
	private String asuID;
	private String asuEmail;
	private PizzaOrder pizza;

	public Customer() {
		asuID = "";
        asuEmail = asuID + "@asu.edu";
        pizza = null;
	}

	public Customer(String ID/*, PizzaOrder order*/) {
		asuID = ID;
		asuEmail = ID + "@asu.edu";
		//pizza = new PizzaOrder(order);
	}

	public String getID(){
		return asuID;
	}

	public String getEmail() {
		return asuEmail;
	}

	public PizzaOrder getOrder() {
		return new PizzaOrder(pizza);
	}


}