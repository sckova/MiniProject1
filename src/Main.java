import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Location[] Locations = new Location[7];
        Locations[0] = new Location("Cleveland", new int[]{0, 0}, true);
        Locations[1] = new Location("North Pole", new int[]{500, -100}, true);
        Locations[2] = new Location("Campbell Hill", new int[]{-50,-50}, false);
        Locations[3] = new Location("Tokyo", new int[]{-100, 1000}, true);
        Locations[4] = new Location("Chicago", new int[]{-200, 75}, true);
        Locations[5] = new Location("Erie", new int[]{150, 0}, true);
        Locations[6] = new Location("Allegheny National Forest", new int[]{300, -75}, false);

        Scanner inp = new Scanner(System.in);
        int maximumFuelCapacity;
        int currentFuelCapacity;
        int milesPerGallon;
        System.out.println("Let's create a vehicle!");
        System.out.print("Enter the maximum fuel capacity: ");
        maximumFuelCapacity = inp.nextInt();
        currentFuelCapacity = maximumFuelCapacity;
        System.out.print("Enter the miles per gallon: ");
        milesPerGallon = inp.nextInt();
        Vehicle myVehicle = new Vehicle(Locations[0], maximumFuelCapacity, currentFuelCapacity, milesPerGallon);
        System.out.println("Let's drive!");
        // fix scanner running an extra time
        inp.nextLine();
        while(currentFuelCapacity > 0) {
            System.out.println("Current fuel capacity: " + myVehicle.currentFuelCapacity);
            if(maximumFuelCapacity != myVehicle.currentFuelCapacity) {
                System.out.print("Would you like to refuel? (y/n) ");
                String answer = inp.nextLine();
                if (answer.equals("y")) {
                    myVehicle.refuel();
                }
            }
            System.out.print("Enter the destination: ");
            String destination = inp.nextLine();
            myVehicle.drive(Locations, destination);
        }
    }
}