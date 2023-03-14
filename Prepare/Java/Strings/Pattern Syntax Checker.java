import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0 && in.hasNext()) {
            String pattern = in.nextLine();

            //Write your code
            if (pattern == null || pattern.trim().isEmpty()) {
                System.out.println("Invalid");
            }

            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch (PatternSyntaxException exception) {
                System.out.println("Invalid");
            }
        }
        in.close();
    }
}
