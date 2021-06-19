package offer;
/*
剑指 Offer 18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
注意：此题对比原题有改动

示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

示例 2:
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

说明：
题目保证链表中节点的值互不相同。若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */

//Definition for singly-linked list.
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode2{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
public class offer18 {

    public static ListNode2 deleteNode(ListNode2 head, int val) {
        ListNode2 temp = head;
        if (head.val == val) {
            return head.next;
        }
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode2 node1  = new ListNode2(4);
        ListNode2 node2  = new ListNode2(5);
        ListNode2 node3  = new ListNode2(1);
        ListNode2 node4  = new ListNode2(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteNode(node1,9);
        System.out.println(node1);

    }
}
