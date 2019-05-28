package pl.sda.printer;

public abstract class Printer {

    private int printerLength;

    public Printer(int printerLength) {
        this.printerLength = printerLength;
    }

    protected abstract String prepareText(String string);

    //ctlr alt C - tworzy constant - stała

    public void printCenter(String string) {
        int stringLength = string.length();


        int spaceLeft = printerLength - stringLength;
        int spacesCount = spaceLeft / 2;
        printSpaces(spacesCount);
        System.out.println(prepareText(string));

    }

    private void printSpaces(int spacesCount) {
        for (int i = 0; i < spacesCount; i++) {
            System.out.print(" ");

        }
    }

    public void printRight(String string) {
        int stringLength = string.length();


        int spaceLeft = printerLength - stringLength;

        printSpaces(spaceLeft);
        System.out.println(prepareText(string));

    }

    public void printLeft(String string) {
        System.out.println(trim(string, printerLength));
    }

    public void printJustyfy(String string1, String string2) {
        int spaceLeft = printerLength - string1.length() - string2.length();
        System.out.print(prepareText(string1));
        printSpaces(spaceLeft);
        System.out.println(prepareText(string2));
    }


    public String trim(String string, int count) {
        if (string.length() > count) {
            String trimmedString = string.substring(0, count - 3) + "...";
            return trimmedString;
        } else {

            return string;
        }
    }

    public void separate() {
        for (int i = 0; i < printerLength; i++) {
            System.out.print("-");

        }
        System.out.println();

    }
}
