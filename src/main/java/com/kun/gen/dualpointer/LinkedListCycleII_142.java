package com.kun.gen.dualpointer;

import com.kun.gen.utils.LinkedListUtil;
import com.kun.gen.utils.ListNode;

public class LinkedListCycleII_142 {
    public static void main(String[] args) {
        LinkedListCycleII_142 linkedListCycleII142 = new LinkedListCycleII_142();
        ListNode head1 = LinkedListUtil.generate(new int[]{3,2,0,-4});
        LinkedListUtil.printList(head1);
        ListNode node = linkedListCycleII142.detectCycle(head1);
        if(node == null){
            System.out.println("No cycle");
        }else{
           System.out.println(node.val);
        }


        ListNode head2 = LinkedListUtil.generate(new int[]{3,2,0,-4});
        head2.next.next.next.next = head2.next;
        LinkedListUtil.printList(head2);
        node = linkedListCycleII142.detectCycle(head2);
        if(node == null){
            System.out.println("No cycle");
        }else{
            System.out.println(node.val);
        }

    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = head;
                int index = 0;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                    index++;
                }
                System.out.println("Index = " + index);
                return fast;
            }
        }

        return null;
    }
}
