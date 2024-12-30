package GDublin._2025._150_Interview;

import java.util.Arrays;

// https://leetcode.com/problems/remove-element
public class RemoveElement {

    public static void main(String[] args) {

        int[] A = new int[]{0,1,2,2,3,0,4,2};
        int valToRemove = 2;
        removeElement2(A, valToRemove);
        for(int x : A) System.out.print(x+" ");

        System.out.println();
        int[] A2 = new int[]{3,2,2,3};
        int valToRemove2 = 3;
        int endIdx = removeElement(A2, valToRemove2);
        for(int x = 0; x < endIdx; x++) System.out.print(A2[x]+" ");

    }

    // Most Optimal of All.
    private static int removeElement(int[] A, int valToRemove){
        int nonValIx = 0;
        for(int itrIdx = 0; itrIdx < A.length; itrIdx++){
            if(A[itrIdx] != valToRemove) A[nonValIx++] = A[itrIdx];
        }
        return nonValIx;
    }

    // Prime Idea to Come in Mind
    // O(N) and O(N)
    private static void removeElement2(int[] A, int valToRemove){
        int totalItemToRemove = 0;
        for(int num : A) if(num == valToRemove) totalItemToRemove++;

        int[] B = Arrays.copyOf(A, A.length);
        int eIdx = 0;

        // Adding only no el into RArray.
        for(int x : B){ if(x != valToRemove) A[eIdx++] = x; }
    }

    // Optimal One
    private static void removeElement3(int[] A, int valToRemove){
        // Iterating from Left and Right based on ValToRemove
        int leftIx = 0;
        int rightIx = A.length - 1;

        // Total Value to Remove
        int totalCount = 0;
        for(int x : A){ if(x == valToRemove) totalCount++; }

        while(leftIx < rightIx){
            // Finding Spot to Begin
            for(int idx = 0; idx < A.length; idx++) if(A[idx] == valToRemove) { leftIx = idx; break; }
            for(int idx = A.length - 1; idx >= 0; idx--) if(A[idx] != valToRemove) { rightIx = idx; break; }

            if(leftIx > rightIx) break;

            int swapHold = A[leftIx];
            A[leftIx] = A[rightIx];
            A[rightIx] = swapHold;

            leftIx++;
            rightIx--;
        }
    }
}
