package studyStru;

import pojo.TreeNode;

import java.util.LinkedList;

/**
 * 实现获取二叉树的镜像
 */
public class MirrorTree {

    /**
     * 利用层序遍历来实现获取二叉树镜像
     * @param root
     * @return
     */
    public static TreeNode getMirror(TreeNode root){
        //判断节点不为null
        if(root == null)
            return null;
        //创建二叉树镜像的根节点
        TreeNode mirrorRoot = new TreeNode(root.val);

        mirrorRoot.left = getMirror(root.right);
        mirrorRoot.right = getMirror(root.left);

        return mirrorRoot;

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

        TreeNode mirrorRoot = getMirror(root);
        levelTraverse(mirrorRoot);

    }

}
