package model;

public class ElectricCar extends Car implements BatteryConsume {

    private ChargerType chargerType;
    private double batteryLife;
    private double batteryConsume;

    public ElectricCar(double basePrice, double discount, String brand, String model, double cylinderCapacity,
            double mileage, int status, String plate, int automobileType, int doors, boolean windowsT, int chargerType,
            double batteryLife) {
        super(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate, automobileType, doors,
                windowsT);
        switch (chargerType) {
            case 1:
                this.setChargerType(ChargerType.FAST);
                break;
            case 2:
                this.setChargerType(ChargerType.NORMAL);
                break;
        }
        this.setBatteryLife(batteryLife);
        this.setBatteryConsume(0);
    }

    public ChargerType getChargerType() {
        return chargerType;
    }

    public void setChargerType(ChargerType chargerType) {
        this.chargerType = chargerType;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public double getBatteryConsume() {
        return batteryConsume;
    }

    public void setBatteryConsume(double batteryConsume) {
        this.batteryConsume = batteryConsume;
    }

    @Override
    public double calculateBatteryConsume() {

        if (getChargerType().equals(ChargerType.FAST)) {
            batteryConsume = (getBatteryConsume() + 13) * (getCylinderCapacity()/100);
        }

        if (getChargerType().equals(ChargerType.NORMAL)) {
            batteryConsume = (getBatteryConsume() + 18) * (getCylinderCapacity()/100);
        }
        
        return batteryConsume;
        
    }

    @Override
    public double calculateSalePrice() {

        double salePrice = getBasePrice();


        salePrice = salePrice + (getBasePrice() * electricCost);

        for (int i = 0; i < getDocument().size(); i++) {

            if (getDocument().get(i).getDocumentYear() < 2022) {

                salePrice = salePrice + expireCost;

            }

        }

        if (getStatus().equals(VehicleStatus.USED)) {

            salePrice = salePrice - (salePrice * usedDiscount);

        }

        if (getDiscount() > 0) {

            salePrice = salePrice - (salePrice * getDiscount());

        }

        return salePrice;

    }

    @Override
    public String toString() {
        return "ElectricCar [batteryConsume=" + batteryConsume + ", batteryLife=" + batteryLife + ", chargerType="
                + chargerType + "]";
    }

}
