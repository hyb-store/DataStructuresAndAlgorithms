package offer;

/*剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class offer42 {
    /** 动态规划
     * 设动态规划列表 dpdp ，dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //创建dp
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }

            if (max < dp[i]) {
                max =dp[i];
            }
        }

        return max;
    }
//    //题解，优化后的
//    public static int maxSubArray(int[] nums) {
//        int res = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            nums[i] += Math.max(nums[i - 1], 0);
//            res = Math.max(res, nums[i]);
//        }
//        return res;
//    }
    public static void main(String[] args) {
        int[] nums =  new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
