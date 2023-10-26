import java.util.Scanner;

public class RiemannSumBonus {

    public static double riemannSum(double a, double b, double c, double d, double start, double end, double delx) {
        int numRectangles = (int)((end - start) / delx);
        double sum = 0;

        for (int i = 0; i < numRectangles; i++) {
            double x = start + i * delx;
            double f_x = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
            sum += f_x * delx;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // removed power expression ^ for ease of typing
        System.out.print("Enter the polynomial in form ax3+bx2+cx+d: ");
        String poly = scanner.nextLine();

        System.out.print("Enter start of the interval: ");
        double start = scanner.nextDouble();

        System.out.print("Enter end of the interval: ");
        double end = scanner.nextDouble();

        System.out.print("Enter deltaX (smaller for better accuracy): ");
        double delx = scanner.nextDouble();

        poly = poly.replace("x^3", "x3").replace("x^2", "x2").replace("x^1", "x").replace("x^0", "");

        String[] terms = poly.split("\\+");
        double a = 0, b = 0, c = 0, d = 0;

        for (String term : terms) {
            if (term.contains("x3")) {
                a = Double.parseDouble(term.replace("x3", ""));
            } else if (term.contains("x2")) {
                b = Double.parseDouble(term.replace("x2", ""));
            } else if (term.contains("x")) {
                c = Double.parseDouble(term.replace("x", ""));
            } else {
                d = Double.parseDouble(term);
            }
        }

        double integral = riemannSum(a, b, c, d, start, end, delx);

        System.out.println("Approximate integral is: " + integral);

        scanner.close();
    }
}
