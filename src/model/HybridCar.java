package model;

public class HybridCar extends Car implements GasolineConsume, BatteryConsume {

    private double tankCapacity;
    private GasolineType gasolineType;
    private double gasolineConsume;
    private ChargerType chargerType;
    private double batteryLife;
    private double batteryConsume;

    public HybridCar(double basePrice, double discount, String brand, String model, double cylinderCapacity,
            double mileage, int status, String plate, int automobileType, int doors, boolean windowsT,
            double tankCapacity, int gasolineType, int chargerType,
            double batteryLife) {
        super(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate, automobileType, doors,
                windowsT);
        this.setTankCapacity(tankCapacity);
        switch (gasolineType) {
            case 1:
                this.setGasolineType(GasolineType.EXTRA);
                break;
            case 2:
                this.setGasolineType(GasolineType.REGULAR);
                break;
            case 3:
                this.setGasolineType(GasolineType.DIESEL);
                break;
        }
        this.setGasolineConsume(0);
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

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public GasolineType getGasolineType() {
        return gasolineType;
    }

    public void setGasolineType(GasolineType gasolineType) {
        this.gasolineType = gasolineType;
    }

    public double getGasolineConsume() {
        return gasolineConsume;
    }

    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
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
    public double calculateGasolineConsume() {

        gasolineConsume = getTankCapacity() * (getCylinderCapacity()/hgc);

        return gasolineConsume;
        
    }

    @Override
    public double calculateBatteryConsume() {

        if (getChargerType().equals(ChargerType.FAST)) {
            batteryConsume = getBatteryConsume() * (getCylinderCapacity() / 200);
        }

        if (getChargerType().equals(ChargerType.NORMAL)) {
            batteryConsume = (getBatteryConsume() + 7) * (getCylinderCapacity() / 200);
        }
        
        return batteryConsume;

    }

    @Override
    public double calculateSalePrice() {

        double salePrice = getBasePrice();

        salePrice = salePrice + (getBasePrice() * hybridCost);

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
        return "HybridCar [batteryConsume=" + batteryConsume + ", batteryLife=" + batteryLife + ", chargerType="
                + chargerType + ", gasolineConsume=" + gasolineConsume + ", gasolineType=" + gasolineType
                + ", tankCapacity=" + tankCapacity + "]";
    }
    
}
