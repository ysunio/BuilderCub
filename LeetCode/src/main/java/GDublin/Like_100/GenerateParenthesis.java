package GDublin.Like_100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private List<String> listOfParenthesis = new ArrayList<>();

    // https://leetcode.com/problems/generate-parentheses
    // Generating parenthesis based on given number
    public List<String> generateParenthesis(int n) {
        listOfParenthesis = new ArrayList<>();

        // Start as 0, 0 till N
        generate(0, 0, new StringBuilder(), n);
        return listOfParenthesis;
    }

    private void generate(int openCount, int closeCount, StringBuilder gString, int N) {
        // Since we are start with openCount first, so close should not pass open
        if (closeCount > openCount) return;

        // Base case, to consider one as valid combination
        if (openCount == closeCount && closeCount == N) {
            listOfParenthesis.add(new String(gString));
        }

        // Start with Open
        if (openCount < N) {
            gString.append('(');
            generate(openCount + 1, closeCount, gString, N);
            gString.deleteCharAt(gString.length() - 1);
        }

        // For every open, we will perform close until close is less than open
        if (closeCount < openCount) {
            gString.append(')');
            generate(openCount, closeCount + 1, gString, N);
            gString.deleteCharAt(gString.length() - 1);
        }
    }
}
