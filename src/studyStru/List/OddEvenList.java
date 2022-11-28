package studyStru.List;

import pojo.ListNode;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 */
public class OddEvenList {

    public static ListNode oddEven(ListNode head){
        if(head == null || head.next == null)
            return head;
        //设定指针mark指向奇数节点偶数节点的边界
        ListNode mark = head;
        //索引
        int i = 1;
        //创建node指针遍历链表
        ListNode pre = head;
        while (pre.next != null){
            i++;
            //若当前索引为奇数
            if(i%2 == 1 && mark != pre){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = mark.next;
                mark.next = temp;

                mark = mark.next;
                i --;
            }
            //若不是，则继续
            if(pre.next != null)
                pre = pre.next;
        }
        return head;
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
        ListNode head = new ListNode(2);
        head.addNode(head,7);
        head.addNode(head,4);
        head.addNode(head,6);
        head.addNode(head,5);
        head.addNode(head,3);
        head.addNode(head,1);
        print(head);
        head = oddEven(head);
        print(head);
    }

}
