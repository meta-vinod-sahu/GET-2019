// Assignment String Operation

import java.util.Scanner;

public class StringOperation {

	static Scanner s1;

	StringOperation() {
		s1 = new Scanner(System.in);
	}

	/**
	 * @return , returns the input string
	 */
	String input() {
		String s;
		System.out.println("Enter the String :: ");
		s = s1.next();
		return s;
	}

	/**
	 * @param a and @param b , to compare both are equal or not
	 * @return returns 1 if equal else 0
	 */
	int compare(String a, String b) {
		int f = 1; // flag
		if (a.length() == b.length()) {
			for (int i = 0; i < a.length(); i++)
				if (a.charAt(i) != b.charAt(i))
					f = 0;
		} else
			f = 0;
		return f;
	}

	/**
	 * @param s , to reverse a string s
	 * @return returns reversed string of s
	 */
	String reverse(String s) {
		char c[] = s.toCharArray();
		char t;
		for (int i = 0, j = s.length() - 1; i < (s.length() / 2); i++, j--) {
			t = c[i];
			c[i] = c[j];
			c[j] = t;
		}
		String rt = new StringBuffer(String.valueOf(c)).toString(); // converts
																	// character
																	// to string

		return rt;
	}

	/**
	 * @param s, to toggle a case of a string s
	 * @return returns toggled string of s
	 */
	String toggleCase(String s) {
		char c[] = new char[s.length()];

		for (int i = 0; i < s.length(); i++) {

			char aChar = s.charAt(i);
			if (65 <= aChar && aChar <= 90) {
				aChar = (char) ((aChar + 32));
			} else if (97 <= aChar && aChar <= 122) {
				aChar = (char) (aChar - 32);
			}
			c[i] = aChar;
		}

		String rt = new StringBuffer(String.valueOf(c)).toString();
		return rt;
	}

	/**
	 * @param s , to find a largest word in a string s
	 * @return returns largest word
	 */
	String largestWord(String s[]) {
		String maxlengthWord = "";
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() >= maxlengthWord.length()) {
				maxlengthWord = s[i];
			}
		}
		return maxlengthWord;
	}

	public static void main(String[] args) {

		int choice = 0, exit = 0;
		StringOperation so = new StringOperation();
		Scanner input = new Scanner(System.in);
		try {
			while (exit == 0) {
				System.out.println("1. Compare two Strings");
				System.out.println("2. Reverse a String");
				System.out.println("3. Toggle case of the String");
				System.out.println("4. Find largest Word in A String");
				System.out.println("5. exit ");

				System.out.println("Enter your choice :: ");
				choice = s1.nextInt();
				switch (choice) {
				case 1:
					if (so.compare(so.input(), so.input()) == 1)
						System.out.println(" Both Strings are Equal");
					else
						System.out.println(" Both Strings are UnEqual");

					break;

				case 2:
					System.out.println(" Reverse of the String is :: "
							+ so.reverse(so.input()));
					break;

				case 3:
					System.out.println(" Toggled case of the String is :: "
							+ so.toggleCase(so.input()));
					break;

				case 4:
					System.out.println(" Enter The String :: ");
					System.out.println(" Largest word in the string is :: "
							+ so.largestWord(input.nextLine().split(" ")));
					break;

				case 5:
					exit = 1;
					break;
				default:
					System.out.println(" please enter vaild no. ");
				}
			}

		} catch (Exception e) {
			System.out
					.println(" You enter invaild input please enter correct input ");
		}
	}

}