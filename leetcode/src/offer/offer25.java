package offer;

/*剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000
 */
// Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class offer25 {
     
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return null;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

    }
}
