package offer;

/*剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

提示：
2 <= n <= 58

n     乘积      组合
2       1       1 1
3       2       2
4       4       4

5       6       2 3
6       9       3 3
7       12      4 3

8       18      2 3 3
9       27      3 3 3
10      36      4 3 3

11      54      2 3 3 3
12      81      3 3 3 3
13      108     4 3 3 3
 */
public class offer14_1 {
    /**
     * 动态规划
     *   n>1并且m>1
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        //dp数组记录从0到n长度的绳子剪掉后的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                // 关键：从2开始剪，找 剩余部分剪 和 不剪 与第一段的最大乘积，赋值给dp[i].第二次循环从3开始剪。。。
                //最终找到乘积最大的组合
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(6));
    }
}
