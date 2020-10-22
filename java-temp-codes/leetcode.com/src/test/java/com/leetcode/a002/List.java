package com.leetcode.a002;

public class List {
    public static ListNode createList(int[] nums) {
        ListNode head = null;
        ListNode tail = null;
        for(int i = 0; i<nums.length; i++ ) {
            ListNode item = new ListNode(nums[i]);
            if(head==null) {
                head = item;
            }
            if(tail!=null) {
                tail.next = item;
            }
            tail = item;

        }
        return head;
    }

    public static void printList(ListNode list) {
        ListNode pit = list;
        StringBuilder msg = new StringBuilder();
        while(pit.next != null) {
            msg.append(pit.val).append(", ");
            pit = pit.next;
        }
        System.out.println(msg);
     }
}
