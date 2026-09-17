import java.util.Scanner;

class Vehicle {
    String vehicleNumber, brand;
    int speed;

    Vehicle(String n, String b, int s) {
        vehicleNumber = n;
        brand = b;
        speed = s;
    }

    void displayDetails() {
        System.out.println(vehicleNumber + " " + brand + " " + speed);
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String n, String b, int s, int d) {
        super(n, b, s);
        numberOfDoors = d;
    }

    @Override
    void displayDetails() {
        System.out.println("\nCar Details");
        System.out.println("Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(String n, String b, int s, boolean g) {
        super(n, b, s);
        hasGear = g;
    }

    @Override
    void displayDetails() {
        System.out.println("\nBike Details");
        System.out.println("Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Has Gear: " + hasGear);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter vehicle number: ");
        String number = sc.next();

        System.out.print("Enter brand: ");
        String brand = sc.next();

        System.out.print("Enter speed: ");
        int speed = sc.nextInt();

        Vehicle v;

        if (choice == 1) {
            System.out.print("Enter number of doors: ");
            int doors = sc.nextInt();
            v = new Car(number, brand, speed, doors);
        } else {
            System.out.print("Does it have gear? (true/false): ");
            boolean gear = sc.nextBoolean();
            v = new Bike(number, brand, speed, gear);
        }

        v.displayDetails();
    }
}
