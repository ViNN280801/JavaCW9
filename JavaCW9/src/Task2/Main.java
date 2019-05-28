package Task2;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		
        new Operator(semaphore, "Operator #1", false).start();
        new Operator(semaphore, "Operator #2", true).start();
        new Operator(semaphore, "Operator #3", false).start();
        new Operator(semaphore, "Operator #4", true).start();
        new Operator(semaphore, "Operator #5", false).start();
        new Operator(semaphore, "Operator #6", true).start();
        new Operator(semaphore, "Operator #7", false).start();
        new Operator(semaphore, "Operator #8", true).start();
        new Operator(semaphore, "Operator #9", false).start();
        new Operator(semaphore, "Operator #10", true).start();
        new Operator(semaphore, "Operator #11", true).start();
        new Operator(semaphore, "Operator #12", false).start();
        new Operator(semaphore, "Operator #13", true).start();
        new Operator(semaphore, "Operator #14", false).start();
        new Operator(semaphore, "Operator #15", true).start();
	}
}