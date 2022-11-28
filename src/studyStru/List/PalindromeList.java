package studyStru.List;

import pojo.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 */
public class PalindromeList {

    /**
     * 使用递归来实现
     */
    static ListNode temp;
    public static boolean isPalindrome(ListNode head) {
        temp = head;
        return check(head);
    }

    public static boolean check(ListNode head){
        if(head == null)
            return true;
        boolean res = check(head.next) && (head.val == temp.val);
        temp = temp.next;
        return res;
    }

    /**
     * 使用反转链表来实现
     */
    public static boolean isPalindrome2(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head, slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {

            fast = fast.next.next;

            ListNode cur = slow;
            slow = slow.next;
            cur.next = pre;
            pre = cur;
        }
        if (fast != null){
            slow = slow.next;
        }
        while (pre != null && slow != null){

            if(pre.val != slow.val)
                return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(head,1);
        head.addNode(head,2);
        head.addNode(head,1);
        head.addNode(head,2);
        head.addNode(head,2);
        System.out.println(isPalindrome2(head));
    }

}
