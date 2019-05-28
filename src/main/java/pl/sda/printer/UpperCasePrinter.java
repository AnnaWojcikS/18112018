package pl.sda.printer;

public class UpperCasePrinter extends Printer {


    public UpperCasePrinter(int printerLength) {
        super(printerLength);
    }

    @Override
    protected String prepareText(String string) {
        return string.toUpperCase();
    }
}
