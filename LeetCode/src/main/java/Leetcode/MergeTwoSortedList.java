package Leetcode;

public class MergeTwoSortedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void display() {
            System.out.print(this.val + " ");
            if (this.next == null) return;
            this.next.display();
        }
    }

    public static void main(String[] args) {
        ListNode listOneNode = new ListNode(1);
        listOneNode.next = new ListNode(2);
        listOneNode.next.next = new ListNode(3);
        listOneNode.next.next.next = new ListNode(4);
        listOneNode.next.next.next.next = new ListNode(5);

        ListNode listTwoNode = new ListNode(1);
        listTwoNode.next = new ListNode(2);
        listTwoNode.next.next = new ListNode(3);
        listTwoNode.next.next.next = new ListNode(4);
        listTwoNode.next.next.next.next = new ListNode(5);

        mergeTwoLists(listOneNode, listTwoNode).display();
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode rNode = new ListNode(-1);
        ListNode tNode = rNode;

        while (list1 != null || list2 != null) {

            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tNode.next = list1;
                    list1 = list1.next;
                } else {
                    tNode.next = list2;
                    list2 = list2.next;
                }
                tNode.next.next = null;
            } else {
                tNode.next = list1 == null ? list2 : list1;
                break;
            }
            tNode = tNode.next;
        }

        return rNode.next;
    }
}
