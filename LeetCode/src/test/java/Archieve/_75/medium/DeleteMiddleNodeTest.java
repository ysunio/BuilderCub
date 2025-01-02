package Archieve._75.medium;

import Archieve._75.medium.DeleteMiddleNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteMiddleNodeTest {

    @Test
    void deleteMiddle() {
        DeleteMiddleNode.ListNode head = new DeleteMiddleNode.ListNode(10);
        head.next = new DeleteMiddleNode.ListNode(20);
        head.next.next = new DeleteMiddleNode.ListNode(30);
        head.next.next.next = new DeleteMiddleNode.ListNode(40);
        head.next.next.next.next = new DeleteMiddleNode.ListNode(50);

        DeleteMiddleNode.ListNode deleteMiddle = new DeleteMiddleNode().deleteMiddle(head);

        List<Integer> nodeListArray = new ArrayList<>();
        while (deleteMiddle != null) {
            nodeListArray.add(deleteMiddle.val);
            deleteMiddle = deleteMiddle.next;
        }

        assertArrayEquals(new Integer[]{10, 20, 40, 50}, nodeListArray.toArray());
    }
}