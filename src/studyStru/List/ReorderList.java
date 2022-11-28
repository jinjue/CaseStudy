package studyStru.List;

import pojo.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class ReorderList {

    public void reorder(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode tail = head;
        while (tail.next != null)
            tail = tail.next;
        reorderNote(head,tail);
    }

    public static void reorderNote(ListNode head,ListNode tail){
        if(head.next == tail)
            return ;
        //获取tail的前节点
        ListNode pre = head;
        while (pre.next != tail)
            pre = pre.next;
        //将尾节点插入到head之后
        pre.next = tail.next;
        tail.next = head.next;
        head.next = tail;
        reorderNote(tail.next,pre);
    }
}
