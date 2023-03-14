import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Integer[] is = {1, 2, 3};
        String[] ss = {"Hello", "World"};

        printArray(is);
        printArray(ss);
    }

    public static <T> void printArray(T[] array) {
        if (array != null) {
            Arrays.stream(array).forEach(System.out::println);
        }
    }
}
