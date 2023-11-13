public class Location {
    public String name;
    public int[] coordinates = new int[2];
    public boolean hasGasStation;

    public Location(String name, int[] coordinates, boolean hasGasStation) {
        this.name = name;
        this.coordinates = coordinates;
        this.hasGasStation = hasGasStation;
    }
}
