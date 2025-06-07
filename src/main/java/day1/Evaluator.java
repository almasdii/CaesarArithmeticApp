package day1;

import java.util.Locale;


public class Evaluator {

    private static final char END = '\0';

    public static String evaluate(String expr) {
        expr = expr.replaceAll("\\s+", "");
        Parser p = new Parser(expr + END);
        double val = p.parseExpression();

        if (Double.isInfinite(val) || Double.isNaN(val))
            throw new IllegalArgumentException("Division by zero");


        long asLong = (long) val;
        return (val == asLong) ? String.valueOf(asLong)
                : String.format(Locale.US, "%s", val);
    }



    private static final class Parser {
        private final String s;
        private int pos = 0;

        Parser(String s) { this.s = s; }

        char peek()        { return s.charAt(pos); }
        char consume()     { return s.charAt(pos++); }
        boolean eat(char c){ if (peek()==c){ pos++; return true; } return false;}

        double parseExpression() {
            double val = parseTerm();
            while (true) {
                if      (eat('+')) val += parseTerm();
                else if (eat('-')) val -= parseTerm();
                else break;
            }
            return val;
        }

        double parseTerm() {                    // term = factor { (*|/) factor }
            double val = parseFactor();
            while (true) {
                if      (eat('*')) val *= parseFactor();
                else if (eat('/')) val /= parseFactor();
                else break;
            }
            return val;
        }

        double parseFactor() {
            if (eat('+')) return  parseFactor();
            if (eat('-')) return -parseFactor();

            if (eat('(')) {
                double val = parseExpression();
                if (!eat(')')) throw new IllegalArgumentException("Missing ')'");
                return val;
            }

            return parseNumber();
        }

        double parseNumber() {
            int start = pos;
            while (Character.isDigit(peek())) consume();
            if (peek() == '.') {
                consume();
                while (Character.isDigit(peek())) consume();
            }
            if (start == pos) throw new IllegalArgumentException("Number expected");
            return Double.parseDouble(s.substring(start, pos));
        }
    }
}
