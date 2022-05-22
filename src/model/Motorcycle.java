package model;

public class Motorcycle extends Vehicle implements GasolineConsume {

    private MotorcycleType motorcycleType;
    private double gasolineCapacity;
    private double gasolineConsume;

    public Motorcycle(Double basePrice, double discount, String brand, String model, Double cylinderCapacity,
            Double mileage, int status, String plate, int motorcycleType, double gasolineCapacity) {
        super(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate);
        switch (motorcycleType) {
            case 1:
                this.setMotorcycleType(MotorcycleType.STANDARD);
                break;
            case 2:
                this.setMotorcycleType(MotorcycleType.SPORT);
                break;
            case 3:
                this.setMotorcycleType(MotorcycleType.SCOOTER);
                break;
            case 4:
                this.setMotorcycleType(MotorcycleType.CROSS);
                break;
        }
        this.setGasolineCapacity(gasolineCapacity);
        this.setGasolineConsume(0);
    }

    public MotorcycleType getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(MotorcycleType motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    public double getGasolineCapacity() {
        return gasolineCapacity;
    }

    public void setGasolineCapacity(double gasolineCapacity) {
        this.gasolineCapacity = gasolineCapacity;
    }

    public double getGasolineConsume() {
        return gasolineConsume;
    }

    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }

    @Override
    public double calculateGasolineConsume() {

        gasolineConsume = getGasolineCapacity() * (getCylinderCapacity()/cgc);

        return gasolineConsume;
        
    }

    @Override
    public double calculateSalePrice() {
        
        double salePrice = getBasePrice();

        salePrice = salePrice + (getBasePrice() * mAdditionalCost);

        for (int i = 0; i < getDocument().size(); i++) {

            if (getDocument().get(i).getDocumentYear() < 2022) {

                salePrice = salePrice + expireCost;

            }

        }

        if (getStatus().equals(VehicleStatus.USED)) {

            salePrice = salePrice - (salePrice * mUsedDiscount);

        }

        if (getDiscount() > 0) {

            salePrice = salePrice - (salePrice * getDiscount());

        }

        return salePrice;
        
    }

    @Override
    public String toString() {
        return "Motorcycle [gasolineCapacity=" + gasolineCapacity + ", gasolineConsume=" + gasolineConsume
                + ", motorcycleType=" + motorcycleType + "]";
    }
    
}
