package pl.sda.entity;

public enum Unit {

    PIECE("szt"),
    SERVICE("usł"),
    KILOGRAM("kg");



    private final String symbol;

    Unit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
