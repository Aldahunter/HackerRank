import java.util.*;
import java.util.stream.*;

class Solution{

    public static void main(String []argh)
    {
        try (Scanner sc = new Scanner(System.in)){
            while (sc.hasNext()) {
                String input=sc.next();
                System.out.println(areBracketsBalanced(input));
            }
        }
    }

    private static boolean areBracketsBalanced(String input) {
        Stack<Bracket> openBrackets = new Stack<>();

        for (char character : input.toCharArray()) {
            String c = String.valueOf(character);

            if (!Bracket.isBracket(c)) {
                continue;
            }

            if (Bracket.isLeftBracket(c)) {
                openBrackets.add(Bracket.getBracketType(c));
                continue;
            }

            if (openBrackets.isEmpty() || !c.equals(openBrackets.pop().rightSymbol)) {
                return false;
            }
        }

        return openBrackets.isEmpty();
    }

    private static enum Bracket {
        Round("(", ")"),
        Curly("{", "}"),
        Square("[", "]");

        public final String leftSymbol;
        public final String rightSymbol;

        private Bracket(String leftSymbol, String rightSymbol) {
            this.leftSymbol = leftSymbol;
            this.rightSymbol = rightSymbol;
        }

        private static final List<String> LEFT_SYMBOLS = Arrays.stream(values())
                .map(b -> b.leftSymbol).collect(Collectors.toList());
        private static final List<String> RIGHT_SYMBOLS = Arrays.stream(values())
                .map(b -> b.rightSymbol).collect(Collectors.toList());
        private static final List<String> ALL_SYMBOLS = Stream
                .concat(LEFT_SYMBOLS.stream(), RIGHT_SYMBOLS.stream())
                .collect(Collectors.toList());

        public static boolean isBracket(String character) {
            return ALL_SYMBOLS.contains(character);
        }
        public static boolean isLeftBracket(String character) {
            return LEFT_SYMBOLS.contains(character);
        }

        public static Bracket getBracketType(String character) {
            return Arrays.stream(values())
                    .filter(b -> b.isFromPair(character)).
                    findFirst().orElse(null);
        }

        public boolean isFromPair(String character) {
            return character.equals(leftSymbol) || character.equals(rightSymbol);
        }
    }
}
