import java.util.*;

public class Solution {

    static private boolean[] visited;

    public static boolean canWin(int leap, int[] game) {
        if (leap < 0 || game == null || game.length == 0) {
            return false;
        }

        visited = new boolean[game.length];
        return canWin(leap, game, 0);
    }
    private static boolean canWin(int leap, int[] game, int position) {

        if (position < 0 || visited[position]) {
            return false;
        }

        visited[position] = true;
        if  (game[position] == 1) {
            return false;
        }
        if (position + leap > game.length - 1 || position == game.length - 1) {
            return true;
        }

        return (canWin(leap, game, position + leap)
                || canWin(leap, game, position + 1)
                || canWin(leap, game, position - 1));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
