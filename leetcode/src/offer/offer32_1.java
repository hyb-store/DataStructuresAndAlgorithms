package offer;

/*剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]
 */

import java.util.*;

//Definition for a binary tree node.
class TreeNode3 {
     int val;
     TreeNode3 left;
     TreeNode3 right;

     TreeNode3(int x) {
         val = x;
     }
 }

/**
 * add        增加一个元索             如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
 * offer       添加一个元素并返回true       如果队列已满，则返回false
 * poll         移除并返问队列头部的元素    如果队列为空，则返回null
 * peek       返回队列头部的元素             如果队列为空，则返回null
 * put         添加一个元素                      如果队列满，则阻塞
 * take        移除并返回队列头部的元素     如果队列为空，则阻塞
 */
public class offer32_1 {
    public static int[] levelOrder(TreeNode3 root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode3> queue = new LinkedList<TreeNode3>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);//添加根节点
        while (!queue.isEmpty()) {
            TreeNode3 node = queue.poll();//弹出首部，如果队列为空返回null
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        TreeNode3 node1 = new TreeNode3(3);
        TreeNode3 node2 = new TreeNode3(9);
        TreeNode3 node3 = new TreeNode3(20);
        TreeNode3 node4 = new TreeNode3(15);
        TreeNode3 node5 = new TreeNode3(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int[] ints = levelOrder(node1);
        System.out.println(Arrays.toString(ints));


    }
}
