package conversion;

/**
 * This class converts a given number in the Octal base to its equivalent Decimal base number.
 */
public final class OctalToDecimalBaseConversionImpl extends DecimalBaseConversionImpl {

    public OctalToDecimalBaseConversionImpl() { super(8); }

    /**
     *This method verify if a given digit is in 0-7.
     *
     * @param value the checked digit
     * @return true | false
     */
    protected boolean isNotInRangeDigits(int value){ return value < 0 || value > 7; }

}