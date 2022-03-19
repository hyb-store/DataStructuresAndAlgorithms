package offer;

import java.util.HashSet;
import java.util.Set;

/*剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

示例 1:
输入: [1,2,3,4,5]
输出: True

示例 2:
输入: [0,0,1,2,5]
输出: True
 */
public class offer61 {
    /**
     * 集合 Set + 遍历
     *      遍历五张牌，遇到大小王（即 0 ）直接跳过。
     *      判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1) ；
     *      获取最大 / 最小的牌： 借助辅助变量 max 和 min ，遍历统计即可。
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) {
                return false;// 若有重复，提前返回 false
            }
            set.add(num);
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,5};
        System.out.println(isStraight(arr));
    }
}
