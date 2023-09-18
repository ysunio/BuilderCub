package Problems.medium;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    // O(m*n*(word_len))
    public static boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++)
                if (searchElement(board, word, x, y, 0)) return true;
        }
        return false;
    }

    private static boolean searchElement(char[][] board, String word, int x, int y, int idx) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= board.length || y >= board[0].length || y < 0) return false;
        char currentCharValue = board[x][y];
        if (currentCharValue == '*') return false;

        if (board[x][y] != word.charAt(idx)) return false;
        board[x][y] = '*';

        boolean found = searchElement(board, word, x + 1, y, idx + 1)
                || searchElement(board, word, x, y + 1, idx + 1)
                || searchElement(board, word, x - 1, y, idx + 1)
                || searchElement(board, word, x, y - 1, idx + 1);

        board[x][y] = currentCharValue;
        return found;
    }
}
