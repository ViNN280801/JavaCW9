package Task4;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Cashbox> cashboxes = new ArrayList<Cashbox>();
		ArrayList<Visitor> visitors = new ArrayList<Visitor>();
		
		for (short i = 0; i < 3; i++) {
			cashboxes.add(new Cashbox(visitors, i));
        }

        for (short i = 0; i < 10; i++) {
            synchronized (visitors) {
            	visitors.add(new Visitor("Visitor" + i));
            	visitors.notifyAll();
            }
        }

        synchronized (visitors){
            while (!visitors.isEmpty()){
            	visitors.wait();
            }
        }

        System.out.println("All visitors have been serviced.");
	}	
}