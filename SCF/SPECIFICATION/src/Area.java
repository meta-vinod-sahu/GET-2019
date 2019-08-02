// Assignment 3(c)

import java.util.Scanner;

public class Area {

	static Scanner s1;

	public Area() {
		s1 = new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		int choice, exit = 0;
		double width, height, radius, side; // stands for width, height , radius and side
							// respectively
		Area a = new Area();
		try {
			while (exit == 0) {
				System.out.println("1. Area of Triangle");
				System.out.println("2. Area of Rectangle");
				System.out.println("3. Area of Square");
				System.out.println("4. Area of Circle");
				System.out.println("5. Exit");
				System.out.println("Enter your choice :: ");
				choice = s1.nextInt();
				switch (choice) {
				case 1:
					try {
						System.out.println("Enter width::");
						width = s1.nextDouble();
						System.out.println("Enter height::");
						height = s1.nextDouble();
						if (width == 0 || height == 0)
							throw new ArithmeticException();
						System.out.println(" Area of Triangle :: "
								+ a.areaTriangle(width, height));
					} catch (ArithmeticException e) {
						System.out.println(" you entered zero value input ");
					}
					break;

				case 2:
					try {
						System.out.println("Enter width::");
						width = s1.nextDouble();
						System.out.println("Enter height::");
						height = s1.nextDouble();
						if (width == 0 || height == 0)
							throw new ArithmeticException();
						System.out.println(" Area of Rectangle :: "
								+ a.areaRectangle(width, height));
					} catch (ArithmeticException e) {
						System.out.println(" you entered zero value input ");
					}
					break;

				case 3:
					try {
						System.out.println("Enter side::");
						side = s1.nextDouble();
						if (side == 0)
							throw new ArithmeticException();
						System.out.println(" Area of Square :: "
								+ a.areaSquare(side));
					} catch (ArithmeticException e) {
						System.out.println(" you entered zero value input ");
					}
					break;

				case 4:
					try {
						System.out.println("Enter radius::");
						radius = s1.nextDouble();
						if (radius == 0)
							throw new ArithmeticException();
						System.out.println(" Area of Circle :: "
								+ a.areaCircle(radius));
					} catch (ArithmeticException e) {
						System.out.println(" you entered zero value input ");
					}
					break;

				case 5:

					exit = 1;
					break;

				default:

					System.out.println(" please enter valid choice ");
				}
			}
		} catch (Exception e) {
			System.out.println(" Invalid input entered ");
		}
	}

	/**
	 * @param w and @param h are width and height to calculate area
	 * @return area returns the area of triangle
	 */
	public Double areaTriangle(Double w, Double h) {
		double area = 0;
		area = (0.5 * w * h);
		return area;

	}

	/**
	 * @param w and @param h are width and height to calculate area
	 * @return area returns the area of rectangle
	 */
	public Double areaRectangle(Double w, Double h) {

		double area = (w * h);
		return area;

	}

	/**
	 * @param s is side of square
	 * @return area returns the area of square
	 */
	public Double areaSquare(Double s) {
		double area = (s * s);
		return area;

	}

	/**
	 * @param r is radius of circle
	 * @return area returns the area of circle
	 */
	public Double areaCircle(Double r) {
		double area = (3.14 * r * r);
		return area;

	}

}