import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            testCases--;
            String line = in.nextLine();

            //Write your code here
            Pattern pattern = Pattern.compile("<(\\P{Cc}+)>([^<]+)</\\1>");
            Matcher matcher = pattern.matcher(line);

            if (!matcher.find()) {
                System.out.println("None");
                continue;
            }

            do {
                System.out.println(matcher.group(2));
            } while (matcher.find());
        }
    }
}
