package Archieve.Problems.medium;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix[0].length * matrix.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if (target == matrix[i][j]) return true;
            if (target > matrix[i][j])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
