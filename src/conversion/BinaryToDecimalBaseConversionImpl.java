package conversion;

/**
 * This class converts a given number in the Binary base to its equivalent Decimal base number.
 */
public final class BinaryToDecimalBaseConversionImpl extends DecimalBaseConversionImpl {

    public BinaryToDecimalBaseConversionImpl() { super(2); }

    /**
     *This method verify if a given digit is in 0-1.
     *
     * @param value the checked digit
     * @return true | false
     */
    protected boolean isNotInRangeDigits(int value){ return value < 0 || value > 1; }

}