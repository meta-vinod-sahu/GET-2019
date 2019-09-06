import static org.junit.Assert.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

/**
 * Test class for DictionaryImpl
 *
 */
public class DictionaryTest {

	/**
	 * method for success case of adding key and value
	 * @throws Exception
	 */
	@Test
	public void addSuccessTest() throws Exception {

		String value = new String();
		FileReader file = new FileReader(
				"./DS/ASSIGNMENT5/DSASSIGNMENT_FIRST/src/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImpl(json);

		value = dictionary.getValue("20");
		assertEquals(value, "twenty");
		value = dictionary.getValue("30");
		assertEquals(value, "thirty");
		value = dictionary.getValue("40");
		assertEquals(value, "forty");
		value = dictionary.getValue("50");
		assertEquals(value, "fifty");
		value = dictionary.getValue("60");
		assertEquals(value, "sixty");
		value = dictionary.getValue("70");
		assertEquals(value, "seventy");
		value = dictionary.getValue("80");
		assertEquals(value, "eighty");
	}

	/**
	 * method for get all values success case
	 * @throws Exception
	 */
	@Test
	public void getAllSuccessTest() throws Exception {

		FileReader file = new FileReader(
				"./DS/ASSIGNMENT5/DSASSIGNMENT_FIRST/src/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImpl(json);

		List<Value> expected = new ArrayList<Value>();
		expected.add(new Value("20", "twenty"));
		expected.add(new Value("30", "thirty"));
		expected.add(new Value("40", "forty"));
		expected.add(new Value("50", "fifty"));
		expected.add(new Value("60", "sixty"));
		expected.add(new Value("70", "seventy"));
		expected.add(new Value("80", "eighty"));
		List<Value> valueList = dictionary.getAll();

		for (int index = 0; index < expected.size(); index++) {
			assertEquals(expected.get(index).getKey(), valueList.get(index)
					.getKey());
			assertEquals(expected.get(index).getValue(), valueList.get(index)
					.getValue());
		}

	}

	/**
	 * method to find value between keys
	 * @throws Exception
	 */
	@Test
	public void getBetweenSuccessTest() throws Exception {

		FileReader file = new FileReader(
				"./DS/ASSIGNMENT5/DSASSIGNMENT_FIRST/src/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImpl(json);

		List<Value> expected = new ArrayList<Value>();
		expected.add(new Value("40", "forty"));
		expected.add(new Value("50", "fifty"));
		expected.add(new Value("60", "sixty"));
		expected.add(new Value("70", "seventy"));
		List<Value> valueList = dictionary.getBetween("30", "80");

		for (int index = 0; index < expected.size(); index++) {
			assertEquals(expected.get(index).getKey(), valueList.get(index)
					.getKey());
			assertEquals(expected.get(index).getValue(), valueList.get(index)
					.getValue());
		}

	}

	/**
	 * delete key and value success case
	 * @throws Exception
	 */
	@Test
	public void deleteSuccessTest() throws Exception {

		FileReader file = new FileReader(
				"./DS/ASSIGNMENT5/DSASSIGNMENT_FIRST/src/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		DictionaryImpl dictionary = new DictionaryImpl(json);
		boolean result = dictionary.delete("20");
		assertTrue(result);
		result = dictionary.delete("60");
		assertTrue(result);
		int size = dictionary.getSize();
		assertEquals(5, size);
	}

	/**
	 * method for find a value of key success case
	 * @throws Exception
	 */
	@Test
	public void getValueSuccessTest() throws Exception {

		FileReader file = new FileReader(
				"./DS/ASSIGNMENT5/DSASSIGNMENT_FIRST/src/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		DictionaryImpl dictionary = new DictionaryImpl(json);
		assertEquals("fifty", dictionary.getValue("50"));
		assertEquals("seventy", dictionary.getValue("70"));

	}

}
