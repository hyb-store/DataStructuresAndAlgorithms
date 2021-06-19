package offer;
/*
剑指 Offer 16. 数值的整数次方
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000

示例 2：
输入：x = 2.10000, n = 3
输出：9.26100

示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class offer16 {
    /**
     * 核心：2^18 = 2^(10010) = 2^(10000)*2^(10) = 2^16 * 2^2 = 2^18
     */
    public static double myPow(double x, int n) {
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = - b;
        }

        double result = 1;
        while (b != 0) {
            if (b % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            b = b >> 1;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
