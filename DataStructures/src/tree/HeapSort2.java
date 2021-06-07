package tree;
/**
 * 堆排序
 * https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=5296047212227512445
 */

import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        int[] tree = {2,5,3,1,10,4};
        heap_sort(tree,tree.length);
        System.out.println(Arrays.toString(tree));
    }

    /** 从该节点向下堆化
     * @param tree
     * @param n 节点数
     * @param i 对哪个节点进行 heapify 操作
     */
    public static void heapify(int[] tree, int n, int i) {
        int c1 = 2 * i +1;
        int c2 = 2 * i +2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        if(max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    /**
     * 从最后一个节点的父节点（最后一个非叶子节点）开始，向上逐个 heapify。 变成大顶堆
     * @param tree
     * @param n
     */
    public static void build_heap(int[] tree, int n) {
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        for (int i = parent; i >= 0 ; i--) {
            heapify(tree, n, i);
        }
    }

    /**
     * 先建一个大顶堆，然后交换根节点和最后一个节点，交换完后，数组最后一个元素即为最大数。然后继续对前面n-1元素堆化，重复
     * @param tree
     * @param n
     */
    public static void heap_sort(int[] tree, int n){
        build_heap(tree, n);
        for (int i = n - 1; i >= 0 ; i--) {
            swap(tree, i, 0);
            heapify(tree, i, 0);
        }

    }

    //交换i和j
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
