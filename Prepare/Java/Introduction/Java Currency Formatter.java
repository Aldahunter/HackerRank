import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        System.out.println("US: " + formatPayment(Locale.US, payment));
        System.out.println("India: " + formatPayment(new Locale("en", "in"), payment));
        System.out.println("China: " + formatPayment(Locale.CHINA, payment));
        System.out.println("France: " + formatPayment(Locale.FRANCE, payment));
    }

    private static String formatPayment(Locale locale, double payment) {
        return NumberFormat.getCurrencyInstance(locale).format(payment);
    }
}
