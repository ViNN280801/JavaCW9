package Task1;
import java.util.Random;

public class Main {
	private static void emulateWork(Dock dock) {
        Thread[] threads = new Thread[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int maxWeightOfCargo = 10 + random.nextInt(50);
            int currentWeight = random.nextInt(maxWeightOfCargo);

            Vessel vessel = new Vessel(maxWeightOfCargo, currentWeight);
            threads[i] = new Thread(new ShipThread(dock, vessel));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            while (threads[i].isAlive()) {
                System.out.println("waiting");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting work: ");
        emulateWork(new LockDock(5, 1000));
    }
}