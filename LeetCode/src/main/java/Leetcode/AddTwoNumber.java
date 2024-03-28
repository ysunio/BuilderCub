package Leetcode;

public class AddTwoNumber {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void display(){
            System.out.print(this.val+" ");
            if(this.next == null) return;
            this.next.display();
        }
    }

    public static void main(String[] args) {
        ListNode listOneNode = new ListNode(9);
        listOneNode.next = new ListNode(2);
        listOneNode.next.next = new ListNode(3);
        listOneNode.next.next.next = new ListNode(4);
        listOneNode.next.next.next.next = new ListNode(5);

        ListNode listTwoNode = new ListNode(9);
        listTwoNode.next = new ListNode(2);
        listTwoNode.next.next = new ListNode(3);
        listTwoNode.next.next.next = new ListNode(4);
        listTwoNode.next.next.next.next = new ListNode(5);

        ListNode rNode = addTwoNumbers(listOneNode, listTwoNode);
        rNode.display();
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1); l2 = reverse(l2);
        ListNode rNode = new ListNode(-1);
        ListNode tNode = rNode;

        int carryOrder = 0;
        while (l1 != null || l2 != null) {
            int totalSum = carryOrder;
            if (l1 != null) totalSum += l1.val;
            if (l2 != null) totalSum += l2.val;

            tNode.next = new ListNode(totalSum % 10);
            carryOrder = totalSum / 10;
            tNode = tNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carryOrder != 0) tNode.next = new ListNode(carryOrder);

        return reverse(rNode.next);
    }

    private static ListNode reverse(ListNode l1) {
        ListNode pListNode = null;
        while(l1 != null){
            ListNode nextNode = l1.next;
            l1.next = pListNode;
            pListNode = l1;
            l1 = nextNode;
        }
        return pListNode;
    }
}
