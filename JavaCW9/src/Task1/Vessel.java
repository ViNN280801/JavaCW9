package Task1;

public class Vessel {

    private int maxWeight;
    private int currentWeight;

    public Vessel(int maxWeight, int currentWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public boolean hasCargo() {
        return currentWeight > 0;
    }

    public boolean hasSpace() {
        return currentWeight < maxWeight;
    }

    public int getAvailableSpace() {
        return maxWeight - currentWeight;
    }

    public void addCargo(int weight) {
        currentWeight += weight;
    }
}