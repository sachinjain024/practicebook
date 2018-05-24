package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Doc: https://www.aerospike.com/docs/guide/limitations.html
 */
public class AerospikeEntityNameGenerator {
    private static final int MAX_PREFIX_LENGTH_FROM_ACTUAL_NAME = 2;
    private static final int MAX_SET_NAME_LENGTH_FROM_ACTUAL_NAME = 32;

    public static Map<String, String> generateBinNames(Map<String, String> existingMappedNames, List<String> actualNames) {
        Map<String, String> result = new HashMap<>();

        actualNames.forEach(name -> {
            String shortName = existingMappedNames.containsKey(name)
                ? existingMappedNames.get(name)
                : generateBinName(existingMappedNames, name);

            existingMappedNames.put(name, shortName);
            result.put(name, shortName);
        });

        return result;
    }

    static String generateBinName(Map<String, String> existingMappedNames, String name) {
        Map<String, String> existingMappedNamesInversed = new HashMap<>();
        existingMappedNames.forEach((actualName, shortName) -> existingMappedNamesInversed.put(shortName, actualName));

        String generatedShortName = generateShortName(name, MAX_PREFIX_LENGTH_FROM_ACTUAL_NAME);
        String shortNameSuffixCounter = "";

        while (existingMappedNamesInversed.containsKey(generatedShortName + shortNameSuffixCounter)) {
            shortNameSuffixCounter = shortNameSuffixCounter.equalsIgnoreCase("")
                ? "2"
                : String.valueOf((Integer.parseInt(shortNameSuffixCounter) + 1));
        }

        return generatedShortName + shortNameSuffixCounter;
    }

    /**
     * Generates a shortName for a given String. It does not guarantee uniqueness. It just creates a prefix of actual string
     * Examples:
     *      "first name" -> fi
     *      "firstName" -> fi
     *      "myFirst name" -> my
     * @param actualName Actual Name for which shortName is to be generated
     * @param maxLength MaxLength of the name to be generated
     * @return String ShortName
     */
    static String generateShortName(String actualName, int maxLength) {
        int shortNameLength = Math.min(maxLength, actualName.length());
        return actualName.substring(0, shortNameLength);
    }

    public static String generateSetName(String orgId, String tableName) {
        StringBuilder setNameBuilder = new StringBuilder();

        setNameBuilder.append(orgId.split("@")[0]); // 24 chars
        setNameBuilder.append("_"); // 1 Char
        setNameBuilder.append(tableName.substring(0, Math.min(tableName.length(), MAX_SET_NAME_LENGTH_FROM_ACTUAL_NAME))); // Max 32 chars

        return setNameBuilder.toString();
    }
}
