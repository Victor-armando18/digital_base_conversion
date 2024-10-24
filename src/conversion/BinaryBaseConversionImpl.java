package conversion;

public abstract class BinaryBaseConversionImpl implements BaseConversionStrategy{

    private final int base;

    protected BinaryBaseConversionImpl(int base){
        this.base = base;
    }

    @Override
    public int convert(int value) {
        int equivalentDecimalRemainderByTwo;
        final StringBuilder equivalentBinaryDigit = new StringBuilder();
        do{
            equivalentDecimalRemainderByTwo = (value%base);
            equivalentBinaryDigit.append(equivalentDecimalRemainderByTwo);
            value = value/base;
        } while (value > 0);

        return toInt(equivalentBinaryDigit);
    }

    private int toInt(StringBuilder value) {
        return Integer.parseInt(value.reverse().toString());
    }

}