package Archieve.Problems.medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2).display();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void display(){
            System.out.print(this.val+" > ");
            if(this.next != null)
                this.next.display();
        }

    }


//    Time - O(Max(N,M))
//    Space - O(Max(N,M))
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rNode = new ListNode(-1);
        ListNode iNode = rNode;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int totalSum = l1.val + l2.val + carry;
            int nodeValue = totalSum % 10;
            iNode.next = new ListNode(nodeValue);
            carry = totalSum / 10;
            l1 = l1.next;
            l2 = l2.next;
            iNode = iNode.next;
        }

        while (l1 != null) {
            int totalSum = l1.val + carry;
            int nodeValue = totalSum % 10;
            iNode.next = new ListNode(nodeValue);
            carry = totalSum / 10;
            l1 = l1.next;
            iNode = iNode.next;
        }

        while (l2 != null) {
            int totalSum = l2.val + carry;
            int nodeValue = totalSum % 10;
            iNode.next = new ListNode(nodeValue);
            carry = totalSum / 10;
            l2 = l2.next;
            iNode = iNode.next;
        }

        if (carry != 0) iNode.next = new ListNode(carry);

        return rNode.next;
    }
}
