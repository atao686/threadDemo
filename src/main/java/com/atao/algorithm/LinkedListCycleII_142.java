package com.atao.algorithm;

/**
 * @Description
 * @Author atao
 */
public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null)  return null;
        ListNode slowPtr = head, fastPtr = head;
        boolean loopExists = false;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                loopExists = true;
                break;
            }
        }
        if(loopExists) {//环存在
            slowPtr = head;
            while (slowPtr != fastPtr) {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
            return slowPtr;//返回环的开始结点
        }
        return null; //环不存在
    }

}
