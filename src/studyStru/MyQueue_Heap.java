package studyStru;

import java.util.Arrays;

/**
 * 使用堆实现优先队列
 */
public class MyQueue_Heap {

    int[] nums;
    int size;
    int capacity;

    public MyQueue_Heap(int size) {
        this.nums = new int[2*size];
        this.size = 0;
        this.capacity = size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    /**
     * 判断是否已满
     * @return
     */
    public boolean isFull(){
        if(size == capacity)
            return true;
        return false;
    }

    /**
     * 入队操作
     * @param data
     * @return
     */
    public boolean pushQueue(int data){
        if(isFull())
            return false;
        size ++;
        nums[size] = data;
        upHeap();
        nums[0] = size;
        return true;
    }

    /**
     * 出队操作
     * @return
     */
    public int popQueue(){
        if(isEmpty())
            return -1;
        int result = nums[1];
        nums[1] = 0;
        downHeap();
        size -- ;
        nums[0] = size;
        return result;
    }

    /**
     * 上浮调整
     */
    public void upHeap(){
        for(int i = size ; i>1 ;i--){
            if(nums[i]>nums[i/2]){
                int temp = nums[i];
                nums[i] = nums[i/2];
                nums[i/2] = temp;
            }
        }

    }

    /**
     * 下沉调整
     */
    public void downHeap(){
        for(int i = 1; i<size/2 ;i++){
            int max = Math.max(nums[2*i],nums[2*i+1]);
            int index = nums[2*i]>nums[2*i+1]?2*i:2*i+1;
            if(nums[i]<max){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

    }

    @Override
    public String toString() {
        return "MyQueue_Heap{" +
                "nums=" + Arrays.toString(nums) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        MyQueue_Heap myQueue = new MyQueue_Heap(10);
        myQueue.pushQueue(4);
        myQueue.pushQueue(7);
        myQueue.pushQueue(9);
        myQueue.pushQueue(1);
        myQueue.pushQueue(5);
        myQueue.pushQueue(2);
        System.out.println(myQueue.toString());

        System.out.println(myQueue.popQueue());
        myQueue.pushQueue(12);
        System.out.println(myQueue.toString());

    }



}
