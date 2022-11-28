package studyStru;

import pojo.ListNode;

import java.util.Stack;

public class Demo {
    static int num;

    public static void setnum(int a){
        num = a;
    }

    public static void print(){
        System.out.println(num);
    }
    public static ListNode middleNode(ListNode head) {
        if(head.next == null)
            return head;
        int length = 1;
        ListNode pre = head;
        while(pre.next != null){
            pre = pre.next;
            length ++;
        }
        int mid = length/2+1;
        System.out.println(length);
        pre = head;
        for(int i = 1; i<mid ;i++){
            pre = pre.next;
        }

        return pre;

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<0)
            return head;
        if(head.next == null)
            return null;
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        while(fast != null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return dummy.next;

    }
    public static void print(ListNode head){
        ListNode pre = head;
        System.out.println("list: ");
        while (pre != null){
            System.out.print(pre.val+ " -> ");
            pre = pre.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//
//        head.addNode(head,5);
//        head.addNode(head,4);
//        head.addNode(head,3);
//        head.addNode(head,2);
//        head = removeNthFromEnd(head,2);
//        print(head);
    }
}
