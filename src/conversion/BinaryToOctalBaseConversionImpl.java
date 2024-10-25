package conversion;

public final class BinaryToOctalBaseConversionImpl extends BinaryBaseConversionImpl {

    private final BaseConversionStrategy binaryToDecimalBaseConversion = new BinaryToDecimalBaseConversionImpl();

    public BinaryToOctalBaseConversionImpl() { super(8); }

    @Override
    public int convert(int value) { return super.convert(binaryToDecimalBaseConversion.convert(value)); }

}
