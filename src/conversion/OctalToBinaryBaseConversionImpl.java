package conversion;

/**
 * This class converts a given number in the Octal base to its equivalent Binary base number.
 */
public final class OctalToBinaryBaseConversionImpl extends BinaryBaseConversionImpl {

    private final BaseConversionStrategy octalToDecimalBaseConversion = new OctalToDecimalBaseConversionImpl();

    public OctalToBinaryBaseConversionImpl() { super(2); }

    /**
     * This method converts a given octal number to its equivalent binary
     *
     * @param value the given octal number
     * @return equivalent binary
     */
    @Override
    public int convert(int value) { return super.convert(octalToDecimalBaseConversion.convert(value)); }

}