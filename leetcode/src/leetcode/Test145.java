package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test145 {
    public static void main(String[] args) {

    }

    public void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode lastVisited = null;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.offerLast(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pollLast();
                if (node.right == null || node.right == lastVisited) {
                    System.out.println(node.val);
                    lastVisited = node;
                    node = null;
                } else {
                    stack.offerLast(node);
                    node = node.right;
                } // tql
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}