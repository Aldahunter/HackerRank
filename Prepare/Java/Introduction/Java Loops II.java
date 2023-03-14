import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSequence(a, b, n);
        }
        in.close();
    }

    private static void printSequence(int a, int b, int N) {
        HashMap<Double, Integer> cache = new HashMap<>();
        for (double n = 0; n < N; n++) {
            System.out.printf("%d ", getNthTerm(a, b, n, cache));
        }
        System.out.println();
    }

    private static int getNthTerm(int a, int b, double n, HashMap<Double, Integer> cache) {
        if (n == -1) {
            return a;
        }
        return cache.computeIfAbsent(n,
                n_i -> getNthTerm(a, b, n_i-1, cache) + ((int) Math.pow(2, n_i) * b)
        );
    }
}
