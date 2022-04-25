package questions.leetcode;

import questions.leetcode.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        int carry = 0;
        while(l1.next!=null || l2.next!=null || carry!=0){
         int val1 = 0;
         if(l1 != null){
             val1 = l1.value;
             l1 = l1.next;
         }
         int val2 = 0;
         if(l2!=null){
             val2 = l2.value;
             l2 = l2.next;
         }
         int sumVal = val1+val2+carry;
         carry = sumVal/10;
         ListNode n = new ListNode(sumVal%10);
         if(sum == null){
             sum = n;
         }else {
             sum.next = n;
             sum = n;
         }
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}

