package studyStru;

import java.util.Arrays;

/**
 * 使用无序数组实现优先队列
 */
public class MyPriQueue {
    private int[] nums;
    private int front;
    private int rear;
    private int maxSize;

    public MyPriQueue(int maxSize) {
        this.nums = new int[maxSize];
        this.front = 0;
        this.rear = 0;
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
        if(front == (rear+1)%maxSize){
            System.out.println("full");
            return true;
        }

        return false;
    }

    /**
     * 对无序数组实现的优先队列进行入队操作

     * @return
     */
    public boolean popQueue(int data){
        //判断是否队满
        if(isFull()){
            return false;
        }
        //将元素插入到rear指针所指位置
        nums[rear] = data;
        //移动rear指针
        rear = (rear+1)%maxSize;

        return true;
    }

    public int pushQueue(){
        //判断是否队空
        if(isEmpty())
            return -1;
        //寻找最大元素
        int max = front;
        int i = front;
        while(true){
            if((i+1)%maxSize == rear) break;
            i = (i+1)%maxSize;
            if(nums[i] > nums[max])
                max = i;
        }
        //移除元素，并将前续元素往后移动一格
        i = max;
        max = nums[i];
        int j = i;
        System.out.println(j);
        while(j%maxSize != front){
            if(j == 0){
                nums[j] = nums[maxSize-1];
                j = maxSize - 1;
            }
            else {
                nums[j] = nums[(j-1)%maxSize];
                j = (j-1)%maxSize;
            }


        }

        //移动front
        front = (front+1)%maxSize;
        return max;
    }

    @Override
    public String toString() {
        return "MyPriQueue{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }

    public static void main(String[] args) {
        MyPriQueue myPriQueue = new MyPriQueue(10);
        myPriQueue.popQueue(3);
        myPriQueue.popQueue(1);
        myPriQueue.popQueue(4);
        myPriQueue.popQueue(2);
        myPriQueue.popQueue(6);
        myPriQueue.popQueue(8);
        myPriQueue.popQueue(7);

        System.out.println(myPriQueue.pushQueue());
        System.out.println(myPriQueue.pushQueue());
        System.out.println(myPriQueue.pushQueue());

        myPriQueue.popQueue(10);
        myPriQueue.popQueue(8);
        myPriQueue.popQueue(11);
        myPriQueue.popQueue(12);

        System.out.println(myPriQueue.toString());
        System.out.println("front: "+myPriQueue.front+"  rear: "+myPriQueue.rear);
        System.out.println(myPriQueue.pushQueue());
        System.out.println(myPriQueue.pushQueue());

    }

}
