package model;

public interface SalePrice {

    public final double expireCost = 500000;
    public final double electricCost = 0.20;
    public final double hybridCost = 0.15;
    public final double usedDiscount = 0.10;
    public final double mAdditionalCost = 0.04;
    public final double mUsedDiscount = 0.02;

    public double calculateSalePrice();
    
}
