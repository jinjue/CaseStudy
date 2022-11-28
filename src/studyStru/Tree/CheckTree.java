package studyStru.Tree;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckTree {

    /**
     * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
     * 层序遍历二叉树
     * 若一个节点只有右孩子没有左孩子，一定不是完全二叉树
     * 若一个节点有孩子缺失的情况，则后续的节点只能是叶子结点，否则不为完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        //用于判断是否存在左孩子存在右孩子缺失的情况
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(
                    (flag && (left != null|| right != null))||
                            (right != null && left == null)
            ){
                return false;
            }
            if(left != null)
                queue.offer(left);
            if(right != null)
                queue.offer(right);
            if(left == null || right == null)
                flag = true;
        }
        return true;
    }

}
