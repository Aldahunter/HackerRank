import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(x / y);
        }
        catch (ArithmeticException exception) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        catch (InputMismatchException exception) {
            System.out.println("java.util.InputMismatchException");
        }
    }
}
