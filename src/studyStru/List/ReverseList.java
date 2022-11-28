package studyStru.List;

import pojo.ListNode;

import java.util.Stack;

/**
 *
 */
public class ReverseList {

    public static ListNode reverseStack(ListNode head,int k){
        //判断头结点是否为null
        if(head == null || head.next == null || k == 0)
            return head;
        //判断
        //创建指针指向头结点
        //创建一个指针用于遍历链表
        ListNode later = head;
        //创建一个栈用于逆序实现
        Stack<ListNode> stack = new Stack<>();
        //遍历链表
        for(int i = 0;i<k;i++){
            //如果元素不够k个
            if(later == null){
                stack.clear();
                return head;
            }
            stack.push(later);
            later = later.next;
        }
        ListNode newHead = stack.peek();
        ListNode next = stack.pop();

        while (!stack.isEmpty()){
            next.next = stack.pop();
            next = next.next;
        }

        next.next = reverseStack(later,k);


        return newHead;

    }

    public static ListNode reverseNode(Stack<ListNode> stack,ListNode head,int k){
        if(stack.isEmpty())
            return head;
        ListNode later = stack.peek().next;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            if(head != null){
                head.next = node;
            }
            head = node;
        }
        head.next = later;
        return head;
    }

    public static ListNode reverse(ListNode head , int k){
        if(head == null || head.next == null){
            return head;
        }
        //创建一个节点指向当前头结点
        ListNode cur = head;
        //判断当前链表长度是否小于k
        for(int i = 0;i<k;i++){
            //若小于，直接返回
            if(cur == null){
                return head;
            }
            cur = cur.next;
        }
        //将链表分为两个部分，逆转部分、等待处理部分；创建指针temp指向后续链表
        //对逆转部分进行逆转
        ListNode newHead = reverseNode(head,cur);
        //递归处理剩余部分
        head.next = reverse(cur,k);

        return newHead;
    }

    private static ListNode reverseNode(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public static ListNode reverse(ListNode head, ListNode tail){
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
        head.addNode(head,6);
        head.addNode(head,5);
        head.addNode(head,4);
        head.addNode(head,3);
        head.addNode(head,2);
        print(head);

        head = reverse(head,head.getTail(head).next);
        print(head);

    }


}
