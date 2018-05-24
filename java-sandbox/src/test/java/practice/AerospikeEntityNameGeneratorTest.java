package practice;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AerospikeEntityNameGeneratorTest {
    @Test
    public void generateBinNames() throws Exception {
        Map<String, String> existingMappedNames = new HashMap<>();
        List<String> newNames = new ArrayList<>(Arrays.asList("FirstName", "FastNumber", "Longlongverylongcolumnname", "Add", "Address"));

        Map<String, String> result = AerospikeEntityNameGenerator.generateBinNames(existingMappedNames, newNames);

        assertEquals(5, result.size());
        assertEquals("Fi", result.get("FirstName"));
        assertEquals("Fa", result.get("FastNumber"));
        assertEquals("Ad", result.get("Add"));
        assertEquals("Ad2", result.get("Address"));

        newNames.add("Email_Primary");
        newNames.add("Email_Private");
        newNames.add("Email_Personal");
        newNames.add("Email_Secondary");
        result = AerospikeEntityNameGenerator.generateBinNames(result, newNames);

        assertEquals("Em", result.get("Email_Primary"));
        assertEquals("Em2", result.get("Email_Private"));
        assertEquals("Em3", result.get("Email_Personal"));
        assertEquals("Em4", result.get("Email_Secondary"));
    }

    @Test
    public void generateShortName() throws Exception {
        assertEquals("fi", AerospikeEntityNameGenerator.generateShortName("firstName", 2));
        assertEquals("FI", AerospikeEntityNameGenerator.generateShortName("FIRSTNAME", 2));
        assertEquals("I", AerospikeEntityNameGenerator.generateShortName("I", 2));
        assertEquals("av", AerospikeEntityNameGenerator.generateShortName("averylongnameforthebin", 2));
        assertEquals("We", AerospikeEntityNameGenerator.generateShortName("WelcomeTo20thCentury", 2));
    }
}