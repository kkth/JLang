package com.kun.gen.dualpointer;
import com.kun.gen.utils.LinkedListUtil;
import com.kun.gen.utils.ListNode;

import java.util.List;

public class LinkedListCycle_141 {

    public static void main(String[] args) {
        LinkedListCycle_141 linkedListCycle141 = new LinkedListCycle_141();

        ListNode head1 = LinkedListUtil.generate(new int[]{3,2,0,-4});
        LinkedListUtil.printList(head1);
        System.out.println(linkedListCycle141.hasCycle(head1));


        ListNode head2 = LinkedListUtil.generate(new int[]{3,2,0,-4});
        head2.next.next.next.next = head2.next;
        LinkedListUtil.printList(head2);
        System.out.println(linkedListCycle141.hasCycle(head2));

    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
               return true;
           }
        }
        return false;
    }
}
