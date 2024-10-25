package conversion;

/**
 * This class converts a given number using power base to its equivalent Decimal base number.
 */
abstract class DecimalBaseConversionImpl implements BaseConversionStrategy{
    
    private final int base;

    protected DecimalBaseConversionImpl (int base){
        this.base = base;
    }

    /**
     * This method converts a given number to its equivalent decimal.
     *
     * @param value the given number
     * @return equivalent decimal
     */
    @Override
    public int convert(int value) {
        final String[] digits = splitIntoDigits(value);
        validateEachDigitIn(digits);
        final int[] mappedDigits = new int[digits.length];
        int indexOfCurrentDigit = 0, powerOfCurrentDigit, equivalentDecimal;

        powerOfCurrentDigit = digits.length-1;
        while (powerOfCurrentDigit >=0) {
            equivalentDecimal = getEquivalentDecimalForDigitIn(digits, indexOfCurrentDigit, powerOfCurrentDigit);
            addIn(mappedDigits, indexOfCurrentDigit, equivalentDecimal);
            powerOfCurrentDigit--;
            indexOfCurrentDigit++;
        }

        equivalentDecimal = 0;
        for(int mappedDigit : mappedDigits) equivalentDecimal += mappedDigit;
        return equivalentDecimal;
    }

    /**
     * This method Divide and produces an array of String type containing each number of the given value.
     *
     * @param value the value
     * @return array of divided digits
     */
    private String[] splitIntoDigits(Integer value){
        return value.toString().split("");
    }

    /**
     * This method Validate each digit in array according to binary range digits base
     * @param array the array of the digits being validated
     */
    private void validateEachDigitIn(String[] array){
        int currentValue, indexOfCurrentIndex, lengthOfArray = array.length;
        for (indexOfCurrentIndex = 0; indexOfCurrentIndex < lengthOfArray; indexOfCurrentIndex++) {
            currentValue = convertToInt(array[indexOfCurrentIndex]);
            verifyDigit(currentValue);
        }
    }

    /**
     * this method Verify if a given digit belongs in binary range digits base and produces a throw if not belongs.
     *
     * @param value the verified digit
     */
    private void verifyDigit(int value) {
        if (isNotInRangeDigits(value)) {
            throw new IllegalArgumentException(
                String.format(
                    "This is an invalid value. Note: The digit %d not belongs in the range of the digits base!", value
                )
            );
        }
    }

    /**
     *This method verify if a given digit is in certain range.
     *
     * @param value the checked digit
     * @return true | false
     */
    protected abstract boolean isNotInRangeDigits(int value);

    /**
     * This method adds a given value to a specified index of a given array
     *
     * @param array the array that will storage the value
     * @param atIndex the index for the value where the value will be added
     * @param value the valued to be added
     */
    private void addIn(int[] array, int atIndex, int value) {
        array[atIndex] = value;
    }

    private int convertToInt(String value){
        return Integer.parseInt(value);
    }

    /**
     * This method get equivalent decimal for a digit in specified index of a given array, given its power.
     *
     * @param array the array that contains the digit
     * @param atIndex the index of the digit
     * @param withPower the power of the digit
     * @return equivalent decimal
     */
    private int getEquivalentDecimalForDigitIn(String[] array, int atIndex, int withPower){
        return (int) (Integer.parseInt(array[atIndex])*Math.pow(base,withPower));
    }

}