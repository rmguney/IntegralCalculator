import java.util.Scanner;

public class RiemannSum {

    public static double function(double a, double b, double c, double d, double x) {
        return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
    }

    public static double riemannSum(double a, double b, double c, double d, double start, double end, double deltaX) {
        int numRectangles = (int) ((end - start) / deltaX);
        double sum = 0;

        for (int i = 0; i < numRectangles; i++) {
            double x = start + i * deltaX;
            double f_x = function(a, b, c, d, x);
            sum += f_x * deltaX;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the coefficient 'a' for ax^3: ");
            double a = scanner.nextDouble();

            System.out.print("Enter the coefficient 'b' for bx^2: ");
            double b = scanner.nextDouble();

            System.out.print("Enter the coefficient 'c' for cx: ");
            double c = scanner.nextDouble();

            System.out.print("Enter the coefficient 'd': ");
            double d = scanner.nextDouble();

            System.out.print("Enter start of the interval: ");
            double start = scanner.nextDouble();

            System.out.print("Enter end of the interval: ");
            double end = scanner.nextDouble();

            System.out.print("Enter deltaX (smaller for better accuracy): ");
            double deltaX = scanner.nextDouble();

            double integral = riemannSum(a, b, c, d, start, end, deltaX);

            System.out.println("The approximate integral is: " + integral);
        } catch (java.util.InputMismatchException e) {
            System.err.println("Invalid input. Please enter valid numeric values.");
        } finally {
            scanner.close();
        }
    }
}
