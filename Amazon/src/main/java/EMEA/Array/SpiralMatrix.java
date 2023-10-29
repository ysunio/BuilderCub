package EMEA.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        int sRow = 0, eRow = matrix.length - 1, sCol = 0, eCol = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (sRow <= eRow && sCol <= eCol) {

            for (int idx = sCol; idx <= eCol; idx++) {
                res.add(matrix[sRow][idx]);
            }

            for (int idx = sRow + 1; idx <= eRow; idx++) {
                res.add(matrix[idx][eCol]);
            }


            for (int idx = eCol - 1; idx >= sCol; idx--) {
                if (sRow == eRow) break;
                res.add(matrix[eRow][idx]);
            }


            for (int idx = eRow - 1; idx > sRow; idx--) {
                if (sCol == eCol) break;
                res.add(matrix[idx][sCol]);
            }

            sCol++;
            sRow++;
            eCol--;
            eRow--;
        }

        return res;
    }
}
