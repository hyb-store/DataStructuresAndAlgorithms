package offer;

import java.util.Arrays;
import java.util.Collection;

/*剑指 Offer 40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]

示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]
 */
public class offer40 {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int left, int right) {
       if (left >= right) {
           return;
       }
       int m = left;    //arr[left] 为基准
       int n = right;

        /**为什么这两句while互换就会报错呢？
         *      两个 while执行完， i j 同时指向一个 < arr[l] 的数，因此最后再执行 arr[l], arr[i] = arr[i], arr[l] 可以把哨兵交换到正确的位置。
         *   而如果互换这两句，那么就是 i 先向右遍历，两个 while 执行完， i j 同时指向一个 > arr[l] 的数，那么就不对了。
         *   如果要交换写，那么同时也要把哨兵换成数组的末元素，让整个哨兵划分操作对称。
         */
       while (m < n) {
           while (m < n && arr[n] >= arr[left]) {//从右到左先找到小于基准的。只要执行到这里，一定找到小于基准的。
                                    // 当m<n不满足了，找到的是上次swap之后，arr[m]的值(交换前arr[n]的值),即还是小于基准
               n--;
           }
           while (m < n && arr[m] <= arr[left]) {//再找到大于基准的
               m++;
           }
           swap(arr, m, n);
       }
       swap(arr, left, m);
       quickSort(arr, left, m - 1);
       quickSort(arr, m + 1, right);

    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,1};
        int[] newArr = getLeastNumbers(arr, 1);
        System.out.println(Arrays.toString(newArr));


    }
}
