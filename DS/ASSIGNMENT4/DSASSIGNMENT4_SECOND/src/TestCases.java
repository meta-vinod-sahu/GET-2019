import static org.junit.Assert.*;
import org.junit.Test;

/**

 */
public class TestCases {

	/**
	 * This test method test positive test case on getNumberOfUniqueCharacters
	 * method in UniqueCharacterFinder class
	 */
	@Test
	public void getNumberOfUniqueCharactersMethodPositiveCasesTest() {

		UniqueCharacter uniqueChracterFinder = new UniqueCharacter();
		String input1 = "abcd";
		String input2 = "aaaa";
		String input3 = "rty567%^&";
		String input4 = "abcd";
 		assertEquals(4,uniqueChracterFinder.getNumberOfUniqueCharacters(input1));
		assertEquals(1,uniqueChracterFinder.getNumberOfUniqueCharacters(input2));
		assertEquals(9,uniqueChracterFinder.getNumberOfUniqueCharacters(input3));
		assertEquals(4,uniqueChracterFinder.getNumberOfUniqueCharacters(input4));
	}

}