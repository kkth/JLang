package com.kun.gen.utils;

import java.util.HashSet;
import java.util.Set;

public class LinkedListUtil {
    public static ListNode generate(int[] nums){
        if(nums == null){
            return null;
        }

        ListNode head = new ListNode(nums[0]);

        ListNode prev = head;
        for(int i = 1;i<nums.length;i++){
           ListNode cur = new ListNode(nums[i]);
           prev.next = cur;
           prev = cur;
        }

        return head;
    }

    // Method to print the list in the desired format
    public static void printList(ListNode head) {
        Set<ListNode> used = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            used.add(current);
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            if(used.contains(current.next)){
                System.out.println(current.next.val);
                System.out.print("Cycle found here.");
                break;
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: creating a list with 3 nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        // Printing the list
        LinkedListUtil.printList(node1);
    }
}
