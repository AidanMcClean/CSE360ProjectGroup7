import ChefM.ChefDisplay;
import CustomerM.CustomerDisplay;
import java.util.*;

public class ObserverDriver {

    public static void main(String args[]) {
        ChefDisplay beingobserved = new ChefDisplay();
        CustomerDisplay observee = new CustomerDisplay();
        beingobserved.addObserver(observee);
        beingobserved.incre();
    }


}
