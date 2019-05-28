package pl.sda.entity;

public class Product {

    private String name;
    private double price;
    private TaxCode taxCode;
    private Unit unit;

    public Product(String name, double price, TaxCode taxCode, Unit unit) {
        this.name = name;
        this.price = price;
        this.taxCode = taxCode;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public TaxCode getTaxCode() {
        return taxCode;
    }

    public Unit getUnit() {
        return unit;
    }
}
