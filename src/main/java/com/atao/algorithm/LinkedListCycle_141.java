package com.atao.algorithm;

/**
 * @Description
 * @Author atao
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null)  return false;
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

}
