package offer;

import java.util.ArrayList;
import java.util.List;

/*剑指 Offer 49. 丑数
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

说明:
1 是丑数。
n 不超过1690。
 */
public class offer49 {

//    public static int nthUglyNumber(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//
//        int i = 1,count = 1;
//        while (count < n) {
//            i++;
//            if ((i % 2 == 0 && list.contains(i / 2)) || (i % 3 == 0 && list.contains(i / 3)) || (i % 5 == 0 && list.contains(i / 5)) ) {//是丑数
//                list.add(i);
//                count++;
//            }
//        }
//        return i;
//    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];  // 使用dp数组来存储丑数序列
        dp[0] = 1;  // dp[0]已知为1
        int a = 0, b = 0, c = 0;    // 下个应该通过乘2来获得新丑数的数据是第a个， 同理b, c

        for (int i = 1; i < n; i++) {
            // 第a丑数个数需要通过乘2来得到下个丑数，第b丑数个数需要通过乘2来得到下个丑数，同理第c个数
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++; // 第a个数已经通过乘2得到了一个新的丑数，那下个需要通过乘2得到一个新的丑数的数应该是第(a+1)个数
            }
            if (dp[i] == n3) {
                b++; // 第 b个数已经通过乘3得到了一个新的丑数，那下个需要通过乘3得到一个新的丑数的数应该是第(b+1)个数
            }
            if (dp[i] == n5) {
                c++; // 第 c个数已经通过乘5得到了一个新的丑数，那下个需要通过乘5得到一个新的丑数的数应该是第(c+1)个数
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));

    }
}
