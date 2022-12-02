package PizzaOrder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaOrderTest {
    String asuID = "email";
    String asuEmail = asuID + "@asu.edu";
    String cookStatus = " ";
    int PizzaNumber = 0;
    PizzaOrder pizzaTester = new PizzaOrder(1, "ndehaven", 1, true, true, true,
            true, "20:00", true, "READY");

    @Test
    public void displayStatus() {
        pizzaTester.setStatus(PizzaOrder.statusType.ORDER_ACCEPTED);
        assertEquals("displayStatus is not functioning correctly",
                "ORDER ACCEPTED",
                pizzaTester.displayStatus());
    }

    @Test
    public void getStatus() {
        pizzaTester.setStatus(PizzaOrder.statusType.COOKING);
        assertEquals("getStatus is not functioning correctly",
                "COOKING",
                pizzaTester.getStatus());
    }

    @Test
    public void getID() {
        assertEquals("getId is not functioning correctly",
                "ndehaven",
                pizzaTester.getID());
    }

    @Test
    public void getEmail() {
        assertEquals("getEmail is not functioning correctly",
                "ndehaven@asu.edu",
                pizzaTester.getEmail());
    }

    @Test
    public void getPizzaNumber() {
        assertEquals("getPizzaNumber is not functioning correctly",
                1,
                pizzaTester.getPizzaNumber());
    }
}
