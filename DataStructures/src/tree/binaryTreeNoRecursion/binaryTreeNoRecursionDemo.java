package tree.binaryTreeNoRecursion;

import java.util.Stack;
/*
       5
      / \
     3   6
    / \
   2   4
  /
 1
 先序遍历：5 3 2 1 4 6
 中序遍历：1 2 3 4 5 6
 后序遍历：1 2 4 3 6 5
 */
public class binaryTreeNoRecursionDemo {
    public static void main(String[] args) {

        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        Node node6 = new Node(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;

        BinaryTreeNoRecursion btnr = new BinaryTreeNoRecursion();

        //先序遍历
        btnr.preOrder(node1);
        System.out.println();

        //中序遍历
        btnr.inOrder(node1);
        System.out.println();

        //后续遍历
        //btnr.postOrder(node1);
    }

}

class BinaryTreeNoRecursion {

    /**
     * 1.二叉树前序遍历的非递归实现
     *    实现思路，先序遍历是要先访问根节点，然后再去访问左子树以及右子树，这明显是递归定义，但这里是用栈来实现的
     *    首先需要先从栈顶取出节点，然后访问该节点，如果该节点不为空，则访问该节点，同时把该节点的右子树先入栈，然后
     *    左子树入栈。循环结束的条件是栈中不在有节点。即 !s.empty()
     * @param root
     */
    public void preOrder(Node root) {
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        Node p = null;
        while (!s.empty()) {
            p = s.pop();
            if (p != null) {
                System.out.print(p.val+" ");
                s.push(p.right);
                s.push(p.left);
            }
        }
    }

    /**
     * 2.二叉树的中序遍历非递归实现
     *     实现思路：
     *          1.中序遍历是要先遍历左子树，然后根节点，最后遍历右子树。所以需要先把根节点入栈然后在一直把左子树入栈
     *          直到左子树为空，此时停止入栈。
     *          2.栈顶节点就是我们需要访问的节点，取栈顶节点p并访问。然后该节点可能有右子树，所以
     *          访问完节点p后还要判断p的右子树是否为空，如果为空则接下来要访问的节点在栈顶，所以将p赋值为null。
     *          3.如果不为空则将p赋值为其右子树的值。 循环结束的条件是p不为空或者栈不为空。
     * @param root
     */
    public void inOrder(Node root) {
        Stack<Node> s = new Stack<Node>();
        Node p = root;
        do {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.print(p.val+" ");
            if (p.right != null) {
                p = p.right;
            }
            else p = null;
        } while(p != null || !s.empty());
    }

    /**  据说有问题
     * 3.二叉树的后序遍历里非递归实现
     *     实现思路，
     *     1.在进行后序遍历的时候是先要遍历左子树，然后在遍历右子树，最后才遍历根节点。所以在非递归的实现中要先把根节点入栈
     *     然后再把左子树入栈直到左子树为空，此时停止入栈。此时栈顶就是需要访问的元素，所以直接取出访问p。
     *     2.在访问结束后，还要判断被访问的节点p是否为栈顶节点的左子树，如果是的话那么还需要访问栈顶节点的右子树，
     *     所以将栈顶节点的右子树取出赋值给p。如果不是的话则说明栈顶节点的右子树已经访问完了，那么现在可以访问栈顶节点了，
     *     所以此时将p赋值为null。判断结束的条件是p不为空或者栈不为空，若果两个条件都不满足的话，说明所有节点都已经访问完成。
     * @param root
     */
//    public void postOrder(Node root) {
//
//        Stack<Node> s = new Stack<Node>();
//        Node p = root;
//        while (p != null || !s.empty()) {
//            while(p != null) {
//                s.push(p);
//                p = p.left;
//            }
//            p = s.pop();
//            System.out.print(p.val+" ");
//            //这里需要判断一下，当前p是否为栈顶的左子树，如果是的话那么还需要先访问右子树才能访问根节点
//            //如果已经是不是左子树的话，那么说明左右子书都已经访问完毕，可以访问根节点了，所以讲p复制为NULL
//            //取根节点
//            if (!s.empty() && p == s.peek().left) {
//                p = s.peek().right;
//            }
//            else p = null;
//        }
//    }

}
//树的节点类
class Node {
    public int val; //节点值
    public Node left; //左子树
    public Node right; //右子树
    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}