package conversion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class BaseConversionFactory {

    private final Map<Integer, BaseConversionStrategy> converters = new HashMap<>();

    public BaseConversionFactory() {
        converters.put(BaseConversionFormat.BINARY_TO_DECIMAL.getId(), new BinaryToDecimalBaseConversionImpl());
        converters.put(BaseConversionFormat.DECIMAL_TO_BINARY.getId(), new DecimalToBinaryBaseConversionImpl());
        converters.put(BaseConversionFormat.BINARY_TO_OCTAL.getId(), new BinaryToOctalBaseConversionImpl());
        converters.put(BaseConversionFormat.OCTAL_TO_BINARY.getId(), new OctalToBinaryBaseConversionImpl());
        converters.put(BaseConversionFormat.DECIMAL_TO_OCTAL.getId(), new DecimalToOctalBaseConversionImpl());
        converters.put(BaseConversionFormat.OCTAL_TO_DECIMAL.getId(), new OctalToDecimalBaseConversionImpl());
    }

    public Map<Integer, BaseConversionStrategy> getConverters() {
        return Collections.unmodifiableMap(converters);
    }

    public BaseConversionStrategy getConversionStrategyById(BaseConversionFormat value) {
        return getConverters().get(value.getId());
    }

    public static BaseConversionStrategy getConversionStrategyBy(BaseConversionFormat format){
        return new BaseConversionFactory().getConversionStrategyById(format);
    }

}