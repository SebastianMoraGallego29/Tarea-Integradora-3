package model;

public class GasolineCar extends Car implements GasolineConsume {

    private double tankCapacity;
    private GasolineType gasolineType;
    private double gasolineConsume;

    public GasolineCar(double basePrice, double discount, String brand, String model, double cylinderCapacity,
            double mileage, int status, String plate, int automobileType, int doors, boolean windowsT,
            double tankCapacity, int gasolineType) {
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
        this.setGasolineConsume(calculateGasolineConsume());
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

    @Override
    public double calculateGasolineConsume() {

        gasolineConsume = getTankCapacity() * (getCylinderCapacity()/cgc);

        return gasolineConsume;
        
    }

    @Override
    public double calculateSalePrice() {

        double salePrice = getBasePrice();

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
        return "GasolineCar [gasolineConsume=" + gasolineConsume + ", gasolineType=" + gasolineType + ", tankCapacity="
                + tankCapacity + "]";
    }

   

}
