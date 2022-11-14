package studyStru.sort;

import pojo.ListNode;

import java.util.Arrays;

/**
 * 快速排序的实现
 */
public class MyFastSort {

    /**
     * 使用数组实现
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int arrayFast(int[] nums,int start,int end){
        int point = nums[start];
        int low = start;
        int high = end;
        while (low!=high){
            while (low<high && nums[high] > point)
                high--;
            while (low<high && nums[low] <= point)
                low++;
            if(low<high ){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }
        nums[start] = nums[low];
        nums[low] = point;

        return low;
    }

    /**
     * 使用数组实现
     * @param nums
     * @param start
     * @param end
     */
    public static void arrayFastSort(int[] nums,int start,int end){
        if(start >= end){
            return ;
        }
        int point = arrayFast(nums,start,end);
        arrayFastSort(nums,start,point-1);
        arrayFastSort(nums,point+1,end);
    }

    public static ListNode listFast(ListNode head,ListNode tail){
        if(head == null || head.next == null)
            return null;
        ListNode mark = head , pre = head.next;
        int point = head.val;
        while (pre != tail.next){
            if(pre.val <= point){
                mark = mark.next;
                int temp = pre.val;
                pre.val = mark.val;
                mark.val = temp;
            }

            pre = pre.next;
        }

        head.val = mark.val;
        mark.val = point;
        return mark;
    }

    public static void listFastSort(ListNode head,ListNode tail){
        if(head==null||tail==null||head == tail){
            return;
        }
        ListNode mark = listFast(head, tail);
        listFastSort(head,findTail(head,mark));
        listFastSort(mark.next,tail);

    }


    public static void printList(ListNode head){
        ListNode pre = head;
        System.out.println("list:  ");
        while (pre != null){
            System.out.print(" "+pre.val+" ,");
            pre = pre.next;
        }
        System.out.println();
    }

    public static ListNode findTail(ListNode head,ListNode mark){
        ListNode pre = head;
        if(head == mark)
            return head;
        while (pre.next != mark){
            pre = pre.next;
        }
        return pre;
    }



    public static void print(int[] nums){
        System.out.println("nums=" + Arrays.toString(nums) );
    }

    public static void main(String[] args) {
//        int[] nums = {4,6,2,8,3,1,9,7,5};
//        arrayFastSort(nums,0,nums.length-1);
//        System.out.println("-----------------");
//        print(nums);
        ListNode head = new ListNode(4,null);
        head.addNode(head,6);
        head.addNode(head,2);
        head.addNode(head,8);
        head.addNode(head,3);
        head.addNode(head,1);
        head.addNode(head,10);
        head.addNode(head,9);
        head.addNode(head,5);
        printList(head);
        ListNode tail = findTail(head,null);

        listFastSort(head,tail);

        printList(head);
    }

}
