import java.io.*;
import java.util.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String string = scanner.nextLine();
                System.out.println(encryptString(string));
            }
        }
    }

    private static String encryptString(String string) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(string.getBytes());
        byte[] digested = digest.digest();
        return javax.xml.bind.DatatypeConverter.printHexBinary(digested).toLowerCase();
    }
}
