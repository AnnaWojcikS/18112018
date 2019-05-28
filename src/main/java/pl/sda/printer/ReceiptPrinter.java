package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;
import pl.sda.entity.Shop;

public class ReceiptPrinter {

    private HeaderPrinter headerPrinter;
    private ProductTablePrinter productTablePrinter;
    private TaxPrinter taxPrinter;
    private FooterPrinter footerPrinter;
    private Shop shop;

    public ReceiptPrinter(HeaderPrinter headerPrinter, ProductTablePrinter productTablePrinter, TaxPrinter taxPrinter, FooterPrinter footerPrinter, Shop shop) {
        this.headerPrinter = headerPrinter;
        this.productTablePrinter = productTablePrinter;
        this.taxPrinter = taxPrinter;
        this.footerPrinter = footerPrinter;
        this.shop = shop;
    }

    public void print(ReceiptPosition[] positions) {
        headerPrinter.print(shop);
        productTablePrinter.print(positions);
        taxPrinter.print(positions);
        footerPrinter.print(positions);

    }
}
