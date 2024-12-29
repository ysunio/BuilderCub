package Archieve.Problems.medium;

public class KthFrequentElement {
    public static void main(String[] args) {
        for (int x : topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, 3)) {
            System.out.println(x);
        }
    }


//        O(K)
    static int[] topKFrequent(int[] nums, int k) {

        int[] frequency = new int[20002];
        for (int num : nums) {
            if (num < 0) frequency[10001 + Math.abs(num)]++;
            else frequency[num]++;
        }

        int resIdx = 0;
        int[] res = new int[k];
        for (int idx = 0; idx < k; idx++) {
            int maxIdx = 0;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[maxIdx] < frequency[i])
                    maxIdx = i;
            }

            res[resIdx++] = maxIdx > 10001 ? 10001 - maxIdx : maxIdx;
            frequency[maxIdx] = 0;
        }

        return res;
    }
}
