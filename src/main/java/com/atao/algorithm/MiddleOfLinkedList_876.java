package com.atao.algorithm;

/**
 * @Description
 * @Author atao
 */
public class MiddleOfLinkedList_876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }

}
