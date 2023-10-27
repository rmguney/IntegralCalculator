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
        System.out.print("Enter the polynomial in form ax3+bx2+cx+d: ");
        String poly = scanner.nextLine();

        System.out.print("Enter start of the interval: ");
        double start = scanner.nextDouble();

        System.out.print("Enter end of the interval: ");
        double end = scanner.nextDouble();

        System.out.print("Enter deltaX (smaller for better accuracy): ");
        double delx = scanner.nextDouble();

        poly = poly.replace("x^3", "x3").replace("x^2", "x2").replace("x^1", "x").replace("x^0", "");

        String[] degrees = poly.split("(?=[-+])");
        double a = 0, b = 0, c = 0, d = 0;

        for (String degree : degrees) {
            if (degree.contains("x3")) {
                if (degree.equals("x3")) {
                    a = 1;
                } else {
                    a = Double.parseDouble(degree.replace("x3", ""));
                }
            } else if (degree.contains("x2")) {
                if (degree.equals("x2")) {
                    b = 1;
                } else {
                    b = Double.parseDouble(degree.replace("x2", ""));
                }
            } else if (degree.contains("x")) {
                if (degree.equals("x")) {
                    c = 1;
                } else {
                    c = Double.parseDouble(degree.replace("x", ""));
                }
            } else {
                if (!degree.isEmpty()) {
                    d = Double.parseDouble(degree);
                }
            }
        }

        double integral = riemannSum(a, b, c, d, start, end, delx);

        System.out.println("Approximate integral is: " + integral);

        scanner.close();
    }
}
