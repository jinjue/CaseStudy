package studyStru;

import java.util.Arrays;

/**
 * 使用数组实现一个先入先出的队列
 */
public class MyQueue_Array {

    int[] nums;
    int front;
    int rear;
    int maxsize;

    public MyQueue_Array(int maxsize) {
        this.nums = new int[maxsize];
        this.front = 0;
        this.rear = 0;
        this.maxsize = maxsize;
    }

    public boolean isEmpty(){
        if(front == rear)
            return true;
        return false;
    }

    public boolean isFull(){
        if(front == (rear+1)%maxsize)
            return true;
        return false;
    }

    public boolean popQueue(int data){
        if(isFull())
            return false;
        nums[rear] = data;
        rear = (rear+1)%maxsize;
        return true;
    }

    public int pushQueue(){
        if(isEmpty())
            return -1;
        int result = nums[front];
        front = (front+1)%maxsize;
        return result;
    }

    @Override
    public String toString() {
        return "MyQueue_Array{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }

    public static void main(String[] args) {
        MyQueue_Array myQueue = new MyQueue_Array(5);
        myQueue.popQueue(1);
        myQueue.popQueue(2);
        myQueue.popQueue(3);
        myQueue.popQueue(4);

        System.out.println(myQueue.pushQueue());
        myQueue.popQueue(5);
        System.out.println(myQueue.pushQueue());


    }
}
