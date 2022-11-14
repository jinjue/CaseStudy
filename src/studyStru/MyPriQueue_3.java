package studyStru;

import pojo.ListNode;

/**
 * 使用链表实现优先队列
 */
public class MyPriQueue_3 {


    /**
     * 对使用链表实现的优先进行入队操作
     * @param head
     * @param data
     * @return
     */

    public static ListNode popQueue(ListNode head, int data){
        //获取头结点
        ListNode pre = head;
        //从头结点向后遍历
        while ( pre.next != null){
            //若小于，则在当前节点前插入
            if(pre.next.val < data) break;
            //若当前节点值大于插入节点的值，继续向后遍历
            else {
                pre = pre.next;
            }
        }
        //构建插入节点
        ListNode point = new ListNode(data,pre.next);
        pre.next = point;

        //返回
        return head;
    }

    /**
     * 对使用链表实现的优先进行出队操作
     * @param head
     * @return
     */
    public static ListNode pushQueue(ListNode head){
        //判断链表是否为空
        if(head.next == null) return null;
        //移除head节点之后的节点
        ListNode pre = head.next;
        head.next = pre.next;
        //将该节点和链表断开
        pre.next = null;
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = popQueue(head,8);
        head = popQueue(head,2);
        head = popQueue(head,5);
        head = popQueue(head,6);
        head = popQueue(head,4);

        System.out.println(pushQueue(head).val);
        System.out.println(pushQueue(head).val);
        System.out.println(pushQueue(head).val);
    }

}
