package model;

import java.util.ArrayList;

public abstract class Vehicle implements SalePrice{

    private double basePrice;
    private double salePrice;
    private double discount;
    private String brand;
    private String model;
    private Double cylinderCapacity;
    private Double mileage;
    private VehicleStatus status;
    private String plate;
    private ArrayList<Document> document;

    public Vehicle(Double basePrice, double discount, String brand, String model, Double cylinderCapacity,
            Double mileage, int status, String plate) {
        this.setBasePrice(basePrice);
        this.setSalePrice(salePrice);
        this.setDiscount(discount);
        this.setBrand(brand);
        this.setModel(model);
        this.setCylinderCapacity(cylinderCapacity);
        this.setMileage(mileage);
        switch (status) {
            case 1:
                this.setStatus(VehicleStatus.NEW);
                break;
            case 2:
                this.setStatus(VehicleStatus.USED);
                break;
        }
        this.setPlate(plate);
        setDocument(new ArrayList<>());

    }

    public boolean registerDocument(int vehicleN, int documentType, double documentPrice, int documentYear,
            double accidentR, double gasesE) {

        switch (documentType) {

            case 1:
                return document.add(new SOAT(documentPrice, documentYear, accidentR));
            case 2:
                return document.add(new MechanicalTechnical(documentPrice, documentYear, gasesE));
            case 3:
                return document.add(new PropertyCard(documentPrice, documentYear));
               
        }

        return false;

    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Double cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public ArrayList<Document> getDocument() {
        return document;
    }

    public void setDocument(ArrayList<Document> document) {
        this.document = document;
    }

    @Override
    public double calculateSalePrice() {
        
        return 0;
    }

    @Override
    public String toString() {
        return "\nBase Price:" + basePrice + ", brand=" + brand + ", cylinderCapacity=" + cylinderCapacity
                + ", discount=" + discount + ", document=" + document + ", mileage=" + mileage + ", model=" + model
                + ", plate=" + plate + ", status=" + status + "]";
    }

}
