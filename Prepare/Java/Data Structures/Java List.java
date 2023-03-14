import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int N = scanner.nextInt();
            List<Integer> L = new ArrayList(N);
            for (int i=0; i<N; i++) {
                L.add(scanner.nextInt());
            }

            int Q = scanner.nextInt();
            List<Query> queries = new ArrayList<>(Q);
            for (int i=0; i<Q; i++) {

                QueryType type = QueryType.EMPTY;
                while (type == QueryType.EMPTY) {
                    try {
                        type = QueryType.valueOf(scanner.nextLine().trim().toUpperCase());
                    } catch (IllegalArgumentException exception) {
                        continue;
                    }
                }

                Query query;
                switch(type) {
                    case INSERT:
                        query = new Query(type, scanner.nextInt(), scanner.nextInt());
                        break;
                    case DELETE:
                        query = new Query(type, scanner.nextInt());
                        break;
                    default:
                        query = new Query();
                }

                queries.add(query);
            }

            L = applyQueries(L, queries);

            System.out.println(L.toString()
                    .replace("[", "")
                    .replace(",", "")
                    .replace("]", "")
                    .trim());
        }
    }

    private static List<Integer> applyQueries(List<Integer> L, List<Query> queries) {
        for (Query query : queries) {
            switch(query.getType()) {
                case INSERT:
                    L.add(query.getX(), query.getY());
                    break;
                case DELETE:
                    L.remove(query.getX());
                    break;
                default:
                    continue;
            }
        }
        return L;
    }

    private static enum QueryType {
        INSERT, DELETE, EMPTY;
    }

    private static class Query {
        private final QueryType type;
        private final int x;
        private final int y;

        Query() {
            this(QueryType.EMPTY, 0, 0);
        }
        Query(QueryType type, int x) {
            this(type, x, 0);
        }
        Query(QueryType type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public QueryType getType() {
            return type;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}
