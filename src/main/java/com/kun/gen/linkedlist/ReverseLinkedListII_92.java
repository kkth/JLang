package com.kun.gen.linkedlist;

import com.kun.gen.utils.LinkedListUtil;
import com.kun.gen.utils.ListNode;

public class ReverseLinkedListII_92 {
    public static void main(String[] args) {
        ReverseLinkedListII_92 reverseLinkedListII92 = new ReverseLinkedListII_92();
        ListNode head = LinkedListUtil.generate(new int[]{1,2,3,4,5});
        LinkedListUtil.printList(head);
        ListNode newList = reverseLinkedListII92.reverseBetween(head,2,4);
        LinkedListUtil.printList(newList);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode leftJoint = dummyHead;
        ListNode subHead = head;
        while(subHead.val != left){
            subHead = subHead.next;
            leftJoint = leftJoint.next;
        }

        ListNode prev = null;
        ListNode cur = subHead;
        while(cur != null){
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;

            if(prev.val == right){
               break;
            }
        }

        leftJoint.next = prev;
        subHead.next = cur;

        return dummyHead.next;
    }

}
