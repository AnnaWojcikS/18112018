package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static pl.sda.printer.DecimalFormats.PRICE;

public class FooterPrinter {

    private Printer printer;

    public FooterPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(ReceiptPosition[] positions) {
        double totalAmount = 0;

        for (ReceiptPosition position : positions) {

            totalAmount += position.summarize();
        }
        printer.printJustyfy("SUMA PLN", PRICE.format(totalAmount));
        printer.separate();

        String hour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        printer.printJustyfy("Godzina", hour);
        printer.printCenter("Numer Kontrolny");
        printer.printCenter("#" + UUID.randomUUID().toString() + "#");
        printer.printCenter("BBH 104267834");
        printer.printJustyfy("Gotówka", PRICE.format(totalAmount));

    }
    }

