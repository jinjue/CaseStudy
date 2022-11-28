package studyStru;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Parentheses {

    public static int longestValidParentheses(String s) {
        if(s == null)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0;i<s.length();i++){
            //遇到左括号进栈
            if(s.charAt(i) == '('){
                stack.push(i);

            }
            else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else {//若栈顶元素为左括号，则出栈栈顶元素，长度+1
                    res =Math.max(res,i-stack.peek()) ;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        String s = ")()())()";
        System.out.println(longestValidParentheses(s));
    }

}
