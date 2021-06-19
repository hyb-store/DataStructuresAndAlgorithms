package offer;

/*剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
 */


//Definition for singly-linked list.
class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4(int x) { val = x; }
}

public class offer22 {
//    public static ListNode4 getKthFromEnd(ListNode4 head, int k) {
//        int count = 0;
//        ListNode4 temp = head;
//        while (temp != null) { // 找到链表总长度
//            count++;
//            temp = temp.next;
//        }
//        System.out.println(count);
//
//        temp = head;
//        for (int i = 0; i < count - k; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }

    /**
     *former和latter之间的距离，即为k，当former走到最后一位，latter即为倒数第k位
     */
    public static ListNode4 getKthFromEnd(ListNode4 head, int k) {
        ListNode4 former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
    public static void main(String[] args) {
        ListNode4 node1 = new ListNode4(1);
        ListNode4 node2 = new ListNode4(2);
        ListNode4 node3 = new ListNode4(3);
        ListNode4 node4 = new ListNode4(4);
        ListNode4 node5 = new ListNode4(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(getKthFromEnd(node1, 5).val);
    }
}
