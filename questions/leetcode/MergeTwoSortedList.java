package questions.leetcode;

// 21. Merge Two Sorted Lists
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode head = res;
        while(list1!=null && list2!=null){
            ListNode node = null;
            if(list1.value < list2.value){
                node = new ListNode(list1.value);
                list1 = list1.next;
            }
            else {
                node = new ListNode(list2.value);
                list2 = list2.next;
            }
            res.next = node;
            res = node;
        }
        while(list1!=null){
            ListNode node = new ListNode(list1.value);
            res.next = node;
            res = node;
            list1 = list1.next;
        }
        while(list2!=null){
            ListNode node = new ListNode(list2.value);
            res.next = node;
            res = node;
            list2 = list2.next;
        }
        return head.next;
   }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(32);
        list1.next.next.next = new ListNode(44);
        list1.next.next.next.next = new ListNode(54);
        list1.next.next.next.next.next = new ListNode(61);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(7);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(20);
        list2.next.next.next.next.next = new ListNode(45);

            MergeTwoSortedList list = new MergeTwoSortedList();
        list2 =  list.mergeTwoLists(list1,list2);
        while (list2!=null){
            System.out.println(list2.value);
            list2 = list2.next;
        }

    }

}
