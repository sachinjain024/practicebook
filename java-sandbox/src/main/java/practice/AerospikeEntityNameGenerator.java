package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Doc: https://www.aerospike.com/docs/guide/limitations.html
 */
public class AerospikeEntityNameGenerator {
    private static final int MAX_BINS_ALLOWED =  32767;
    private static final int MAX_BIN_LENGTH_ALLOWED = 14;
    private static final int MAX_BIN_NAME_LENGTH_FROM_ACTUAL_NAME = MAX_BIN_LENGTH_ALLOWED - String.valueOf(MAX_BINS_ALLOWED).length();
    private static final int MAX_SET_NAME_LENGTH_FROM_ACTUAL_NAME = 8;

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

    public static String generateBinName(Map<String, String> existingMappedNames, String name) {
        Map<String, String> existingMappedNamesInversed = new HashMap<>();
        existingMappedNames.forEach((actualName, shortName) -> existingMappedNamesInversed.put(shortName, actualName));

        String generatedShortName = generateShortName(name, MAX_BIN_NAME_LENGTH_FROM_ACTUAL_NAME);
        String shortNameSuffixCounter = "";

        while (existingMappedNamesInversed.containsKey(generatedShortName + shortNameSuffixCounter)) {
            shortNameSuffixCounter = shortNameSuffixCounter.equalsIgnoreCase("")
                ? "2"
                : String.valueOf((Integer.parseInt(shortNameSuffixCounter) + 1));
        }

        return generatedShortName + shortNameSuffixCounter;
    }

    /**
     * Generates a shortName for a given String. It does not guarantee uniqueness
     * Regex: https://regex101.com/r/xxbpax/1
     * Examples:
     *      "first name" -> fn
     *      "firstName" -> fN
     *      "myFirst name" -> mFn
     * @param actualName Actual Name for which shortName is to be generated
     * @param maxLength MaxLength of the name to be generated
     * @return
     */
    public static String generateShortName(String actualName, int maxLength) {
        Pattern p = Pattern.compile("((\\b\\w)|([A-Z]+))");
        Matcher m = p.matcher(actualName);
        StringBuilder encodedStringBuilder = new StringBuilder();

        while(m.find()) {
            encodedStringBuilder.append(m.group());
        }

        return encodedStringBuilder.toString().substring(0, Math.min(encodedStringBuilder.length(), maxLength));
    }

    public static String generateSetName(String orgId, String tableName) {
        StringBuilder setNameBuilder = new StringBuilder();

        setNameBuilder.append(orgId.split("@")[0]); // 24 chars
        setNameBuilder.append(tableName.substring(0, Math.min(tableName.length(), MAX_SET_NAME_LENGTH_FROM_ACTUAL_NAME))); // 8 chars
        setNameBuilder.append(UUID.randomUUID().toString().replaceAll("-", "")); // 32 chars

        return setNameBuilder.toString();
    }
}
