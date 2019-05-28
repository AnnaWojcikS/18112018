package pl.sda;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Main {

    public static final int PRINTER_LENGTH = 40;  //ctlr alt C - tworzy constant - stała

    public static void main(String[] args) {
        printCenter("SDA SHOP spółka Z.O.O");
        printCenter("UL. SZKOLENIOWA 5/22; 00-036 WARSZAWA");
        printCenter("SKLEP SDA JAVALUB");
        printCenter("UL. SKLEPOWA 6/17; 20-011 LUBLIN");
        printCenter("TEL: 560-234-234 JAVALUB@SDASHOP.COM");
        printCenter("NIP 523-645-31-53");
        printJustyfy(LocalDate.now().toString(), "1456");
        separate();
        printCenter("Paragon Fiskalny");
        printJustyfy("NAZWA     ILOŚĆ X CENA", "WARTOŚĆ    PTU");
        separate();
        String[] productName = {"Komputer Osobisty", "Montaż, transport i instalacja komputera osobistego",
                "Szkolenie w zakresie obsługi komputera", "Płyn chłodniczy do komputera"};
        double[] productPrice = {3999.99, 50, 1499.89, 14.99};
        String[] productUnit = {"szt", "usł", "usł", "kg"};
        double[] productQuantity = {3, 3, 1, 2.5};
        String[] productTax = {"A", "B", "B", "D"};
        DecimalFormat priceFormat = new DecimalFormat("#.00");
        DecimalFormat quantityFormat = new DecimalFormat("#.##");

        for (int i = 0; i < productName.length; i++) {
            printLeft(productName[i]);
            double quantity = productQuantity[i];
            String unit = productUnit[i];
            double price = productPrice[i];
            String tax = productTax[i];

            String firstPart = "   " + quantityFormat.format(quantity) + " " + unit + " x " + priceFormat.format(price);
            double value = quantity * price;
            String secondPart = priceFormat.format(value) + " " + tax;
            printJustyfy(firstPart, secondPart);

        }
        separate();
        double taxSum = 0;

        taxSum += printTax(productPrice, productQuantity, productTax, priceFormat, "A", 0.23);
        taxSum += printTax(productPrice, productQuantity, productTax, priceFormat, "B", 0.08);
        taxSum += printTax(productPrice, productQuantity, productTax, priceFormat, "C", 0.00);
        taxSum += printTax(productPrice, productQuantity, productTax, priceFormat, "D", 0.05);
        printJustyfy("Suma PTU", priceFormat.format(taxSum));
        separate();

        double totalAmount = 0;
        for (int i = 0; i < productPrice.length; i++) {
            totalAmount += productPrice[i] * productQuantity[i];
        }
        printJustyfy("SUMA PLN", priceFormat.format(totalAmount));
        separate();

        String hour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        printJustyfy("Godzina", hour);
        printCenter("Numer Kontrolny");
        printCenter("#" + UUID.randomUUID().toString() + "#");
        printCenter("BBH 104267834");
        printJustyfy("Gotówka", priceFormat.format(totalAmount));

    }

    private static double printTax(double[] productPrice, double[] productQuantity, String[] productTax,
                                   DecimalFormat priceFormat, String taxCode, double taxPercent) {
        double sumValue = 0;
        for (int i = 0; i < productTax.length; i++) {
            if (productTax[i].equals(taxCode)) {
                sumValue += productPrice[i] * productQuantity[i];

            }
        }
        if (sumValue == 0) return 0;
        double tax = sumValue * taxPercent;

        String firstPart = "Sp. op. " + taxCode + " " + priceFormat.format(sumValue) + " PTU " + (taxPercent * 100)
                + "%";
        String secondPart = priceFormat.format(tax);
        printJustyfy(firstPart, secondPart);

        return tax;

    }

    private static void printCenter(String string) {
        int stringLength = string.length();


        int spaceLeft = PRINTER_LENGTH - stringLength;
        int spacesCount = spaceLeft / 2;
        printSpaces(spacesCount);
        System.out.println(string.toUpperCase());

    }

    //metoda która dodalam za pomoca ctrl alt M - wyrzucila nowa metode na zewnatrz i zastosowała wewnatrz innych metod
    private static void printSpaces(int spacesCount) {
        for (int i = 0; i < spacesCount; i++) {
            System.out.print(" ");

        }
    }

    private static void printRight(String string) {
        int stringLength = string.length();


        int spaceLeft = PRINTER_LENGTH - stringLength;

        printSpaces(spaceLeft);
        System.out.println(string.toUpperCase());

    }

    private static void printLeft(String string) {
        System.out.println(trim(string));
    }

    private static String trim(String string) {
        if (string.length() > PRINTER_LENGTH) {
            String trimmedString = string.substring(0, PRINTER_LENGTH - 3) + "...";
            return trimmedString.toUpperCase();
        } else {

            return string.toUpperCase();
        }
    }


    private static void printJustyfy(String string1, String string2) {
        int spaceLeft = PRINTER_LENGTH - string1.length() - string2.length();
        System.out.print(string1.toUpperCase());
        printSpaces(spaceLeft);
        System.out.println(string2.toUpperCase());
    }

    private static void separate() {
        for (int i = 0; i < PRINTER_LENGTH; i++) {
            System.out.print("-");

        }
        System.out.println();

    }


}

