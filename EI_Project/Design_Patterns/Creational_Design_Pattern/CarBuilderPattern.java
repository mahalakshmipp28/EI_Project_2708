/*1. Builder Pattern
Use Case: Car Manufacturing
In this system, we have a car manufacturer that produces different types of cars 
(e.g., sedan, SUV, and truck). 
We want to create a builder that constructs a car step-by-step, allowing us to customize the car's features.*/

import java.util.Scanner;

// Product (Car)
class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String transmission;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return year + " " + color + " " + make + " " + model + " with " + engine + " engine and " + transmission + " transmission";
    }
}

// Builder (Car Builder)
interface CarBuilder {
    void setMake(String make);
    void setModel(String model);
    void setYear(int year);
    void setColor(String color);
    void setEngine(String engine);
    void setTransmission(String transmission);
    Car build();
}

class SedanBuilder implements CarBuilder {
    private Car car;

    public SedanBuilder() {
        this.car = new Car();
    }

    @Override
    public void setMake(String make) {
        car.setMake(make);
    }

    @Override
    public void setModel(String model) {
        car.setModel(model);
    }

    @Override
    public void setYear(int year) {
        car.setYear(year);
    }

    @Override
    public void setColor(String color) {
        car.setColor(color);
    }

    @Override
    public void setEngine(String engine) {
        car.setEngine(engine);
    }

    @Override
    public void setTransmission(String transmission) {
        car.setTransmission(transmission);
    }

    @Override
    public Car build() {
        return car;
    }
}

class SUVBuilder implements CarBuilder {
    private Car car;

    public SUVBuilder() {
        this.car = new Car();
    }

    @Override
    public void setMake(String make) {
        car.setMake(make);
    }

    @Override
    public void setModel(String model) {
        car.setModel(model);
    }

    @Override
    public void setYear(int year) {
        car.setYear(year);
    }

    @Override
    public void setColor(String color) {
        car.setColor(color);
    }

    @Override
    public void setEngine(String engine) {
        car.setEngine(engine);
    }

    @Override
    public void setTransmission(String transmission) {
        car.setTransmission(transmission);
    }

    @Override
    public Car build() {
        return car;
    }
}

// Director (Car Manufacturer)
class CarManufacturer {
    private CarBuilder builder;

    public CarManufacturer(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructCar(String make, String model, int year, String color, String engine, String transmission) {
        builder.setMake(make);
        builder.setModel(model);
        builder.setYear(year);
        builder.setColor(color);
        builder.setEngine(engine);
        builder.setTransmission(transmission);
        return builder.build();
    }
}

public class CarBuilderPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a car type:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        CarBuilder builder = null;

        switch (choice) {
            case 1:
                builder = new SedanBuilder();
                break;
            case 2:
                builder = new SUVBuilder();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        CarManufacturer manufacturer = new CarManufacturer(builder);

        System.out.println("Enter the make:");
        String make = scanner.nextLine();

        System.out.println("Enter the model:");
        String model = scanner.nextLine();

        System.out.println("Enter the year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter the color:");
        String color = scanner.nextLine();

        System.out.println("Enter the engine:");
        String engine = scanner.nextLine();

        System.out.println("Enter the transmission:");
        String transmission = scanner.nextLine();

        Car car = manufacturer.constructCar(make, model, year, color, engine, transmission);
        System.out.println(car);
    }
}
