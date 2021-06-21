package offer;

import java.util.Stack;

/*剑指 Offer 30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();      --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();      --> 返回 -2.
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> A,B;

    public MinStack() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x) { //避免重复最小值被弹出
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
public class offer30 {

    public static void main(String[] args) {
        //Your MinStack object will be instantiated and called as such:
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("min:"+minStack.min());   //--> 返回 -3.
        minStack.pop();
        System.out.println("top:"+minStack.top());;      //--> 返回 0.
        System.out.println("min:"+minStack.min());;   //--> 返回 -2.
    }
}
