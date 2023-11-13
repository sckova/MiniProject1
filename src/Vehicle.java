public class Vehicle {
    public Location location;
    public int maximumFuelCapacity;
    public int currentFuelCapacity;
    public int milesPerGallon;

    public Vehicle(Location location, int maximumFuelCapacity, int currentFuelCapacity, int milesPerGallon) {
        this.location = location;
        this.maximumFuelCapacity = maximumFuelCapacity;
        this.currentFuelCapacity = currentFuelCapacity;
        this.milesPerGallon = milesPerGallon;
    }

    public void drive(Location[] Locations, String destination) {
        // let's do some checking
        if (destination.matches(this.location.name)) {
            System.out.println("You can't drive to your own location!");
            return;
        }
        if (currentFuelCapacity < milesPerGallon) {
            System.out.println("Not enough fuel!");
            return;
        }
        // check if valid destination
        boolean validDestination = false;
        for (Location l : Locations) {
//            System.out.println("checked " + l.name);
            if (l.name.equals(destination)) {
                validDestination = true;
                break;
            }
        }
        if (!validDestination) {
            System.out.println("Invalid destination!");
            return;
        }
        // resolve the destination string back into a Location object
        Location destinationLocation = null;
        for (Location l : Locations) {
            if (l.name.equals(destination)) {
                destinationLocation = l;
                break;
            }
        }
        // calculate travel cost
        int travelCostX = Math.abs(this.location.coordinates[0] + destinationLocation.coordinates[0]);
        int travelCostY = Math.abs(this.location.coordinates[1] + destinationLocation.coordinates[1]);
        int travelCost = (travelCostX + travelCostY) / this.milesPerGallon;
        if (travelCost > this.currentFuelCapacity) {
            System.out.println("Not enough fuel!");
            return;
        }
        // decrease fuel and drive to the destination
        this.currentFuelCapacity -= travelCost;
        this.location = destinationLocation;
        System.out.println("Driving to " + destination + "...");
    }

    public void refuel() {
        if (this.location.hasGasStation) {
            this.currentFuelCapacity = this.maximumFuelCapacity;
        } else {
            System.out.println("This location doesn't have a gas station!");
        }
    }
}
