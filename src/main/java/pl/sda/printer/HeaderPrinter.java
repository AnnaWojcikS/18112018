package pl.sda.printer;

import pl.sda.entity.Shop;

import java.time.LocalDate;

public class HeaderPrinter {
    private Printer printer;

    public HeaderPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(Shop shop) {
        printer.printCenter(shop.getCompany().getCompanyName());
        printer.printCenter(shop.getCompany().getFullAdress());
        printer.printCenter(shop.getName());
        printer.printCenter(shop.getAddress());
        printer.printCenter(shop.getPhoneNumber() + " " + shop.getMail());
        printer.printCenter(shop.getNip());
        printer.printJustyfy(LocalDate.now().toString(), "1456");
        printer.separate();
    }
}
