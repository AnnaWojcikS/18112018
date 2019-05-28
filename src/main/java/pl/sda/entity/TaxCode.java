package pl.sda.entity;

public enum TaxCode {
    A(0.23),
    B(0.08),
    C(0.00),
    D(0.05);


    private final double taxAmount;

    TaxCode(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double calculateTax(double amount) {
      return amount * taxAmount;
    }

    public String getPercentText() {
        return Double.valueOf(taxAmount * 100).intValue() + "%";

    }




}
