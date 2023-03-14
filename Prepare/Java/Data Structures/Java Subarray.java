import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            int[] A = new int[n];
            for (int i = 0; i<n; i++) {
                A[i] = scanner.nextInt();
            }

            findNegativeSubarrays(n, A);
        }

    }

    private static void findNegativeSubarrays(int n, int[] A) {

        List<Integer> cacheA = new ArrayList<>(Collections.nCopies(n, 0));

        int total = 0;
        for (int offset = 0; offset < n; offset++) {

            for (int i = 0; i < n-offset; i++) {
                cacheA.set(i, cacheA.get(i) + A[i + offset]);

                if (cacheA.get(i) < 0) total++;
            }
        }

        System.out.println(total);
    }
}
