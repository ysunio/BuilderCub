package EMEA.Array;

//  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//  Output:         [[7,4,1],[8,5,2],[9,6,3]]
public class RotateImage {

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] row : image) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }

        System.out.println();
        rotateImage(image);
        System.out.println();

        for (int[] row : image) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }

    private static void rotateImage(int[][] image) {
        transpose(image);
        reverseEachRow(image);
    }

    private static void transpose(int[][] image) {
        int nRow = image.length;
        int nCol = image[0].length;
        for (int idx = 0; idx < nRow; idx++) {
            for (int idy = idx; idy < nCol; idy++) {
                int holdSwapValue = image[idx][idy];
                image[idx][idy] = image[idy][idx];
                image[idy][idx] = holdSwapValue;
            }
        }
    }

    private static void reverseEachRow(int[][] image) {
        for (int[] row : image) {
            int start = 0, end = row.length - 1;
            while (start < end) {
                int holdSwapValue = row[start];
                row[start] = row[end];
                row[end] = holdSwapValue;
                start++;
                end--;
            }
        }
    }
}
