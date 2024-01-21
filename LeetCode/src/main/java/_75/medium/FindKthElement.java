package _75.medium;

import java.util.PriorityQueue;

public class FindKthElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(k, (a, b) -> a - b);

        for (int el : nums) {
            pQ.add(el);
            if (pQ.size() > k) pQ.poll();
        }

        return pQ.peek();
    }
}
