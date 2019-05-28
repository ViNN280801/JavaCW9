package Task1;

public class ShipThread implements Runnable {
    private Vessel vessel;
    private Dock dock;

    public ShipThread(Dock dock, Vessel vessel) {
        this.vessel = vessel;
        this.dock = dock;
    }

    @Override
    public void run() {
        if (!dock.dock()) {
            System.out.println("Cannot load dock " + vessel);
            return;
        }

        if (vessel.hasCargo()) {
            System.out.println("Place vessel " + vessel.getCurrentWeight() + " to dock");
            if (dock.place(vessel.getCurrentWeight())) {
            	vessel.setCurrentWeight(0);
            }
        }

        if (vessel.hasSpace()) {
            System.out.println("Loading vessel " + vessel.getAvailableSpace() + " to ship");
            vessel.addCargo(dock.load(vessel.getAvailableSpace()));
        }

        dock.sail();
    }
}