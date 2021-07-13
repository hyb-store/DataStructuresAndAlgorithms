package offer;

/*剑指 Offer 55 - I. 二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */

import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode7 {
    int val;
    TreeNode7 left;
    TreeNode7 right;

    TreeNode7(int x) {
        val = x;
    }
}

public class offer55_1 {

    /**
     * 此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1
     * @param root
     * @return
     */
//    public static int maxDepth(TreeNode7 root) {
//        if (root == null)
//            return 0;
//        return Math.max(root.left == null ? 0 : maxDepth(root.left),root.right == null ? 0 : maxDepth(root.right)) + 1;
//    }

    /**
     * 方法二：层序遍历（BFS）
     *      树的层序遍历 / 广度优先搜索往往利用 队列 实现。
     *      关键点： 每遍历一层，则计数器 +1 ，直到遍历完成，则可得到树的深度。
     *   算法解析：
     *      特例处理： 当 root​ 为空，直接返回 深度 0
     *      初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
     *      循环遍历： 当 queue 为空时跳出。
     *          1.初始化一个空列表 tmp ，用于临时存储下一层节点；
     *          2.遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
     *          3.更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
     *          4.统计层数： 执行 res += 1 ，代表层数加 1；
     *      返回值： 返回 res 即可。
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode7 root) {
        if(root == null) return 0;
        List<TreeNode7> queue = new LinkedList<>() , tmp;
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();//用于临时存储下一层节点
            for(TreeNode7 node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode7 node1 = new TreeNode7(3);
        TreeNode7 node2 = new TreeNode7(9);
        TreeNode7 node3 = new TreeNode7(20);
        TreeNode7 node4 = new TreeNode7(15);
        TreeNode7 node5 = new TreeNode7(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(maxDepth(node1));

    }
}
