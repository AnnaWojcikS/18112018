package pl.sda.printer;

import pl.sda.entity.Shop;

public class ReceiptPrinters {

    //metoda fabrykująca - factory method

    public static ReceiptPrinter create40lengthUpperCasePrinter(Shop shop) {
        Printer oldPrinter = new UpperCasePrinter(40);

        return new ReceiptPrinter(
                new HeaderPrinter(oldPrinter),
                new DoubleLineProductTablePrinter(oldPrinter),
                new TaxPrinter(oldPrinter),
                new FooterPrinter(oldPrinter),
                shop
        );
    }

    public static ReceiptPrinter create(Shop shop, int printerLength) {
        Printer oldPrinter = new UpperCasePrinter(printerLength);

        return new ReceiptPrinter(
                new HeaderPrinter(oldPrinter),
                new DoubleLineProductTablePrinter(oldPrinter),
                new TaxPrinter(oldPrinter),
                new FooterPrinter(oldPrinter),
                shop
        );
    }
}
