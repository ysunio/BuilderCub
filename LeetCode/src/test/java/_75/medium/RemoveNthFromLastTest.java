package _75.medium;

import Archieve._75.medium.RemoveNthFromLast;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthFromLastTest {

    @Test
    void removeNthFromEnd() {
        RemoveNthFromLast removeNthFromLast = new RemoveNthFromLast();
        RemoveNthFromLast.ListNode head = new RemoveNthFromLast.ListNode(10);
        head.next = new RemoveNthFromLast.ListNode(20);
        head.next.next = new RemoveNthFromLast.ListNode(30);
        head.next.next.next = new RemoveNthFromLast.ListNode(40);

        RemoveNthFromLast.ListNode actualNode = removeNthFromLast.removeNthFromEnd(head, 2);

        List<Integer> r = new ArrayList<>();
        while (actualNode != null) {
            r.add(actualNode.val);
            actualNode = actualNode.next;
        }

        assertArrayEquals(List.of(10, 20, 40).toArray(), r.toArray());
    }
}