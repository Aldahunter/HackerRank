import java.io.*;
import java.util.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                System.out.println(encryptString(s));
            }
        }
    }

    private static String encryptString(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(s.getBytes());
        byte[] digest = messageDigest.digest();
        return convertByteToHexString(digest);
    }

    private static String convertByteToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
