package com.kun.gen.linkedlist;

import com.kun.gen.utils.LinkedListUtil;
import com.kun.gen.utils.ListNode;

import java.util.List;

public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        ReverseLinkedList_206 reverseLinkedList206 = new ReverseLinkedList_206();

        ListNode head = LinkedListUtil.generate(new int[]{1,2,3,4});
        LinkedListUtil.printList(head);
        ListNode newHead = reverseLinkedList206.reverseList(head);
        LinkedListUtil.printList(newHead);

    }

    public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;

    }
    public ListNode reverseList_too_complex(ListNode head) {
        if(head == null)
            return null;

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = null;
        if(cur !=null) {
            next = cur.next;
        }
        prev.next = null;

        while(cur != null){
            cur.next = prev;

            prev = cur;
            cur = next;
            next = cur.next;
            if(next == null){
                cur.next = prev;
                break;
            }
        }

        return cur;
    }
}
