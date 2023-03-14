import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(isStringPalindromeIgnoreCase(A) ? "Yes" : "No");
    }

    private static boolean isStringPalindromeIgnoreCase(String s) {
        String s_r = (new StringBuilder(s)).reverse().toString();

        for (int i = 0; i < s.length(); i++) {
            if (!s.substring(i, i+1).equalsIgnoreCase(s_r.substring(i, i+1))) {
                return false;
            }
        }
        return true;

    }
}
