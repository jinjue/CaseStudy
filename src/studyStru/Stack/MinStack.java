package studyStru.Stack;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> miniStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.miniStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(miniStack.isEmpty()){
            miniStack.push(val);
        }
        else {
            miniStack.push(Math.min(miniStack.peek(),val));
        }
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        stack.pop();
        miniStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return miniStack.peek();
    }
}
