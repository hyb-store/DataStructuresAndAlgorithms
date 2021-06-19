package offer;

/*剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
// Definition for singly-linked list.
class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode3{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
public class offer24 {

//    public static ListNode3 reverseList(ListNode3 head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode3 newHead = new ListNode3(0);//新链表头结点
//        ListNode3 cur = head;//当前节点
//        ListNode3 next = null;//cur节点的下一个节点
//
//        while (cur != null) {
//            next = cur.next;//保存当前节点的下一个节点
//            cur.next = newHead.next;
//            newHead.next = cur;
//            cur = next;
//        }
//        return newHead.next;
//    }

    //迭代，原地翻转，三个指针，前一个，当前，以及下一个节点
    public static ListNode3 reverseList(ListNode3 head) {
        ListNode3 prev = null;
        ListNode3 curr = head;
        while (curr != null) {
            ListNode3 next = curr.next;//保存下一个节点
            curr.next = prev;
            prev = curr;
            curr = next;//指针后移
        }
        return prev;
    }


//    //递归
//    public static ListNode3 reverseList(ListNode3 head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode3 newHead = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }

    public static void main(String[] args) {
        ListNode3 node1 = new ListNode3(1);
        ListNode3 node2 = new ListNode3(2);
        ListNode3 node3 = new ListNode3(3);
        ListNode3 node4 = new ListNode3(4);
        ListNode3 node5 = new ListNode3(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseList(node1));

    }
}
