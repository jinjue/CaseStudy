package pojo;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {};
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode addNode(ListNode head,int data){
        ListNode node = new ListNode(data);
        node.next = head.next;
        head.next = node;
        return head;
    }
    public ListNode getTail(ListNode head){
        ListNode node = head;
        while (node.next != null)
            node = node.next;
        return node;
    }
}
