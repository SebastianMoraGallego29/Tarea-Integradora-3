package ui;

import java.util.Scanner;

import model.VehicleDealerController;

public class VehicleDealerManager {

    public static Scanner sc;
    public static VehicleDealerController dealerController;

    public static void main(String[] args) {

        init();
        showMainMenu();

    }

    private static void init() {

        sc = new Scanner(System.in);
        dealerController = new VehicleDealerController();

    }

    private static void showMainMenu() {

        System.out.println("\nWelcome to Vehicle Dealer Cali");

        boolean stopFlag = false;

        while (!stopFlag) {

            System.out.println("\nType an option");
            System.out.println("1. Register a Vehicle for the sale");
            System.out.println("2. Register a Document to a Vehicle");
            System.out.println("3. Calculate selling price of a vehicle");
            System.out.println("4. Show Vehicle reports");
            System.out.println("0. Exit");

            int mainOption = sc.nextInt();

            switch (mainOption) {

                case 1:
                    registerVehicle();
                    break;
                case 2:
                    registerDocument();
                    break;
                case 3:
                    int vehicleN = 0;

                    if (dealerController.showVehicleList().equals("")) {

                        System.out.println("\nThere aren't any Vehicles registered.");

                    } else {

                        System.out.println(
                                "\nThese are the Vehicles currently registered:" + dealerController.showVehicleList());

                        System.out.println(
                                "\nEnter the number of the Vehicle to which you want to register a Document: ");
                        vehicleN = sc.nextInt();

                    }

                    System.out.println(dealerController.calculateSalePrices(vehicleN));
                    break;
                case 4:
                    System.out.println("Arrange by:\n1. Vehicle Type\n2. Gasoline Type\n3. Automobile Status");
                    int noption = sc.nextInt();
                    switch (noption) {
                        case 1:
                            System.out.println(dealerController.showbyVehicleType());
                            break;
                        case 2:
                            System.out.println(dealerController.showbyGasolineType());
                            break;
                        case 3:
                            System.out.println(dealerController.showbyAutomobileStatus());
                            break;
                        default:
                            System.out.println("\nYou must type a valid option");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("\nThanks for using our system\n");
                    stopFlag = true;
                    break;
                default:
                    System.out.println("\nYou must type a valid option");
                    break;

            }

        }

    }

    private static void registerVehicle() {

        System.out.println("\nType the Vehicle's base price:");
        double basePrice = sc.nextDouble();

        System.out.println("Do you want to apply an additional discount?\n1. Yes\n2. No");
        int decision = sc.nextInt();

        double discount = 0;

        if (decision == 1) {

            System.out.println("How much? (Ex: 60)");

            double d = sc.nextDouble();

            discount = d / 100;

        }

        System.out.println("Type the Vehicle's brand:");
        String brand = sc.next();

        System.out.println("Type the Vehicle's model:");
        String model = sc.next();

        System.out.println("Type the Vehicle's cylinder capacity:");
        double cylinderCapacity = sc.nextDouble();

        System.out.println("Type the Vehicle's mileage:");
        double mileage = sc.nextDouble();

        System.out.println("Type the option of the Vehicle's status:\n1. New\n2. Used");
        int status = sc.nextInt();

        String plate = null;

        if (status == 1) {

            System.out.println("Being a new Vehicle, no plate will be assigned");

        }

        if (status == 2) {

            System.out.println("Type the Vehicle's plate:");
            plate = sc.next();

        }

        System.out.println("Type the option of the Vehicle's type:\n1. Car\n2. Motorcycle");
        int vehicleType = sc.nextInt();

        if (vehicleType == 1) {

            System.out.println("Type the option of the Automobile's type:\n1. Sedan\n2. Van");
            int automobileType = sc.nextInt();

            System.out.println("Type the number of Automobile doors:");
            int doors = sc.nextInt();

            System.out.println("Type 1 if your windows are tinted or 0 if they are not.");
            int w = sc.nextInt();

            boolean windowsT = false;

            if (w == 1) {

                windowsT = true;

            }

            System.out.println("Type the option of the Car's type:\n1. Gasoline car\n2. Electric car\n3. Hybrid car");
            int carType = sc.nextInt();

            if (carType == 1) {

                System.out.println("Type the Car's tank capacity in gallons:");
                double tankCapacity = sc.nextDouble();

                System.out.println("Type the option of Gasoline's type:\n1. Extra\n2. Regular\n3. Diesel");
                int gasolineType = sc.nextInt();

                if (dealerController.registerGasolineCar(basePrice, discount, brand, model, cylinderCapacity, mileage,
                        status, plate, automobileType, doors, windowsT, tankCapacity, gasolineType)) {

                    System.out.println("\nGasoline Car registered successfully");

                } else {

                    System.out.println("\nError, Gasoline Car couldn't be registered");

                }

            }

            if (carType == 2) {

                System.out.println("Type the option of the Charger's type:\n1. Fast\n2. Normal");
                int chargerType = sc.nextInt();

                System.out.println("Type the battery's life per km:");
                double batteryLife = sc.nextDouble();

                if (dealerController.registerElectricCar(basePrice, discount, brand, model, cylinderCapacity, mileage,
                        status, plate, automobileType, doors, windowsT, chargerType, batteryLife)) {

                    System.out.println("\nElectric Car registered successfully");

                } else {

                    System.out.println("\nError, Electric Car couldn't be registered");

                }

            }

            if (carType == 3) {

                System.out.println("Type the Car's tank capacity in gallons:");
                double tankCapacity = sc.nextDouble();

                System.out.println("Type the option of Gasoline's type:\n1. Extra\n2. Regular\n3. Diesel");
                int gasolineType = sc.nextInt();

                System.out.println("Type the option of the Charger's type:\n1. Fast\n2. Normal");
                int chargerType = sc.nextInt();

                System.out.println("Type the battery's life per km:");
                double batteryLife = sc.nextDouble();

                if (dealerController.registerHybridCar(basePrice, discount, brand, model, cylinderCapacity, mileage,
                        status, plate, automobileType, doors, windowsT, tankCapacity, gasolineType, chargerType,
                        batteryLife)) {

                    System.out.println("\nHybrid Car registered successfully");

                } else {

                    System.out.println("\nError, Hybrid Car couldn't be registered");

                }

            }

        }

        if (vehicleType == 2) {

            System.out
                    .println("Type the option of the Motorcycle's type:\n1. Standard\n2. Sport\n3. Scooter\n4. Cross");
            int motorcycleType = sc.nextInt();

            System.out.println("Type the Motorcycle's gasoline capacity per gallon:");
            double gasolineCapacity = sc.nextDouble();

            if (dealerController.registerMotorCycle(basePrice, discount, brand, model, cylinderCapacity, mileage,
                    status, plate, motorcycleType, gasolineCapacity)) {

                System.out.println("\nMotorcycle registered successfully");

            } else {

                System.out.println("\nError, Motorcycle couldn't be registered");

            }

        }

    }

    private static void registerDocument() {

        if (dealerController.showVehicleList().equals("")) {

            System.out.println("\nThere aren't any Vehicles registered.");

        } else {

            System.out.println("\nThese are the Vehicles currently registered:" + dealerController.showVehicleList());

            System.out.println("\nEnter the number of the Vehicle to which you want to register a Document: ");
            int vehicleN = sc.nextInt();

            System.out.println(
                    "Type the option of the Document's type:\n1. SOAT\n2. Mechanical Technical Review\n3. Property Card");
            int documentType = sc.nextInt();

            double accidentR = 0;

            double gasesE = 0;

            switch (documentType) {

                case 1:
                    System.out.println("Type the Document's price:");
                    double documentPrice = sc.nextDouble();

                    System.out.println("Type the Document's year:");
                    int documentYear = sc.nextInt();

                    System.out.println("Type the third party accident coverage amount:");
                    accidentR = sc.nextDouble();

                    if (dealerController.registerDocument(vehicleN, documentType, documentPrice, documentYear,
                            accidentR, gasesE)) {

                        System.out.println("\nSOAT registered successfully");

                    } else {

                        System.out.println("\nError, SOAT couldn't be registered");

                    }
                    break;
                case 2:
                    System.out.println("Type the Document's price:");
                    documentPrice = sc.nextDouble();

                    System.out.println("Type the Document's year:");
                    documentYear = sc.nextInt();

                    System.out.println("Type the levels of gases emitted by the Vehicle:");
                    gasesE = sc.nextDouble();

                    if (dealerController.registerDocument(vehicleN, documentType, documentPrice, documentYear,
                            accidentR, gasesE)) {

                        System.out.println("\nMechanical Technical registered successfully");

                    } else {

                        System.out.println("\nError, Mechanical Technical couldn't be registered");

                    }
                    break;
                case 3:
                    System.out.println("Type the Document's price:");
                    documentPrice = sc.nextDouble();

                    System.out.println("Type the Document's year:");
                    documentYear = sc.nextInt();

                    if (dealerController.registerDocument(vehicleN, documentType, documentPrice, documentYear,
                            accidentR, gasesE)) {

                        System.out.println("\nProperty Card registered successfully");

                    } else {

                        System.out.println("\nError, Property Card couldn't be registered");

                    }
                    break;
                default:
                    System.out.println("\nYou must type a valid option");
                    break;

            }

        }

    }

}