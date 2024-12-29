package Archieve.Leetcode;

public class FindMedianOfSortedArray {
    public static void main(String[] args) {
        int[] A = new int[]{1,2};
        int[] B = new int[]{3,4};
        System.out.println(findMedianSortedArrays(A, B));
    }
    private static double findMedianSortedArrays(int[] A, int[] B) {
        int middleElement = (A.length + B.length) / 2;
        int[] boundArray = new int[A.length + B.length];

        int xIdx = 0, yIdx = 0, rIdx = 0;

        while (xIdx < A.length || yIdx < B.length) {
            if (xIdx < A.length && yIdx < B.length)
                boundArray[rIdx++] = A[xIdx] < B[yIdx] ? A[xIdx++] : B[yIdx++];
            else
                boundArray[rIdx++] = xIdx < A.length ? A[xIdx++] : B[yIdx++];
        }

        if ((A.length + B.length) % 2 != 0)
            return boundArray[middleElement];
        else
            return ((double) (boundArray[middleElement] + boundArray[middleElement - 1]) / 2);
    }
}
