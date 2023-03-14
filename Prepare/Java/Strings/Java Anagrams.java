import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        java.util.List<Integer> a_chars = convertStringToCharList(a);
        java.util.List<Integer> b_chars = convertStringToCharList(b);

        java.util.Collections.sort(a_chars);
        java.util.Collections.sort(b_chars);

        return a_chars.equals(b_chars);
    }

    private static java.util.List<Integer> convertStringToCharList(String s) {
        return s.toLowerCase().chars()
                .boxed().collect(java.util.stream.Collectors.toList());
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
