package _150_Most_Liked;

public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        int storeIdx = m;
        int aIdx = 0, bIdx = 0;

        while (aIdx < m && bIdx < n) {
            storeIdx = storeIdx >= A.length ? 0 : storeIdx;
            A[storeIdx++] = A[aIdx] < B[bIdx] ? A[aIdx++] : B[bIdx++];
        }
        while (aIdx < m) {
            storeIdx = storeIdx >= A.length ? 0 : storeIdx;
            A[storeIdx++] = A[aIdx++];
        }

        while (bIdx < n) {
            storeIdx = storeIdx >= A.length ? 0 : storeIdx;
            A[storeIdx++] = B[bIdx++];
        }

        int startIdx = 0;
        int endIdx = m - 1;
        while (startIdx < endIdx) {
            int sValue = A[startIdx];
            A[startIdx] = A[endIdx];
            A[endIdx] = sValue;
            startIdx++;
            endIdx--;
        }

        startIdx = m;
        endIdx = A.length - 1;
        while (startIdx < endIdx) {
            int sValue = A[startIdx];
            A[startIdx] = A[endIdx];
            A[endIdx] = sValue;
            startIdx++;
            endIdx--;
        }

        startIdx = 0;
        endIdx = A.length - 1;
        while (startIdx < endIdx) {
            int sValue = A[startIdx];
            A[startIdx++] = A[endIdx];
            A[endIdx--] = sValue;
        }
    }

    public void mergeWithMemory(int[] A, int m, int[] B, int n) {

        int[] res = new int[m + n];

        int idx = 0;

        int aIdx = 0, bIdx = 0;

        while (aIdx < m && bIdx < n) {
            res[idx++] = A[aIdx] < B[bIdx] ? A[aIdx++] : B[bIdx++];
        }
        while (aIdx < m) {
            res[idx++] = A[aIdx++];
        }
        while (bIdx < n) {
            res[idx++] = B[bIdx++];
        }

        System.arraycopy(res, 0, A, 0, A.length);
    }
}
