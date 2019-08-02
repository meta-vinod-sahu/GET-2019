// Assignment Marksheet of student

import java.util.Scanner;

public class MarkSheet {

	static Scanner s1;

	public MarkSheet() {
		s1 = new Scanner(System.in);
	}

	public static void main(String[] args) {

		int choice, exit = 0, n = 0; // n is the no. of students
		MarkSheet m = new MarkSheet();
		try {
			System.out.println("Enter the no. of students:: ");
			n = s1.nextInt();
			if (n == 0)
				throw new ArithmeticException();

			else {
				int grade_of_students[] = new int[n]; // array to store grades
				System.out.println("Enter the grades of the students ");
				for (int i = 0; i < n; i++)
					grade_of_students[i] = s1.nextInt();

				while (exit == 0) {
					System.out.println("1. Average of all grades:: ");
					System.out.println("2.Maximum Grade");
					System.out.println("3. Mininmum Grade");
					System.out.println("4. Percentage of passed students");
					System.out.println("5. Exit");
					System.out.println("Enter your choice :: ");
					choice = s1.nextInt();
					switch (choice) {
					case 1:

						System.out.println(" Average of grades :: "
								+ m.avgGrade(grade_of_students, n));
						break;

					case 2:

						System.out.println(" Maximum grade :: "
								+ m.maxGrade(grade_of_students, n));

						break;

					case 3:

						System.out.println(" Minimum grade :: "
								+ m.minGrade(grade_of_students, n));

						break;

					case 4:

						System.out.println("Percentage of passed students :: "
								+ m.perGrade(grade_of_students, n));

						break;

					case 5:

						exit = 1;
						break;

					default:

						System.out.println(" please enter valid choice ");
					}
				}

			}
		} catch (ArithmeticException a) {
			System.out.println("No. of Students can't be  zero!");
		} catch (Exception e) {
			System.out.println("You entered invalid input");
		}

	}

	/**
	 * @param g is an array of students and @param n is the total no. of students to calculate the average
	 * @return avg ,an average of the grades
	 */
	public Double avgGrade(int g[], int n) {
		Double avg = 0.0;
		for (int i = 0; i < n; i++)
			avg += g[i];
		avg = avg / n;
		return avg;

	}

	/**
	 * @param g is an array of students and @param n is the total no. of students to search max grade
	 * @return max , max grade out of all
	 */
	public int maxGrade(int g[], int n) {
		int max = 0;
		for (int i = 0; i < n; i++)
			if (g[i] > max)
				max = g[i];
		return max;

	}

	/**
	 * @param g is an array of students and @param n is the total no. of students to search min grade
	 * @return min , min grade out of all
	 */
	public int minGrade(int g[], int n) {
		int min = 100;
		for (int i = 0; i < n; i++)
			if (g[i] < min)
				min = g[i];
		return min;

	}

	/**
	 * @param gis an array of students and @param n is the total no. of students to calculate percentage of passed students
	 * @return per , percentage of passed students
	 */
	public double perGrade(int g[], int n) {
		int count = 0;
		double per = 0.0;
		for (int i = 0; i < n; i++)
			if (g[i] >= 40)
				count++;
		per = (count * 100) / n;
		return per;

	}

}