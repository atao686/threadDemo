package com.atao.algorithm;

/**
 * @Description
 * @Author atao
 * @Date 2022/10/30
 */
public class KthFromTail_Offer22 {

    public static ListNode kthNodeFromEnd(ListNode head , int kthNode){
        if ( kthNode <= 0 || head == null) return null;
        ListNode pTemp = head, pKthNode = null;
        /*pTemp(沿着链表)移动了k-1次*/
        for(int count =1; count< kthNode;count++) {
            if (pTemp != null)
                pTemp = pTemp.next;
        }

        while(pTemp != null) {
            if (pKthNode == null)
                pKthNode = head;
            else
                pKthNode = pKthNode.next;
            pTemp = pTemp.next;
        }
        if(pKthNode != null)
            return pKthNode;
        return null;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(6);
        test.setNext(new ListNode(0))
                .setNext(new ListNode(11))
                .setNext(new ListNode(8))
                .setNext(new ListNode(9))
                .setNext(new ListNode(5))
                .setNext(new ListNode(4))
                .setNext(new ListNode(1));
        System.out.println(kthNodeFromEnd(test,11));

    }

}
