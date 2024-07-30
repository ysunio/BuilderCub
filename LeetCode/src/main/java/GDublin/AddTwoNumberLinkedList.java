package GDublin;

import GDublin.common.ListNode;

class AddTwoNumberLinkedList {

    private int getNodeValue(ListNode node) {
        return node != null ? node.val : 0;
    }

    private ListNode getNodeNode(ListNode node) {
        return node != null ? node.next : null;
    }

    /**
     * https://leetcode.com/problems/add-two-numbers/
     * @param L1 : First ListNode
     * @param L2 : Second List Node
     * @return ListNode, representing Sum of L1 and L2.
     */
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode rootNode = new ListNode(-1); // Actual Node, to be Returned
        ListNode holderNode = rootNode; // Temporary Node, to Build Root

        int carry = 0;

        // Iterate to Add with Carry
        while (L1 != null || L2 != null) {
            int sum = getNodeValue(L1) + getNodeValue(L2) + carry;
            carry = 0; // Carry CleanUp, since it's added to Sum.
            if (sum >= 10) {
                carry = sum / 10; // Face Digit to Carry
                sum %= 10; // Last Digit in Sum
            }
            holderNode.next = new ListNode(sum); // Making new Node with Sum Value in Chain
            holderNode = holderNode.next;
            L1 = getNodeNode(L1); L2 = getNodeNode(L2); // Reassigning L1 and L2, based on NextNode
        }

        // Check, if there still value of Carry left.
        if (carry != 0) holderNode.next = new ListNode(carry);

        // Return 2nd Element of Root, since first is -1, as Temporary;
        return rootNode.next;
    }
}
