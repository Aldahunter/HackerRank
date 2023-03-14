import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine();

            Solution solution = new Solution(N);

            for (int i = 0; i<M; i++) {
                solution.performOperation(scanner.nextLine()
                        .toUpperCase()
                        .split(" "));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private final int N;
    private final BitSet B1;
    private final BitSet B2;

    public Solution(int N) {
        this.N = N;
        this.B1 = new BitSet(N);
        this.B2 = new BitSet(N);
    }

    private void performOperation(String[] operation) throws Exception {
        switch (operation[0]) {
            case "AND":
                performAnd(operation[1], operation[2]);
                break;
            case "OR":
                performOr(operation[1], operation[2]);
                break;
            case "XOR":
                performXor(operation[1], operation[2]);
                break;
            case "FLIP":
                performFlip(operation[1], operation[2]);
                break;
            case "SET":
                performSet(operation[1], operation[2]);
                break;
            default:
                throw new Exception("Operation not supported: " + operation[0]);
        }
        System.out.println(B1.cardinality() + " " + B2.cardinality());
    }

    private BitSet getSet(String set) throws Exception {
        switch(set) {
            case "1":
                return B1;
            case "2":
                return B2;
            default:
                throw new Exception("Not found BitSet");
        }
    }
    private int getIndex(String index) throws Exception {
        Integer intIndex = Integer.valueOf(index);
        if (intIndex < 0 || N < intIndex-1 ) {
            throw new Exception("Index Out of Bounds");
        }
        return intIndex;
    }

    private void performAnd(String set1, String set2) throws Exception {
        getSet(set1).and(getSet(set2));
    }
    private void performOr(String set1, String set2) throws Exception {
        getSet(set1).or(getSet(set2));
    }
    private void performXor(String set1, String set2) throws Exception {
        getSet(set1).xor(getSet(set2));
    }
    private void performFlip(String set, String index) throws Exception {
        getSet(set).flip(getIndex(index));
    }
    private void performSet(String set, String index) throws Exception {
        getSet(set).set(getIndex(index));
    }
}
