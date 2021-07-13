package offer;

/*剑指 Offer 52. 两个链表的第一个公共节点
输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：
A:        a1 -> a2 ->
                        c1 -> c2 -> c3
B:  b1 -> b2 -> b3 ->
在节点 c1 开始相交。

示例 1：
A:      4 -> 1 ->
                    8 -> 4 -> 5
B: 5 -> 0 -> 1 ->
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

示例 2：
A: 0 -> 9 -> 1 ->
                    2 -> 4
B:           3 ->
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

示例 3：
A: 2 -> 6 -> 4
B: 1 -> 5
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。

注意：
1.如果两个链表没有交点，返回 null.
2.在返回结果后，两个链表仍须保持原有的结构。
3.可假定整个链表结构中没有循环。
4.程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
 */
public class offer52 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode tempA = headA;
//        ListNode tempB = headB;
//
//        while (tempA != tempB) {
//            if (tempA.next == null) {
//                tempA.next = headB;
//            }
//            if (tempB.next == null) {
//                tempB.next = headA; //错误的，当B走到最后时，将B.next设置为headA。会将A与B链表连起来，使得之后循环tempA.next == null无法生效
//            }
//            tempA = tempA.next;
//            tempB = tempB.next;
//        }
//        return tempB;

        ListNode A = headA, B = headB;
        while (A != B) { //遍历完一个链表继续遍历下一个，当 A=B是，刚好相遇且为第一个共同节点
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(4);

        //公共部分
        listNode5.next = listNode6;

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode5;

        listNode4.next = listNode5;

        System.out.println(getIntersectionNode(listNode1, listNode4).val);


    }
}
