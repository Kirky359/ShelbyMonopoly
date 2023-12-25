package Board;

public class PropertyColorsMemento {
    private final int numHouses;

    public PropertyColorsMemento(int numHouses) {
        this.numHouses = numHouses;
    }

    public int getNumHouses() {
        return numHouses;
    }
}