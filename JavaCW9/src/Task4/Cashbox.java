package Task4;
import java.util.ArrayList;

public class Cashbox extends Thread {	
	public int numberOfCashBox;
	public ArrayList<Visitor> visitors;
	
	public Cashbox(){}
	public Cashbox(ArrayList<Visitor> visitors, int numberOfCashbox) {
		this.visitors = visitors;
		this.numberOfCashBox = numberOfCashbox;
		this.setDaemon(true);
		start();
	}
	public boolean isEmpty() {
		if(visitors == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Visitor visitor = new Visitor();
				synchronized (visitors) {
					while(visitors.size() == 0) {
						visitors.wait();
					}
					visitors.add(visitor);
					visitors.notifyAll();
				}
				System.out.println("Cashbox #" + this.numberOfCashBox + " started to service " + visitor);
				Thread.sleep(500);
				System.out.println(visitor + " was serviced by " + " cashbox #" + this.numberOfCashBox);
			}
			catch(InterruptedException  err){
				err.printStackTrace();
			}
		}
	}
	
	@Override
    public String toString() {
        return getName();
    }
}	