package Archieve._75.easy;

import Archieve._75.easy.ReverseList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseListTest {

    @Test
    void reverseList() {
        ReverseList.ListNode head = new ReverseList.ListNode(10);
        head.next = new ReverseList.ListNode(20);
        head.next.next = new ReverseList.ListNode(30);
        head.next.next.next = new ReverseList.ListNode(40);

        ReverseList.ListNode reverseList = new ReverseList().reverseList(head);

        List<Integer> nodeListArray = new ArrayList<>();
        while (reverseList != null) {
            nodeListArray.add(reverseList.val);
            reverseList = reverseList.next;
        }

        assertArrayEquals(new Integer[]{40, 30, 20, 10}, nodeListArray.toArray());
    }
}