package studyStru;

import pojo.ListNode;

/**
 * 使用链表实现一个先入先出的队列
 */
public class MyQueue_List {

    public static boolean isEmpty(ListNode head){
        if(head.next == null)
            return true;
        return false;
    }

    public static ListNode popQueue(ListNode head,int data){
        ListNode node = new ListNode(data);
        node.next = head.next;
        head.next = node;
        return head;
    }

    public static ListNode pushQueue(ListNode head){
        if(isEmpty(head))
            return null;

        ListNode pre = head.next;
        while (pre.next.next !=null){
            pre = pre.next;
        }
        ListNode node = pre.next;
        pre.next = null;

        return node;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = popQueue(head,1);
        head = popQueue(head,2);
        head = popQueue(head,3);
        head = popQueue(head,4);
        System.out.println(pushQueue(head).val);
        System.out.println(pushQueue(head).val);

    }

}
