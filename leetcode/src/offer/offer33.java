package offer;

/*剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3

示例 1：
输入: [1,6,3,2,5]
输出: false

示例 2：
输入: [1,3,2,6,5]
输出: true

 */
public class offer33 {

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            return true;
        }
        int p = i;
        while(postorder[p] < postorder[j]) {//找到第一个大于root的值
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[j]) {//判断第一个大于root的值到root之间是否都是大于root的
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,6,3,2,5};
        int[] arr2 = new int[]{1,3,2,6,5};
        int[] arr3 = new int[]{1,2,5,10,6,9,4,3};
        System.out.println(verifyPostorder(arr1));
        System.out.println(verifyPostorder(arr2));
        System.out.println(verifyPostorder(arr3));


    }
}
