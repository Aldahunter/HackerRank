import java.io.*;
import java.math.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        BigInteger n;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n = new BigInteger(bufferedReader.readLine());
        }

        // Detemine Prime with 99.9023% certainty (= 1 - 0.5^{10})
        System.out.println(n.isProbablePrime(10) ? "prime" : "not prime");
    }
}
