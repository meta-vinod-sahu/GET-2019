import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HexaCalculator implements Operations {

	char hex[];
	static Scanner s1;

	public HexaCalculator() {
		
		hex = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		s1 = new Scanner(System.in);
	}

	public String input() throws Exception {

		String str = null;
		boolean found = false;
		try {
			System.out.println("Enter the Hexa Decimal no. :: ");
			str = s1.next();
			char chararray[] = str.toCharArray();
			for (int i = 0; i < str.length(); i++) {
				found = false;
				for (int j = 0; j < 16; j++)
					if (chararray[i] == hex[j])
						found = true;
				if (!found) {
					throw new Exception("Invalid Hexa decimal Number");
				}
			}

		} catch (Exception e) {
			System.out.println("Enter valid Hexa Decimal Number");

		}
		return str;
	}

	public static void main(String[] args) throws Exception {
		
		int choice, deci = 0;
		HexaCalculator h = new HexaCalculator();
		try {
			while (true) {
				System.out.println("1. Add two Hex no");
				System.out.println("2. Subtract two Hex no");
				System.out.println("3. Multiply two Hex no");
				System.out.println("4. Divide two Hex no");
				System.out.println("5. Check equality of two Hex no");
				System.out.println("6. Check greater than between two Hex no");
				System.out.println("7. Check lesser than between two Hex no");
				System.out.println("8. Hex no. to Decimal");
				System.out.println("9. Decimal to Hex no.");

				System.out.println("Enter your choice :: ");
				choice = s1.nextInt();
				switch (choice) {
				case 1:
					System.out.println(" Addition :: "
							+ h.add(h.input(), h.input()));
					break;

				case 2:
					System.out.println(" Subtraction :: "
							+ h.subtract(h.input(), h.input()));
					break;

				case 3:
					System.out.println(" Multiplication :: "
							+ h.multiply(h.input(), h.input()));
					break;

				case 4:
					System.out.println(" Divide :: "
							+ h.divide(h.input(), h.input()));
					break;

				case 5:
					if (h.equalTo(h.input(), h.input()))
						System.out.println(" Both are equal");
					else
						System.out.println("Both are unequal");
					break;

				case 6:
					if (h.greaterThan(h.input(), h.input()))
						System.out
								.println(" hexa number 1 is greater than hexa number 2 ");
					else
						System.out
								.println("hexa number 1 is not greater than hexa number 2");
					break;

				case 7:
					if (h.LessThan(h.input(), h.input()))
						System.out
								.println(" hexa number 1 is less than hexa number 2 ");
					else
						System.out
								.println("hexa number 1 is not less than hexa number 2");
					break;

				case 8:
					System.out.println(" Decimal no is :: "
							+ h.toDecimal(h.input(), 16));
					break;

				case 9:
					System.out.println("Enter the Decimal no. :: ");
					try {
						deci = s1.nextInt();
						System.out.println(" Hexa Decimal no. is :: "
								+ h.decimalTo(deci, 16));

					} catch (Exception e) {
						System.out.println("Enter valid Hexa Decimal Number");
						throw new Exception("invalid input");
					}

					break;

				default:
					System.out.println(" please enter vaild no. ");
				}
			}
		} catch (Exception e) {
			System.out
					.println(" halted due to invalid input conditons please give valid input.. ");
		}
	}

	@Override
	public String add(String a, String b) {
		
		int d1, d2;
		d1 = toDecimal(a, 16);
		d2 = toDecimal(b, 16);
		d1 += d2;
		return decimalTo(d1, 16);
	}

	@Override
	public String subtract(String a, String b) {
		
		int d1, d2;
		d1 = toDecimal(a, 16);
		d2 = toDecimal(b, 16);
		d1 -= d2;
		if (d1 < 0)
			d1 *= -1;
		return decimalTo(d1, 16);
	}

	@Override
	public String multiply(String a, String b) {
		
		int d1, d2;
		d1 = toDecimal(a, 16);
		d2 = toDecimal(b, 16);
		d1 *= d2;
		return decimalTo(d1, 16);
	}

	@Override
	public String divide(String a, String b) {
		
		int d1, d2;
		d1 = toDecimal(a, 16);
		d2 = toDecimal(b, 16);
		int d3 = 0;
		try {
			d3 = (int) (d1 / d2);
		} catch (ArithmeticException e) {
			System.out
					.println("please enter valid numbers you entered zero in denominator ");
		}
		return decimalTo(d3, 16);
	}

	@Override
	public boolean equalTo(String a, String b) {
		
		if (a.equalsIgnoreCase(b))
			return true;
		else
			return false;
	}

	@Override
	public boolean greaterThan(String a, String b) {
		
		if (a.compareTo(b) > 0)
			return true;
		return false;
	}

	@Override
	public boolean LessThan(String a, String b) {
		
		if (a.compareTo(b) < 0)
			return true;
		return false;
	}

	@Override
	public String decimalTo(int d, int b) {
		
		int r = 0;
		List<Character> list = new ArrayList<>();
		while (d != 0) {
			r = d % b;
			d = (int) (d / b);
			list.add(hex[r]);
		}
		String listString = "";

		for (Character s : list) {
			listString += s;
		}
		String rt = new StringBuffer(String.valueOf(listString)).reverse()
				.toString();
		return rt;
	}

	@Override
	public int toDecimal(String h, int base) {
		
		int value = 0, i, j;
		String r = null;
		String hexString = new String(hex);
		for(i = 0 ; i < h.length() ; i++)
		{
			char eachchar = h.charAt(i);
			int index = hexString.indexOf(eachchar);
			System.out.println(hexString +"     "+base);
			value = base * value + index;
			System.out.println(value);
		}
		
		return value;
		
		
	}
	
	

}
