package offer;

/*剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
// Definition for a binary tree node.
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}
public class offer27 {
    public static TreeNode2 mirrorTree(TreeNode2 root) {
        if (root == null ){
            return null;
        }
        TreeNode2 left = mirrorTree(root.left);
        TreeNode2 right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
        TreeNode2 treNode1 = new TreeNode2(4);
        TreeNode2 treNode2 = new TreeNode2(2);
        TreeNode2 treNode3 = new TreeNode2(7);
        TreeNode2 treNode4 = new TreeNode2(1);
        TreeNode2 treNode5 = new TreeNode2(3);
        TreeNode2 treNode6 = new TreeNode2(6);
        TreeNode2 treNode7 = new TreeNode2(9);

        treNode1.left = treNode2;
        treNode1.right = treNode3;

        treNode2.left = treNode4;
        treNode2.right = treNode5;

        treNode3.left = treNode6;
        treNode3.right = treNode7;

    }
}
