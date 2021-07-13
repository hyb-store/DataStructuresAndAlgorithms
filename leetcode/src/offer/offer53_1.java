package offer;

/*剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 */
public class offer53_1 {

    public static int search(int[] nums, int target) {
        // 搜索右边界 right 。 即target的后一位
        int i = 0, j = nums.length - 1;
        while(i <= j) { // 找到右边界的后一位
            int m = (i + j) / 2;
            if(nums[m] <= target) { //中间的数小于等于目标数，说明目标在右边
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 right ，即target的前一位
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2, 3,4,5,5,5,5};

        System.out.println(search(arr, 5));


    }
}
