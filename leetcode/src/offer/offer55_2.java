package offer;

/*剑指 Offer 55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 
 */ 
class TreeNode8 {
    int val;
    TreeNode8 left;
    TreeNode8 right;

    TreeNode8(int x) {
        val = x;
    }
}
public class offer55_2 {
/**
 * 通过比较某子树的左右子树的深度差是否成立，来判断某子树是否是二叉平衡树。若所有子树都平衡，则此树平衡
 */
//    public static int maxDepth(TreeNode8 root) {
//        if (root == null)
//            return 0;
//        return Math.max(root.left == null ? 0 : maxDepth(root.left),root.right == null ? 0 : maxDepth(root.right)) + 1;
//    }
//
//    public static boolean isBalanced(TreeNode8 root) {
//        if (root == null) return true;
//        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }

    /**
     * recur(root) 函数：
     * 返回值：
     *    1.当节点root 左 / 右子树的深度差 \leq 1≤1 ：则返回当前子树的深度，
     *          即节点 root 的左 / 右子树的深度最大值 +1 （ max(left, right) + 1 ）；
     *    2.当节点root 左 / 右子树的深度差 > 2 ：则返回 -1 ，代表 此子树不是平衡树 。
     * 终止条件：
     *    1.当 root 为空：说明越过叶节点，因此返回高度 0；
     *    2.当左（右）子树深度为 −1 ：代表此树的 左（右）子树 不是平衡树，因此剪枝，直接返回 -1 ；
     * isBalanced(root) 函数：
     *    返回值： 若 recur(root) != -1 ，则说明此树平衡，返回 true ； 否则返回 false
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode8 root) {
        return recur(root) != -1;
    }

    private static int recur(TreeNode8 root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        TreeNode8 node1 = new TreeNode8(3);
        TreeNode8 node2 = new TreeNode8(9);
        TreeNode8 node3 = new TreeNode8(20);
        TreeNode8 node4 = new TreeNode8(15);
        TreeNode8 node5 = new TreeNode8(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(isBalanced(node1));

    }
}
