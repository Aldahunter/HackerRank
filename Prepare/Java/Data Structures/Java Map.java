//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution {

    public static void main(String []argh) {

        Map<String, String> phonebook = new HashMap<>();

        try(Scanner in = new Scanner(System.in)) {
            int n = in.nextInt(); in.nextLine();

            for(int i=0; i<n; i++) {
                String name = in.nextLine();
                int phonenumber = in.nextInt();

                phonebook.put(name, name + "=" + String.valueOf(phonenumber));
                in.nextLine();
            }

            while(in.hasNext())
            {
                String query = in.nextLine();

                System.out.println(phonebook.getOrDefault(query, "Not found"));
            }
        }
    }
}
