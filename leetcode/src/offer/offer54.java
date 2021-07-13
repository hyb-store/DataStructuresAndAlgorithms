package offer;
/*剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。

示例 1:
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4

示例 2:
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 */

class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode6(int x) {
        val = x;
    }
}
public class offer54 {

    public int res,k;

    // 打印中序遍历倒序
    public void dfs(TreeNode6 root) {
        if(root == null || k == 0) return;
        dfs(root.right); // 右
        k--;
        if (k == 0) {
            res = root.val;
        }

        dfs(root.left); // 左
    }

    public int kthLargest(TreeNode6 root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode6 node1 = new TreeNode6(5);
        TreeNode6 node2 = new TreeNode6(3);
        TreeNode6 node3 = new TreeNode6(6);
        TreeNode6 node4 = new TreeNode6(2);
        TreeNode6 node5 = new TreeNode6(4);
        TreeNode6 node6 = new TreeNode6(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        System.out.println(new offer54().kthLargest(node1,4 ));
    }
}
