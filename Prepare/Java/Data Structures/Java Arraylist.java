import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        ArrayList<ArrayList<Integer>> lines;
        try (Scanner scanner = new Scanner(System.in)) {

            int n = scanner.nextInt();
            lines = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {

                int d = scanner.nextInt();
                ArrayList<Integer> line = new ArrayList<>(d);

                for (int j = 0; j < d; j++) {
                    line.add(scanner.nextInt());
                }

                lines.add(line);
            }

            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {

                try {
                    System.out.println(
                            lines
                                    .get(scanner.nextInt() - 1)
                                    .get(scanner.nextInt() - 1)
                    );
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println(
                            "ERROR!"
                    );
                }
            }
        }

    }
}
