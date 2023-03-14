import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int maxSumHourglasses = getMaxSumHourglasses(arr);
        System.out.println(maxSumHourglasses);
    }

    private static int getMaxSumHourglasses(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= 6 - 3; i++) {
            for (int j = 0; j <= 6 - 3; j++) {
                List<List<Integer>> subArr = getSubArray(arr, i, j);
                int sumedHourglass = sumHourglass(subArr);
                maxSum = (sumedHourglass > maxSum) ? sumedHourglass : maxSum;
            }
        }
        return maxSum;
    }

    private static List<List<Integer>> getSubArray(List<List<Integer>> arr, int top_row, int left_column) {
        return arr.subList(top_row, top_row+3).stream()
                .map(row -> row.subList(left_column, left_column+3))
                .collect(Collectors.toList());
    }

    private static int sumHourglass(List<List<Integer>> arr) {
        if (arr.size() != 3 && arr.stream().flatMap(List::stream).count() != 9) {
            throw new RuntimeException("Array should be 3x3");
        }
        final int counter[] = new int[] {0};
        return arr.stream()
                .map(row -> (counter[0]++ == 1) ? row.get(1) : row.stream().mapToInt(i -> i).sum())
                .mapToInt(i -> i).sum();
    }

}
