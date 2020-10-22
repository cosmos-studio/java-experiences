package com.leetcode.a002;

import org.junit.Test;

public class TestSolution {

    @Test
    public void testList() {
        int[] listnum1 = {1, 2, 3, 4, 5, 6};
        int[] listnum2 = {1, 6, 8, 12, 16, 17};
        ListNode list1 = List.createList(listnum1);
        List.printList(list1);
        ListNode list2 = List.createList(listnum2);
        List.printList(list2);
    }
}
