package model;

public abstract class Car extends Vehicle {

    private AutomobileType automobileType;
    private int doors;
    private boolean windowsT;

    public Car(Double basePrice, double discount, String brand, String model, Double cylinderCapacity, Double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT) {
        super(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate);
        switch (automobileType) {
            case 1:
                this.setAutomobileType(AutomobileType.SEDAN);
                break;
            case 2:
                this.setAutomobileType(AutomobileType.VAN);
                break;
        }
        this.setDoors(doors);
        this.setWindowsT(windowsT);
    }

    public AutomobileType getAutomobileType() {
        return automobileType;
    }

    public void setAutomobileType(AutomobileType automobileType) {
        this.automobileType = automobileType;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public boolean isWindowsT() {
        return windowsT;
    }

    public void setWindowsT(boolean windowsT) {
        this.windowsT = windowsT;
    }

    @Override
    public String toString() {
        return "Car [automobileType=" + automobileType + ", doors=" + doors + ", windowsT=" + windowsT + "]";
    }
       
}
