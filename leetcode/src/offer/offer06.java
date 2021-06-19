package offer;
/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

输入：head = [1,3,2]
输出：[2,3,1]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Definition for singly-linked list.
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}
public class offer06 {
    public static int[] reversePrint(ListNode1 head) {
        ListNode1 temp = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(1);
        ListNode1 node2 = new ListNode1(3);
        ListNode1 node3 = new ListNode1(2);

        node1.next = node2;
        node2.next = node3;

        System.out.println(Arrays.toString(reversePrint(node1)));
    }
}
