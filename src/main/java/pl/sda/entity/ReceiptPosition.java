package pl.sda.entity;

public class ReceiptPosition {

    private Product product;
    private double quantity;

    public ReceiptPosition(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double summarize() {
        return product.getPrice() * quantity;
    }
}
