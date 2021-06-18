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
解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class offer16 {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return x;
        }
        double result = x;
        for (int i = 2; i <= n; i++) {
            result = result * x;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(myPow(4, 2));
    }
}
