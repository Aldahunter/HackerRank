import java.io.*;
import java.util.*;

public class Solution {

    static int base;
    static int height;


    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            base = Integer.parseInt(scanner.nextLine());
            height = Integer.parseInt(scanner.nextLine());
        }

        if (base <= 0 || height <= 0) {
            System.out.println(
                    "java.lang.Exception: Breadth and height must be positive"
            );
        }
        else {
            System.out.println(base * height);
        }
    }
}
