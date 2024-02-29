package com.kun;

import java.util.List;
import java.util.Stack;

public class RemoveDup_82 {

    public static void main(String[] args) {
        RemoveDup_82 removeDup82 = new RemoveDup_82();

        ListNode head = ListNode.createByArray(new int[]{1,2,3,3,4,4,5});
        System.out.println(ListNode.pretty(head));

        ListNode newHead = removeDup82.deleteDuplicates(head);
        System.out.println(ListNode.pretty(newHead));

        head = ListNode.createByArray(new int[]{1,1,1,2,3});
        System.out.println(ListNode.pretty(head));

        newHead = removeDup82.deleteDuplicates(head);
        System.out.println(ListNode.pretty(newHead));

        head = ListNode.createByArray(new int[]{1,2,2});
        System.out.println(ListNode.pretty(head));

        newHead = removeDup82.deleteDuplicates(head);
        System.out.println(ListNode.pretty(newHead));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode pending = head;
        ListNode tail = null;
        ListNode newHead = null;

        cur = cur.next;
        int dupCount = 0;
        while(cur != null) {
            if(cur.val == pending.val){
                dupCount++;
            }else{
                if(dupCount == 0){
                    tail = pending;
                    if(newHead == null){
                        newHead = tail;
                    }
                }else{
                    if(tail != null) {
                        tail.next = cur;
                    }
                }
                pending = cur;
                dupCount = 0;
            }
            cur = cur.next;
        }

        if(dupCount!=0){
            tail.next = null;
        }

        return newHead;
    }
}
