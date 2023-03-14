import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        sc.close();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(getSummedLenghts(A, B));
        System.out.println(isLexicographicallyLarger(A, B) ? "Yes" : "No");
        System.out.println(capitaliseInitialLetter(A)
                + " " + capitaliseInitialLetter(B));
    }

    private static int getSummedLenghts(String... strings) {
        return Arrays.asList(strings)
                .stream()
                .map(String::length)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static boolean isLexicographicallyLarger(String A, String B) {
        return A.compareTo(B) > 0;
    }

    private static String capitaliseInitialLetter(String s) {
        return s.substring(0, 1).toUpperCase()
                .concat(s.substring(1));
    }
}
