class Vehicle {
    String brand;
    int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Derived class
class Car extends Vehicle {
    String fuelType;

    Car(String brand, int year, String fuelType) {
        super(brand, year);  // call Vehicle constructor
        this.fuelType = fuelType;
    }

    // Overriding method
    @Override
    void start() {
        super.start(); // call parent version
        System.out.println("Car engine is now running on " + fuelType + ".");
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // include vehicle info
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass of Car
class ElectricCar extends Car {
    int batteryCapacity; // in kWh

    ElectricCar(String brand, int year, int batteryCapacity) {
        super(brand, year, "Electric"); // call Car constructor
        this.batteryCapacity = batteryCapacity;
    }

    // Overriding method
    @Override
    void start() {
        super.start(); // call parent (Car) start
        System.out.println("ElectricCar is running silently with battery power.");
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // reuse Car + Vehicle info
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Main class
 class VehicleDemo {
    public static void main(String[] args) {
        ElectricCar ecar = new ElectricCar("Tesla", 2024, 100);

        ecar.displayInfo();
        ecar.start();
    }
}
