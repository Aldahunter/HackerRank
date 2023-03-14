import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = null;
        try (Scanner scan = new Scanner(System.in)) {
            s = scan.nextLine();
        }
        finally {
            if (s == null || s.trim().length() <= 0) {
                System.out.println(0);
            }
            else {
                String[] tokens = s.trim().split("[ !,?._'@]+");

                System.out.println(tokens.length);
                for (String token : tokens) {
                    System.out.println(token);
                }

            }
        }
    }
}
