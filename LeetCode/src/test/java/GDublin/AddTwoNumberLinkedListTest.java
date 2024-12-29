package GDublin;
import GDublin._2025.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AddTwoNumberLinkedListTest {

    @Test
    void addTwoNumbers() {
        // Access
        ListNode x = ListNode.nodeGenerator(List.of(1,2,3));
        ListNode y = ListNode.nodeGenerator(List.of(1,2,3));

        // Act
        AddTwoNumberLinkedList addTwoNumberLinkedList = new AddTwoNumberLinkedList();
        ListNode sumOfList = addTwoNumberLinkedList.addTwoNumbers(x, y);

        // Assert
        Assertions.assertEquals(ListNode.sumOfNodes(sumOfList), 2 + 4 + 6);
    }
}