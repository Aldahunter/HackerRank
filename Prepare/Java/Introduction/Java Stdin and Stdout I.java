import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int a = 0; int b = 0; int c = 0;
        try (Scanner scan = new Scanner(System.in)) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
        }
        finally {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }
}
