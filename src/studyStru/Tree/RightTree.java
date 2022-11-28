package studyStru.Tree;

import pojo.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightTree {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null )
            return new ArrayList<>(root.val);
        //创建返回链表
        List<Integer> res = new ArrayList<>();
        //创建队列用于层序遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        //创建哈希表用于记录节点所在的层数
        HashMap<TreeNode,Integer> map = new HashMap<>();
        //创建变量用于记录层数
        int level = 1;
        queue.offer(root);
        res.add(root.val);
        map.put(root,level);
        //遍历二叉树：当队列不为空时循环（从右到左
        while (!queue.isEmpty()){
            //队头元素出队，获取元素所在的层
            TreeNode node = queue.poll();
            int curLevel = map.get(node);
            if(curLevel != level) {//若所在的层数和已经遍历到的层数不相等
                //则链表添加元素
                res.add(node.val);
                //记录已遍历的层数++
                level ++;
            }
            if(node.right != null) {//将右节点入队（不为空时，并添加进map中
                queue.offer(node.right);
                map.put(node.right,curLevel + 1);
            }
            if(node.left != null) {//左节点入队（不为空时，并添加进map中
                queue.offer(node.left);
                map.put(node.left,curLevel + 1);
            }
        }
        return res;
    }



}
