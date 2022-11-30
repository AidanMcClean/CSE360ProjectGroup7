import ChefM.ChefDisplay;
import CustomerM.CustomerDisplay;

public class observerdriver {
    public static void main(String args[])
    {
        observerdriver test = new observerdriver();
        test.waitMethod();
    }

    private synchronized void waitMethod() {
        while(true) {
            ChefDisplay beingObserved = new ChefDisplay();
            CustomerDisplay observer1 = new CustomerDisplay();
            beingObserved.addObserver(observer1);
            beingObserved.incre();
            try {
                this.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
