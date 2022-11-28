package studyStru.List;

import pojo.ListNode;


public class IntersectList {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
     * 如果两个链表不存在相交节点，返回 null 。
     */
    public static ListNode getInterNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        ListNode preA = headA;
        ListNode preB = headB;
        //pre用于遍历A、B节点
        while (true) {
            if (preA == preB)
                return preA;
            if (preA == null)
                preA = headB;
            else
                preA = preA.next;
            if (preB == null)
                preB = headA;
            else
                preB = preB.next;
        }

    }

    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     */
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast.next.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }


}
