package Archieve.GDub.common;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode nodeGenerator(List<Integer> numbers){
        ListNode r = new ListNode(-1);
        ListNode t = r;
        for(int n : numbers){
            t.next = new ListNode(n);
            t = t.next;
        }
        return r.next;
    }

    public static int sumOfNodes(ListNode root){
        int sum = 0;
        while(root != null){
            sum += root.val;
            root = root.next;
        }
        return sum;
    }
}