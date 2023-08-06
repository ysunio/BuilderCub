package One;

public class MergeTwoSortedArray {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode r = null;
        if(list1.val < list2.val) {r = list1; list1 = list1.next;} else {r = list2;  list2 = list2.next;}
        ListNode rH = r;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                r.next = list1;
                list1 = list1.next;
                // r.next.next = null;
                r = r.next;
            }else{
                r.next = list2;
                list2 = list2.next;
                // r.next.next = null;
                r = r.next;
            }
        }

        if(list1 != null) r.next = list1;
        if(list2 != null) r.next = list2;

        return rH;
    }
}
