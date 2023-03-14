import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int i = 1;
            while (scanner.hasNext()) {
                System.out.printf("%d %s\n", i++, scanner.nextLine());
            }
        }
    }
}
