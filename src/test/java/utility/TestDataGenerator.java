package utility;

/**
 * @Author: Sahil Mutreja
 * Desc: TestDataGenerator class provides functionality to produce random alphanumberic strings
 */
public class TestDataGenerator {
    public enum ValueType{ALPHABET,NUMBER,ALPHANUMERIC}
    public static String randomAlphaNumeric(int count, ValueType valueType) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String NUMBER_STRING = "123456789";
        String ALPHABET_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = 0;
            if (valueType.equals(valueType.ALPHABET)) {
                character = (int) (Math.random() * ALPHABET_STRING.length());
                builder.append(ALPHABET_STRING.charAt(character));
            } else if (valueType.equals(valueType.NUMBER)) {
                character = (int) (Math.random() * NUMBER_STRING.length());
                builder.append(NUMBER_STRING.charAt(character));
            } else if (valueType.equals(valueType.ALPHANUMERIC)) {
                character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
                builder.append(ALPHA_NUMERIC_STRING.charAt(character));
            }
        }
        return builder.toString();
    }

}
