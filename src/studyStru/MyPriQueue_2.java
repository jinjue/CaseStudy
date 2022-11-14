package studyStru;

import java.util.Arrays;

/**
 * 使用有序序列实现优先队列
 */
public class MyPriQueue_2 {

    private int[] nums;
    private int front;
    private int rear;
    private int maxSize;

    public MyPriQueue_2(int maxSize) {
        this.nums = new int[maxSize+1];
        this.front = 0;
        this.rear = 1;
        this.maxSize = maxSize;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        if(front == rear)
            return true;
        return false;
    }

    /**
     * 判断是否队列为满
     * @return
     */
    public boolean isFull(){
        if(front == (rear+1)%maxSize)
            return true;
        return false;
    }

    /**
     * 将元素插入有序数组实现的优先队列中
     * @param data
     * @return
     */
    public boolean popQueue(int data){
        //判断队列是否已满
        if(isFull())
            return false;
        //寻找合适位置
        int i = front;
        while(i%maxSize != rear){
            if(nums[i]>data){
                i = (i+1)%maxSize;
            }
            else {
                break;
            }
        }
        //移动元素
        int j = rear;
        while(j%maxSize != i){
            nums[j] = nums[(j-1)%maxSize];
            j = (j-1)%maxSize;
        }
        //将元素插入
        nums[i] = data;
        //修改rear的值
        rear = (rear+1)%maxSize;
        //返回true
        return true;
    }

    /**
     * 对优先队列出队
     * @return
     */

    public int pushQueue(){
        //判断队列是否为空
        if(isFull())
            return -1;
        //出队front所指元素
        int max = nums[front];
        //修改front的值
        front = (front+1)%maxSize;
        return max;
    }

    @Override
    public String toString() {
        return "nums=" + Arrays.toString(nums) +
                '}';
    }

    public static void main(String[] args) {
        MyPriQueue_2 queue = new MyPriQueue_2(10);
        queue.popQueue(2);
        queue.popQueue(6);
        queue.popQueue(7);
        queue.popQueue(3);
        queue.popQueue(1);
        System.out.println(queue.toString());

        System.out.println(queue.pushQueue());
        queue.popQueue(5);
        System.out.println(queue.toString());

    }


}
