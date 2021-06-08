package leetcode;

/**整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 最大的32位整数  2147483647     我们到【最大数的1/10】时，就要开始判断了
 * 如果某个数字大于 214748364那，肯定溢出了。
 * 如果某个数字等于 214748364呢，需要要跟最大数的末尾数字比较，如果这个数字比7还大，说明溢出了。
 *
 * 对于负数也是一样的
 */
public class Test7ReverseInteger {

    public static void main(String[] args) {
         int a = 2147483646;
        System.out.println(reverse(a));
        System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);//2147483647 -2147483648
    }

    public static int reverse(int x) {
        int res = 0;
        while(x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
