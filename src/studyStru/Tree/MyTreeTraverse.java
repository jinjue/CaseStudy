package studyStru.Tree;

import pojo.TreeNode;

import java.util.*;

/**
 * 实现对树的遍历
 */
public class MyTreeTraverse {

    /**
     * 递归实现前序遍历、中序遍历、后序遍历
     */
    public static void preTraverseRe(TreeNode root){
        if(root == null)
            return;
        System.out.print(" "+root.val);
        preTraverseRe(root.left);
        preTraverseRe(root.right);
    }
    public static void midTraverseRe(TreeNode root){
        if(root == null)
            return;

        midTraverseRe(root.left);
        System.out.print(" "+root.val);
        midTraverseRe(root.right);
    }
    public static void afterTraverseRe(TreeNode root){
        if(root == null)
            return;

        afterTraverseRe(root.left);
        afterTraverseRe(root.right);
        System.out.print(" "+root.val);
    }

    /**
     * 前序遍历的非递归实现
     * @param root
     */
    public static void preTraverse(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //获取栈顶元素
            TreeNode node = stack.pop();
            System.out.print(" "+node.val);

            if(node.right != null ){ // 若为null则出栈栈顶节点，并访问右节点
                //若右节点不为空，则右节点入栈
                stack.push(node.right);
            }
            //访问栈顶元素左孩子
            if(node.left != null ){ // 若不为null则，压入栈中
                stack.push(node.left);
            }

        }
    }

    public static void preOrder(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(" "+node);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    /**
     * 中递归方式实现前序遍历
     * @param root
     */
    public static void midTraverse(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer,TreeNode> tree = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //获取栈顶元素
            TreeNode node = stack.peek();
            //访问栈顶元素左孩子
            if(node.left != null && tree.get(node.left.val) == null){ // 若不为null则，压入栈中
                stack.push(node.left);
            }
            else {// 若为null则出栈栈顶节点，并访问右节点
                System.out.print(" "+stack.pop().val);
                tree.put(node.val,node);
                if(node.right != null){//若右节点不为空，则右节点入栈
                    stack.push(node.right);
                }
            }
        }
    }

    public static void midTraverse2(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
           if (root != null){
                stack.push(root.left);
                root = root.left;
            }
           else {
               root = stack.pop();
               System.out.println(" "+ root.val);
               root = root.right;
           }
        }
    }


    /**
     * 后序遍历的非递归实现
     * @param root
     */
    public static void afterTraverse(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer,TreeNode> tree = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //获取栈顶元素
            TreeNode node = stack.peek();

            //访问栈顶元素左孩子
            if(node.left != null && tree.get(node.left.val) == null){ // 若不为null则，压入栈中
                stack.push(node.left);
            }
            else if(node.right != null && tree.get(node.right.val) == null){ // 若为null则出栈栈顶节点，并访问右节点
                //若右节点不为空，则右节点入栈
                stack.push(node.right);
            }
            else {
                if(tree.put(node.val,node) == null){
                    System.out.print(" "+stack.pop().val);
                }

            }
        }
    }

    public static void afterOrder(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> collect = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            collect.push(node);
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        while (!collect.isEmpty()){
            System.out.println(" "+collect.pop().val);
        }

    }

    /**
     * 层序遍历实现
     * @param root
     */
    public static void levelTraverse(TreeNode root){
        if(root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                System.out.print(" "+node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }

        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2,4,5);
        TreeNode rightChild = new TreeNode(3,6,7);
        root.left = leftChild;
        root.right = rightChild;

        preTraverseRe(root);
        System.out.println();
        preTraverse(root);
        System.out.println();

        midTraverseRe(root);
        System.out.println();
        midTraverse(root);
        System.out.println();

        afterTraverseRe(root);
        System.out.println();
        afterTraverse(root);

        levelTraverse(root);
        System.out.println();

    }

}
