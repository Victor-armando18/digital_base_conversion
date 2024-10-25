package conversion;

/**
 * This class does the conversion a given number to a specified format of bases conversion
 */
public final class BaseConversion {

    /**
     * This method does a conversion of a given number using a specified format of bases conversion
     * @param value the number to be converted
     * @param format the format used to format de number
     * @return equivalent number of the target base
     */
    public static int convert(int value, BaseConversionFormat format){
        return BaseConversionFactory.getConversionStrategyBy(format).convert(value);
    }

}