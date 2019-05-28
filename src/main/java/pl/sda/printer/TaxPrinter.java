package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;
import pl.sda.entity.TaxCode;

import static pl.sda.printer.DecimalFormats.PRICE;

public class TaxPrinter {

    private Printer printer;

    public TaxPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(ReceiptPosition[] positions) {
        double taxSum = 0;
        taxSum += printTax(positions, TaxCode.A, printer);
        taxSum += printTax(positions, TaxCode.B, printer);
        taxSum += printTax(positions, TaxCode.C, printer);
        taxSum += printTax(positions, TaxCode.D, printer);
        printer.printJustyfy("Suma PTU", PRICE.format(taxSum));
        printer.separate();
    }

    private double printTax (ReceiptPosition[]positions, TaxCode taxCode,
                                    Printer printer){
        double sumValue = 0;

        for (ReceiptPosition position : positions) {
            if (position.getProduct().getTaxCode().equals(taxCode)) {
                sumValue += position.summarize();

            }
        }
        if (sumValue == 0) return 0;
        double tax = taxCode.calculateTax(sumValue);

        String firstPart = "Sp. op. " + taxCode + " " + PRICE.format(sumValue) + " PTU " +
                taxCode.getPercentText();
        String secondPart = PRICE.format(tax);
        printer.printJustyfy(firstPart, secondPart);

        return tax;

    }





}
