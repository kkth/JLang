package com.kun.oct;

import com.kun.ListNode;

import java.util.List;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createByArray(new int[]{2,4,3});
        ListNode l2 = ListNode.createByArray(new int[]{5,6,4});
        AddTwoNumbers_2 addTwoNumbers2 = new AddTwoNumbers_2();

        System.out.println(ListNode.pretty(l1));
        System.out.println(ListNode.pretty(l2));
        System.out.println(ListNode.pretty(addTwoNumbers2.addTwoNumbers(l1,l2)));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);//dummy head
        ListNode resultTail = result;
        int carry = 0;
        while(l1 != null || l2 !=null){
            int curSum = 0;
            if(l1 !=null && l2 != null) {
                curSum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
               curSum = l1.val;
               l1 = l1.next;
            }else{
                curSum = l2.val;
                l2 = l2.next;
            }

            curSum += carry;

            if(curSum >=10){
                curSum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }

            resultTail.next = new ListNode(curSum);
            resultTail = resultTail.next;
        }

        if(carry != 0){
           resultTail.next = new ListNode(carry);
           resultTail = resultTail.next;
        }

        return result.next;
    }
}
