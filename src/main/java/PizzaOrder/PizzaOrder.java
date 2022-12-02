package PizzaOrder;

import java.util.*;

public class PizzaOrder {

    //instance variables
    private int PizzaNumber = 0;
    private String asuID;
    private String asuEmail;
    private int pizzaType; //0: pepperoni, 1: veggie, 2: cheese
    private boolean mushroom;
    private boolean onion;
    private boolean olives;
    private boolean extraCheese;
    private String pickupTime;
    private boolean acceptedStatus = true;
    private String cookStatus; // ORDER_ACCEPTED, COOKING, READY, N/A
    enum statusType{ORDER_ACCEPTED, COOKING, READY}

    public PizzaOrder() {
        PizzaNumber = 0;
        asuID = "";
        asuEmail = asuID + "@asu.edu";
        int pizzaType = 0; //0: pepperoni, 1: veggie, 2: cheese
        boolean mushroom = false;
        boolean onion = false;
        boolean olives = false;
        boolean extraCheese = false;
        String pickupTime = "0:00";
        boolean acceptedStatus = false;
        String cookStatus = "";
    }

    public PizzaOrder(int PizzaNumberi, String asuIDi,int Type, boolean mushroomi, boolean onioni, boolean olivesi, boolean extraCheesei, String pickupTimei, boolean acceptedStatusi, String cookStatusi) {
        PizzaNumber = PizzaNumberi;
        asuID = asuIDi;
        asuEmail = asuIDi + "@asu.edu";
        int pizzaType = Type; //0: pepperoni, 1: veggie, 2: cheese
        boolean mushroom = mushroomi;
        boolean onion = onioni;
        boolean olives = olivesi;
        boolean extraCheese = extraCheesei;
        String pickupTime = pickupTimei;
        boolean acceptedStatus = acceptedStatusi;
        String cookStatus = cookStatusi;
    }

    public String displayStatus() {
        return cookStatus;
    }

    public void setStatus(statusType type) {
        if(type == statusType.ORDER_ACCEPTED) {
            cookStatus = "ORDER ACCEPTED";
            acceptedStatus = true;
        }
        else if(type == statusType.COOKING) {
            cookStatus = "COOKING";
            acceptedStatus = true;
        }
        else if(type == statusType.READY) {
            cookStatus = "READY";
            acceptedStatus = true;
        }
        else {
            cookStatus = "N/A";
            acceptedStatus = false;
        }
    }

    public String getStatus() {
        if(cookStatus.equals("ORDER ACCEPTED")) {
            return "ORDER ACCEPTED";
        }
        else if(cookStatus.equals("COOKING")) {
            return "COOKING";
        }
        else if(cookStatus.equals("READY")) {
            return "READY";
        }
        else {
            return "N/A";
        }
    }

    public String getID(){
        return asuID;
    }

    public String getEmail() {
        return asuEmail;
    }

    public int getPizzaNumber() {
        return PizzaNumber;
    }

    public PizzaOrder(PizzaOrder object) {
        PizzaNumber = object.PizzaNumber;
        asuID = object.asuID;
        pizzaType = object.pizzaType;
        mushroom = object.mushroom;
        onion = object.onion;
        olives = object.olives;
        extraCheese = object.extraCheese;
        pickupTime = object.pickupTime;
        acceptedStatus = object.acceptedStatus;
        cookStatus = object.cookStatus;
    }

}
