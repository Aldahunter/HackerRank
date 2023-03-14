import java.util.*;
public class test {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Deque<Integer> deque = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            int n = in.nextInt();
            int m = in.nextInt();

            int maxUnique = 0;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();

                deque.addLast(num);
                set.add(num);

                if (deque.size() > m) {
                    int removed_num = deque.removeFirst();
                    if (!deque.contains(removed_num)) {
                        set.remove(removed_num);
                    }
                }

                int unique = set.size();
                if (unique > maxUnique) {
                    maxUnique = unique;

                    if (maxUnique == m) {
                        break;
                    }
                }
            }

            System.out.println(maxUnique);
        }
    }
}
