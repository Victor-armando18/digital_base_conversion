package conversion;

public enum BaseConversionFormat {

    BINARY_TO_DECIMAL(1),
    DECIMAL_TO_BINARY(2),
    BINARY_TO_OCTAL(3),
    OCTAL_TO_BINARY(4),
    DECIMAL_TO_OCTAL(5),
    OCTAL_TO_DECIMAL(6);

    private final int id;

    BaseConversionFormat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}