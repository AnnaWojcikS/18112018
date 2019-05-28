package pl.sda.printer;

public class NormalPrinter extends Printer {

    public NormalPrinter(int printerLength) {
        super(printerLength);
    }

    @Override
    protected String prepareText(String string) {
        return string;
    }


}
