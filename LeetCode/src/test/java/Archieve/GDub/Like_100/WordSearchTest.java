package Archieve.GDub.Like_100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void exist() {
        WordSearch wordSearch = new WordSearch();

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Assertions.assertTrue(wordSearch.exist(board, "ABCCED"));
        Assertions.assertTrue(wordSearch.exist(board, "SEE"));
        Assertions.assertFalse(wordSearch.exist(board, "ABCB"));
    }
}