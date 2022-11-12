package studyStru;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 蛇形打印二叉树
 */
public class SnackTree {

    public static ArrayList<Integer> snack(TreeNode root){
        if(root == null)
            return null;
        //创建两个栈用于存放奇数层、偶数层节点
        Stack<TreeNode> stack1 = new Stack<>();//奇数层
        Stack<TreeNode> stack2 = new Stack<>();//偶数层
        //将根节点压入栈中
        stack1.push(root);
        //level表示层数
        int level = 1;
        //创建链表用于存放蛇形遍历结果
        ArrayList<Integer> list = new ArrayList<>();
        //遍历结束条件：两个栈都为空
        while (!stack1.empty() || !stack2.empty()){
            //若为奇数层，叶子结点从左往右入栈，因为访问叶子结点，所以入偶数栈
            if( level%2 != 0){
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    if(node != null){
                        stack2.push(node.left);
                        stack2.push(node.right);
                        //将入栈元素添加进结果链表中
                        list.add(node.val);
                    }
                }
                level++;
            }
            else {//若为偶数层，叶子结点从右往左入栈，入奇数栈
                while (!stack2.empty()){
                    TreeNode node = stack2.pop();
                    if(node != null){
                        stack1.push(node.right);
                        stack1.push(node.left);
                        //将入栈元素添加进结果链表中
                        list.add(node.val);
                    }
                }
                level++;
            }
        }

        //返回结果链表
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2,4,5);
        TreeNode rightChild = new TreeNode(3,6,7);
        root.left = leftChild;
        root.right = rightChild;
        ArrayList<Integer> list = snack(root);
        System.out.println(list.toString());
    }

}
