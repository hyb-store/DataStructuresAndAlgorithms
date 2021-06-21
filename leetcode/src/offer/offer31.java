package offer;

import java.util.Stack;

/*剑指 Offer 31. 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5}
是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
 */
public class offer31 {
    /**
     * 入栈操作： 按照压栈序列的顺序执行。
     * 出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
     * @param pushed
     * @param popped
     * @return 若 stackstack 为空，则此弹出序列合法
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int temp = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[temp]) {
                stack.pop();
                temp++;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {

        System.out.println(validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));


    }
}
