package offer;

/*剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class offer59_1 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int i = 0, j = i + k - 1;
        int[] arr = new int[nums.length - k + 1];
        int temp = 0;
        while (i >= 0 && j <= nums.length - 1) {
            int max = nums[i];
            for (int m = i; m < j; m++) {//求出当前窗口的最大值
                if (max < nums[m + 1]) {
                    max = nums[m + 1];
                }
            }
            arr[temp] = max;
            temp++;
            i++;
            j++;
        }
        return arr;

    }

    public static void main(String[] args) {
//        int[] arr =  new int[]{1,3,-1,-3,5,3,6,7};
        int[] arr =  new int[]{1,3,1,2,0,5};
        int[] maxSlidingWindow = maxSlidingWindow(arr, 3);
        for (int i : maxSlidingWindow) {
            System.out.print(i +  " ");
        }
    }
}
