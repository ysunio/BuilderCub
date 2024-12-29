package Archieve.Problems.medium;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 4, 5, 6}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums) queue.add(x);
        int val = -1;
        for (int idx = 0; idx < k; idx++)
            val = queue.remove();
        return val;
    }
}
