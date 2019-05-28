package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;

import static pl.sda.printer.DecimalFormats.PRICE;
import static pl.sda.printer.DecimalFormats.QUANTITY;

public class SingleLineProductTablePrinter implements ProductTablePrinter {

    private Printer printer;

    public SingleLineProductTablePrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(ReceiptPosition[] positions) {

        printer.printCenter("Paragon Fiskalny");
        printer.printJustyfy("Nazwa", "Ilość x Cena = Wartość PTU");
        printer.separate();
        for (ReceiptPosition position : positions) {
            String name = printer.trim(position.getProduct().getName(), 35);
            double quantity = position.getQuantity();
            double price = position.getProduct().getPrice();
            double sum = position.summarize();
            String taxCode = position.getProduct().getTaxCode().name();
            String secondPart = QUANTITY.format(quantity) + " x " + PRICE.format(price) + " = " + PRICE.format(sum)
                    + "  " + taxCode;
            printer.printJustyfy(name, secondPart);

        }

        printer.separate();

    }
}
