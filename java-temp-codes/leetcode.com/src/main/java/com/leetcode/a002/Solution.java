package com.leetcode.a002;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, r;
        int len1 = 0, len2=0;

        while(p1.next!=null) {
            len1++;
            p1 = p1.next;
        }
        while(p2.next!=null) {
            len2++;
            p2 = p2.next;
        }
        int skipStep = len1>len2? len1-len2: len2-len1;
        int skipCount = 0;
        if(len1>len2) {
            r = l1;
            p1 = l1;
            while(skipCount<=skipCount) {
                p1 = p1.next;
                skipCount++;
            }
        } else if(len1<len2) {
            r = l2;
            p2 = l2;
            while(skipCount<=skipCount) {
                p2 = p2.next;
                skipCount++;
            }
        }


        return null;
    }

//    private int getIntFromList(ListNode list) {
//        StringBuilder str = new StringBuilder();
//        List<Integer> intList = new LinkedList<>();
//        while(list.next!=null) {
//            intList.add(list.val);
//            list = list.next;
//        }
//        for(int i=intList.size()-1; i>=0; i--) {
//            str.append(intList.get(i));
//        }
//        return Integer.valueOf(str.toString()).intValue();
//    }
}
