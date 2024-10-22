package com.kun.oct;

import com.kun.ListNode;

import java.util.List;

public class SwapNodePairs_24 {
    public static void main(String[] args) {
        SwapNodePairs_24 swapNodePairs24 = new SwapNodePairs_24();

        ListNode head = ListNode.createByArray(new int[]{1,2,3,4});
        System.out.println(ListNode.pretty(head));
        System.out.println(ListNode.pretty(swapNodePairs24.swapPairs(head)));

        head = ListNode.createByArray(new int[]{1,2,3,4,5});
        System.out.println(ListNode.pretty(head));
        System.out.println(ListNode.pretty(swapNodePairs24.swapPairs(head)));

        head = ListNode.createByArray(new int[]{1});
        System.out.println(ListNode.pretty(head));
        System.out.println(ListNode.pretty(swapNodePairs24.swapPairs(head)));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        //Tail of previous nodes (finished processing)
        ListNode prev = dummyHead;
        //Head of nodes to be processed
        ListNode cur = head;
        //Head of nodes adjacent to current processing pair
        ListNode nextPair = null;

        while(cur != null){
            if(cur.next != null) {//Make sure we get the pair
                //Save the start of next pair
                nextPair = cur.next.next;

                //Get mark elements in current pair
                ListNode first = cur;
                ListNode second = cur.next;

                //Core of wave new linked list
                prev.next = second;
                second.next = first;
                first.next = nextPair;

                //Move pointer to mark the new prev and current
                prev = first;
                cur = first.next;

            }else{//Single (tail) element
                break;
            }
        }
        return dummyHead.next;
    }
}
