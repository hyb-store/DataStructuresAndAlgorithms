package offer;
/*
剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
 */

import java.util.HashMap;
import java.util.Map;

public class offer07 {

    private static Map<Integer, Integer> indexMap;

    public static TreeNode1 build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int inRoot = indexMap.get(preorder[preLeft]);//中序遍历根节点的索引
        int leftCount = inRoot - inLeft;//左子树的数量

        //创建根节点
        TreeNode1 node = new TreeNode1(preorder[preLeft]);

        // 先序遍历中[从 左边界+1 开始的 leftCount]个元素就对应了中序遍历中[从 左边界 开始到 根节点定位-1]的元素
        node.left = build(preorder,inorder,preLeft+1,preLeft+leftCount,inLeft,inRoot-1);
        // 先序遍历中[从 左边界+1+左子树节点数目 开始到 右边界]的元素就对应了中序遍历中[从 根节点定位+1 到 右边界]的元素
        node.right = build(preorder,inorder,preLeft+leftCount+1,preRight,inRoot+1,inRight);

        return node;

    }

    public static TreeNode1 buildTree(int[] preorder, int[] inorder) {
        int preorderLength = inorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorderLength; i++) {
            indexMap.put(inorder[i], i);//中序遍历数组值，索引
        }
        return build(preorder, inorder, 0, preorderLength - 1,0, preorderLength - 1);
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] infixOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode1 treeNode1 = buildTree(preOrder, infixOrder);
        System.out.println(treeNode1);

    }
}

//Definition for a binary tree node.
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode1{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}