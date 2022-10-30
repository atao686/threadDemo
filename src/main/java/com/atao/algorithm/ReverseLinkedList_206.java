package com.atao.algorithm;

/**
 * @Description
 * @Author atao
 * @Date 2022/10/30
 */
public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while(currNode != null){
            /*因为下面要把currNode的next改为指向preNode
             * 为了不丢失本来的结点指向，所以所以需要事先保存一下*/
            ListNode next = currNode.next;
            currNode.next = preNode;
            /*移动双指针*/
            preNode = currNode;
            currNode = next;
        }
        return preNode;
    }

}
