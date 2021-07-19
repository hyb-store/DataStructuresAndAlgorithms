package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]

示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */

/**第一个问题，窗口何时扩大，何时缩小？
 *     1. 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
 *     2. 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
 *     3. 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，那
 *        么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1 开头的序列，所以窗口的左边界要向右移动
 */
public class offer57_2 {

    public static int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {

            if (sum > target) {//和比目标值大，左边界右移
                sum = sum - i;
                i++;
            } else if (sum < target) {//和比目标值小，右边界右移
                sum = sum + j;
                j++;
            } else {//和等于目标值，记录结果
                int[] temp = new int[j - i];
                for (int k = i; k < j; k++) { //记录结果给数组
                    temp[k - i] = k;
                }
                res.add(temp);//记录结果到res
                sum = sum - i;//左边界右移
                i++;
            }

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        for (int[] ints : findContinuousSequence(9)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
