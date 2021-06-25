package offer;

/*剑指 Offer 34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
示例:
给定如下二叉树，以及目标和 target = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import java.util.List;

//Definition for a binary tree node.
class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;

    TreeNode5() {
    }

    TreeNode5(int val) {
        this.val = val;
    }

    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void addLR(TreeNode5 left, TreeNode5 right) {
        this.left = left;
        this.right = right;
    }
}
public class offer34 {

    public static List<List<Integer>> pathSum(TreeNode5 root, int target) {
        if () {

        }


        pathSum()
    }

    public static void main(String[] args) {
        TreeNode5 node1 = new TreeNode5(5);
        TreeNode5 node2 = new TreeNode5(4);
        TreeNode5 node3 = new TreeNode5(8);
        TreeNode5 node4 = new TreeNode5(11);
        TreeNode5 node5 = new TreeNode5(13);
        TreeNode5 node6 = new TreeNode5(4);
        TreeNode5 node7 = new TreeNode5(7);
        TreeNode5 node8 = new TreeNode5(2);
        TreeNode5 node9 = new TreeNode5(5);
        TreeNode5 node10 = new TreeNode5(1);

        node1.addLR(node2, node3);
        node2.left = node4;
        node4.addLR(node7, node8);
        node3.addLR(node5, node6);
        node6.addLR(node9, node10);

        System.out.println(pathSum(node1, 22));

    }
}
