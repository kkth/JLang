package com.kun;
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public static ListNode createByArray(int[] arr){
            if(arr == null)
                  return null;
            ListNode head = new ListNode(arr[0]);
            ListNode prev = head;
            for(int i = 1;i<arr.length;i++) {
                  ListNode node = new ListNode(arr[i]);
                  prev.next = node;
                  prev = node;
            }

            return head;
      }

      public static String pretty(ListNode head){
            StringBuilder sb = new StringBuilder();
            ListNode node = head;
            while (node != null){
                 sb.append(node.val);
                 if(node.next != null){
                       sb.append("->");
                 }
                 node = node.next;
            }
            return sb.toString();
      }
  }
