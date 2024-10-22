package com.kun.oct;

import com.kun.ListNode;
import com.kun.RemoveDup_82;

import java.util.List;

public class RotateList_61 {
    public static void main(String[] args) {
        RotateList_61 rotateList61 = new RotateList_61();

        ListNode head = ListNode.createByArray(new int[]{1,2,3,4,5});
        System.out.println(ListNode.pretty(head));
        System.out.println(ListNode.pretty(rotateList61.rotateRight(head,2)));

        head = ListNode.createByArray(new int[]{0,1,2});
        System.out.println(ListNode.pretty(head));
        System.out.println(ListNode.pretty(rotateList61.rotateRight(head,4)));

        head = ListNode.createByArray(new int[]{2});
        System.out.println(ListNode.pretty(head));
        System.out.println(ListNode.pretty(rotateList61.rotateRight(head,100)));


    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return  head;
        int nodeCount = 0;
        ListNode originalHead = head;
        ListNode cur = head;
        while(cur.next != null){
           nodeCount++;
           cur = cur.next;
        }
        nodeCount++;

        ListNode originalTail = cur;

        //Connect the tail to head to get loop linked list
        cur.next = head;

        int moveSteps = nodeCount - k%nodeCount;

        for(int i = 0;i<moveSteps;i++){
            originalHead = originalHead.next;
            originalTail = originalTail.next;
        }

        //Un-loop the linked list
        originalTail.next = null;

        return originalHead;
    }
}
