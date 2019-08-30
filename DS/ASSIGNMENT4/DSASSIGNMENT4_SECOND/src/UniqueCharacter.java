import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This class find unique character in strings
 */
public class UniqueCharacter {

	// HashMap contain string for checking for duplicate string if comes
	private HashMap<String, Set<Character>> stringCache;

	/**
	 * Parameterized constructor
	 */
	public UniqueCharacter() {
		stringCache = new HashMap<String, Set<Character>>();
	}

	/**
	 * This method find total unique character in given string
	 * @param inputString string containing different characters
	 * @return number of unique character
	 */
	public int getNumberOfUniqueCharacters(String inputString) {
		Set<Character> uniqueCharacterSet;
		int size=0;
		if (stringCache.containsKey(inputString)) {
			 size = stringCache.get(inputString).size();
		} else {
			 uniqueCharacterSet = new HashSet<Character>();
			for (int charIndex = 0; charIndex < inputString.length(); charIndex++) {
				uniqueCharacterSet.add(inputString.charAt(charIndex));
			}
			stringCache.put(inputString, uniqueCharacterSet);
			size= uniqueCharacterSet.size();
		}
		return size;
	}
}