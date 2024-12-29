package Archieve.Leetcode;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return false;
        boolean[][] boardVisit = new boolean[board.length][board[0].length];
        for (int idx = 0; idx < board.length; idx++)
            for (int idy = 0; idy < board[idx].length; idy++)
                if (word.charAt(0) == board[idx][idy] && exist(board, word, 0, idx, idy, boardVisit)) return true;
        return false;
    }

    private static boolean exist(
            char[][] board, String word, int cIdx, int x, int y,
            boolean[][] boardVisit
    ) {
        if (cIdx >= word.length()) return true;
        if (x < 0 || y < 0
                || x >= board.length || y >= board[0].length
                || boardVisit[x][y]
        ) return false;

        boolean isExist = false;
        if (board[x][y] == word.charAt(cIdx)) {
            boardVisit[x][y] = true;
            isExist = exist(
                    board, word, cIdx + 1, x + 1, y, boardVisit
            ) || exist(
                    board, word, cIdx + 1, x - 1, y, boardVisit
            ) || exist(
                    board, word, cIdx + 1, x, y + 1, boardVisit
            ) || exist(
                    board, word, cIdx + 1, x, y - 1, boardVisit
            );
            boardVisit[x][y] = false;
        }
        return isExist;
    }
}
