package GDublin.Like_100;

public class WordSearch {

    // https://leetcode.com/problems/word-search
    public boolean exist(char[][] board, String word) {
        for (int idx = 0; idx < board.length; idx++) {
            for (int idy = 0; idy < board[0].length; idy++) {
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                if (exist(board, idx, idy, word, 0, isVisited)) return true;
            }
        }
        return false;
    }

    /**
     * For a given index and string id, traverse through and search if word exist in board
     * @param board
     * @param idx
     * @param idy
     * @param word
     * @param iChar
     * @param isVisited
     * @return
     */
    private boolean exist(char[][] board, int idx, int idy, String word, int iChar, boolean[][] isVisited) {
        if (iChar >= word.length()) return true;
        if (idx < 0 || idy < 0 || idx >= board.length || idy >= board[0].length) return false;
        if (isVisited[idx][idy]) return false;

        char currentChar = board[idx][idy];
        if (currentChar == word.charAt(iChar)) {
            isVisited[idx][idy] = true;

            boolean hasValue =
                    exist(board, idx + 1, idy, word, iChar + 1, isVisited) ||
                            exist(board, idx, idy + 1, word, iChar + 1, isVisited) ||
                            exist(board, idx - 1, idy, word, iChar + 1, isVisited) ||
                            exist(board, idx, idy - 1, word, iChar + 1, isVisited);

            isVisited[idx][idy] = false;
            return hasValue;
        }
        return false;
    }
}
