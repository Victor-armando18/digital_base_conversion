import conversion.*;

public final class BaseConversionTest {

    public static void main(String ... args) {
        final int value = 345;
        //Conversion using Strategy
        BaseConversionStrategy baseConversion = new OctalToBinaryBaseConversionImpl();
        int equivalentBinary = baseConversion.convert(value);
        baseConversion = new OctalToDecimalBaseConversionImpl();
        int equivalentDecimal = baseConversion.convert(value);
        System.out.printf("The equivalent Binary of Octal %d is: %d\n", value, equivalentBinary);
        System.out.printf("The equivalent Decimal of Octal %d is: %d\n", value, equivalentDecimal);
        baseConversion = new BinaryToOctalBaseConversionImpl();
        int equivalentOctal = baseConversion.convert(equivalentBinary);
        System.out.printf("The equivalent Octal of Binary %d is: %d\n", equivalentBinary, equivalentOctal);
        baseConversion = new DecimalToBinaryBaseConversionImpl();
        equivalentBinary = baseConversion.convert(equivalentDecimal);
        baseConversion = new BinaryToDecimalBaseConversionImpl();
        equivalentDecimal = baseConversion.convert(equivalentBinary);
        System.out.printf("The equivalent Binary of Decimal %d is: %d\n", equivalentDecimal, equivalentBinary);
        System.out.printf("The equivalent Decimal of Binary %d is: %d\n", equivalentBinary, equivalentDecimal);

        //Conversion using Factory
        System.out.println("---------------------------------------------------------------");
        equivalentBinary = BaseConversion.convert(value, BaseConversionFormat.DECIMAL_TO_BINARY);
        equivalentDecimal = BaseConversion.convert(equivalentBinary, BaseConversionFormat.BINARY_TO_DECIMAL);
        System.out.printf("The equivalent Binary of Decimal %d is: %d\n", value, equivalentBinary);
        System.out.printf("The equivalent Decimal of Binary %d is: %d\n", equivalentBinary, equivalentDecimal);
        equivalentBinary = BaseConversion.convert(value, BaseConversionFormat.OCTAL_TO_BINARY);
        equivalentOctal = BaseConversion.convert(equivalentBinary, BaseConversionFormat.BINARY_TO_OCTAL);
        System.out.printf("The equivalent Binary of Octal %d is: %d\n", equivalentOctal, equivalentBinary);
        System.out.printf("The equivalent Octal of Binary %d is: %d\n", equivalentBinary, equivalentOctal);
        equivalentOctal = BaseConversion.convert(equivalentOctal, BaseConversionFormat.DECIMAL_TO_OCTAL);
        equivalentDecimal = BaseConversion.convert(equivalentOctal, BaseConversionFormat.OCTAL_TO_DECIMAL);
        System.out.printf("The equivalent Octal of Decimal %d is: %d\n", equivalentDecimal, equivalentOctal);
        System.out.printf("The equivalent Decimal of Octal %d is: %d\n", equivalentOctal, equivalentDecimal);
    }

}