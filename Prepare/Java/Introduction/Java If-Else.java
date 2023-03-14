import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private final static String WEIRD = "Weird";
    private final static String NOT_WEIRD = "Not Weird";


    private static void checkInteger(int n) {
        if (n % 2 == 1) {
            System.out.println(WEIRD);
        }
        else if (2 <= n && n <= 5) {
            System.out.println(NOT_WEIRD);
        }
        else if (6 <= n && n <= 20) {
            System.out.println(WEIRD);
        }
        else {
            System.out.println(NOT_WEIRD);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        checkInteger(N);
    }
}
