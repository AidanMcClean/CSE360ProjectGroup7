import ChefM.ChefDisplay;
import CustomerM.CustomerDisplay;
import ProcessorM.ProcessDisplay;
import PizzaOrder.PizzaOrder;
import database.OrderConnection;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Test.*;



public class TestCases {

    String asuID = "email";
    String asuEmail = asuID + "@asu.edu";
    String cookStatus = " ";
    int PizzaNumber = 0;
    int pizzaType = 0; //0: pepperoni, 1: veggie, 2: cheese
    boolean mushroom = false;
    boolean onion = false;
    boolean olives = false;
    boolean extraCheese = false;
    String pickupTime = "0:00";
    boolean acceptedStatus = false;


    PizzaOrder pizzaTester = new PizzaOrder(1, "ndehaven", 1, true, true, true,
            true, "20:00", true, "Ready");
    @Test
    public void PizzaNumberTest() { //
        assertEquals("getPizzaNumber is not functioning correctly",
                0,
                pizzaTester.getPizzaNumber());
    }

    @Test
    public void displayStatusTest() {
        assertEquals("displayStatus is not functioning correctly",
                "",
                pizzaTester.displayStatus());
    }

    @Test
    public void setStatusTest() {
        pizzaTester.setStatus("Cooking");
        assertEquals("setStatus is not functioning correctly",
                "Ready",
                pizzaTester.getStatus());
    }


    @Test
    public void getIDTest(){
        assertEquals("getId is not functioning correctly",
                "",
                pizzaTester.getID());
    }

    @Test
    public void getEmailTest() {
        assertEquals("getEmail is not functioning correctly",
                "email@asu.edu",
                pizzaTester.getEmail());
    }



}
