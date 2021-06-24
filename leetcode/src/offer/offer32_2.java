package offer;

import java.util.*;

/*剑指 Offer 32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */
//Definition for a binary tree node.
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4(int x) {
        val = x;
    }
}
public class offer32_2 {
    public static List<List<Integer>> levelOrder(TreeNode4 root) {
        if (root == null) {
           return new ArrayList<>(0);
        }
        Queue<TreeNode4> queue = new LinkedList<TreeNode4>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);//添加根节点

        while (!queue.isEmpty()) {
          List<Integer> temp = new ArrayList<>();//临时列表
            for (int i = queue.size(); i > 0 ; i--) {//queue.size会变化，所以先给i赋值
                TreeNode4 node = queue.poll();
                temp.add(node.val);//存值
                //找到下一层存入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(temp);
        }
        return list;
       
    }
    public static void main(String[] args) {
        TreeNode4 node1 = new TreeNode4(3);
        TreeNode4 node2 = new TreeNode4(9);
        TreeNode4 node3 = new TreeNode4(20);
        TreeNode4 node4 = new TreeNode4(15);
        TreeNode4 node5 = new TreeNode4(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> lists = levelOrder(node1);
        System.out.println(lists);


    }
}
