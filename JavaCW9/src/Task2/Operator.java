package Task2;
import java.util.concurrent.Semaphore;

public class Operator extends Thread {
	public String operatorName;
	public Semaphore semaphore;
	public boolean isSpeak;
	
	public Operator(Semaphore semaphore, String operatorName, boolean isAdded) {
        this.semaphore = semaphore;
        this.operatorName = operatorName;
        this.isSpeak = isAdded;
    }

    @Override
    public void run() {
        System.out.println(this.operatorName + " waiting for connect...");
        try {
            System.out.println(this.operatorName + " starting speak...");
            semaphore.acquire();
            for (int i = 0 ; i < 10 ; i++) {
                if (isSpeak)
                    System.out.println("Call is started");
                else
                	System.out.println("Call has ended");
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            semaphore.release(); 
        }
    }
}