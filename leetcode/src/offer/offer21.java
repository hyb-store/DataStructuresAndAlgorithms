package offer;

import java.util.Arrays;

/*剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：
输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
 */
public class offer21 {
//    public static int[] exchange(int[] nums) {
//        int temp1 = 0;
//        int temp2 = nums.length - 1;
//
//        while (temp1 <= temp2) {
//            int n1 = nums[temp1] % 2;
//            int n2 = nums[temp2] % 2;
//            if (n1 == 1 && n2 == 1) {//都为奇数
//                temp1++;
//            }else if (n1 == 0 && n2 == 0) {//都为偶数
//                temp2--;
//            }else if (n1 == 1 && n2 == 0) {//前奇后偶
//                temp1++;
//                temp2--;
//            }else if (n1 == 0 && n2 == 1) {//前偶后奇。交换
//                int temp = nums[temp1];
//                nums[temp1] = nums[temp2];
//                nums[temp2] = temp;
//            }
//        }
//        return nums;
//    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if ((nums[left] & 1) != 0) {//左边为奇数
                left++;
                continue;
            }
            if ((nums[right] & 1) == 0) {//右边为偶数
                right--;
                continue;
            }
            int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(arr)));
    }
}
