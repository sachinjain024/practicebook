package practice;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AerospikeEntityNameGeneratorTest {
    @Test
    public void generateBinNames() throws Exception {
        Map<String, String> existingMappedNames = new HashMap<>();
        List<String> newNames = new ArrayList<>(Arrays.asList("First Name", "Fast Number", "Long long very long column name", "Age", "Address"));

        Map<String, String> result = AerospikeEntityNameGenerator.generateBinNames(existingMappedNames, newNames);

        assertEquals(5, result.size());
        assertEquals("FN", result.get("First Name"));
        assertEquals("FN2", result.get("Fast Number"));
        assertEquals("A", result.get("Age"));
        assertEquals("A2", result.get("Address"));

        newNames.add("Email - Primary");
        newNames.add("Email - Private");
        newNames.add("Email - Personal");
        newNames.add("Email - Secondary");
        result = AerospikeEntityNameGenerator.generateBinNames(result, newNames);

        assertEquals("EP", result.get("Email - Primary"));
        assertEquals("EP2", result.get("Email - Private"));
        assertEquals("EP3", result.get("Email - Personal"));
        assertEquals("ES", result.get("Email - Secondary"));
    }

    @Test
    public void generateShortName() throws Exception {
        assertEquals("fn", AerospikeEntityNameGenerator.generateShortName("first name", 10));
        assertEquals("fN", AerospikeEntityNameGenerator.generateShortName("firstName", 10));
        assertEquals("FIRS", AerospikeEntityNameGenerator.generateShortName("FIRSTNAME", 4));
        assertEquals("fN", AerospikeEntityNameGenerator.generateShortName("first Name", 10));
        assertEquals("f", AerospikeEntityNameGenerator.generateShortName("firstname", 10));
        assertEquals("avln", AerospikeEntityNameGenerator.generateShortName("a very long name for the bin", 4));
        assertEquals("Wt2c", AerospikeEntityNameGenerator.generateShortName("Welcome to 20th century", 4));
    }
}