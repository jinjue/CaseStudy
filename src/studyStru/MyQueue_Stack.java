package studyStru;

import java.util.Stack;

/**
 * 使用两个栈实现一个先入先出的队列
 */

public class MyQueue_Stack {

    Stack<Integer> queueIn;
    Stack<Integer> queueOut;

    public MyQueue_Stack() {
        this.queueIn = new Stack<>();
        this.queueOut = new Stack<>();
    }

    public boolean isEmpty(Stack<Integer> stack){
        if(stack.empty())
            return true;
        return false;
    }


    public boolean pushQueue(int data){
        if(!queueOut.empty())
            queueIn.clear();

        while (!queueOut.empty()){
            queueIn.push(queueOut.pop());
        }
        queueIn.push(data);
        return true;
    }

    public Integer popQueue(){
        if(!queueIn.empty())
            queueOut.clear();
        if(queueIn.empty() && queueOut.empty())
            return -1;
        while (!queueIn.empty()){
            queueOut.push(queueIn.pop());
        }
        return queueOut.pop();
    }

    public static void main(String[] args) {
        MyQueue_Stack myQueue = new MyQueue_Stack();

        myQueue.pushQueue(1);
        myQueue.pushQueue(2);
        myQueue.pushQueue(3);
        myQueue.pushQueue(4);

        System.out.println(myQueue.popQueue());
        System.out.println(myQueue.popQueue());
        System.out.println(myQueue.popQueue());
        System.out.println(myQueue.popQueue());
        System.out.println(myQueue.popQueue());




    }

}
