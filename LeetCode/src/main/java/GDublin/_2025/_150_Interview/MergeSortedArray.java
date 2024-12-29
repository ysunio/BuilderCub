package GDublin._2025._150_Interview;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,4,5,6,0};
        int[] B = new int[]{3};
        mergeTwoSortedArrayIntoA2(A, 5, B, 1);

        System.out.println("Result Start");
        for(int x : A) System.out.print(x+" ");
        System.out.println("Result End");

        System.out.println();
        int[] A2 = new int[]{4,0,0,0,0,0};
        int[] B2 = new int[]{1,2,3,5,6};
        mergeTwoSortedArrayIntoA(A2, 1, B2, 5);

        System.out.println("Result Start");
        for(int x : A2) System.out.print(x+" ");
        System.out.println("Result End");

    }

    // Not Optimal, but this can be One of Primary Solution
    // O(n) and O(n) as Time and Space
    private static void mergeTwoSortedArrayIntoA2(int[] A, int nA, int[] B, int nB){
        int[] tA = Arrays.copyOf(A, nA);

        int aIdx = 0;
        int bIdx = 0;

        int eIdx = 0;
        while (aIdx < nA && bIdx < nB){
            if(tA[aIdx] < B[bIdx]){
                A[eIdx] = tA[aIdx];
                aIdx++;
            }else{
                A[eIdx] = B[bIdx];
                bIdx++;
            }
            eIdx++;
        }

        while (aIdx < nA) A[eIdx++] = tA[aIdx++];
        while (bIdx < nB) A[eIdx++] = B[bIdx++];
    }

    // Most Optimal One
    // O(n) and O(n) Space.
    private static void mergeTwoSortedArrayIntoA(int[] A, int nA, int[] B, int nB){
        // Shift Array in A to End i.e. by (A.length - x)

        int offset = nA - 1;

        // In theory, (A.length - nA) should be equal to nB.
        if((A.length - nA) != nB) throw new RuntimeException("Invalid Scenario");

        // Move Elements by Offset
        int endIdx = A.length - 1;
        while(offset >= 0 && endIdx > offset){
            // No need to swap, we can just replace the value
            A[endIdx] = A[offset]; offset--; endIdx--;
        }

        // Since, Array is Shifted by Offset
        // Start resultIdx from 0, and CompareIdx from (A.length - x) at A and 0 at B.
        int aIdx = nB;
        int bIdx = 0;

        int rElIdx = 0;
        while(aIdx < A.length && bIdx < B.length){
            if(A[aIdx] < B[bIdx]){
                A[rElIdx] = A[aIdx++];
            }else{
                A[rElIdx] = B[bIdx++];
            }
            rElIdx++;
        }

        while(aIdx < A.length) A[rElIdx++] = A[aIdx++];
        while(bIdx < B.length) A[rElIdx++] = B[bIdx++];
    }
}
