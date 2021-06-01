package leetcode;

/** 2.
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储 一位 数字。
 *   请你将两个数相加，并以相同形式返回一个表示和的链表。
 *   你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Test2Add2Num {

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));

        ListNode temp = addTwoNumbers(l1, l2);
        while (temp.next != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode temp = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 +carry;

            if(resultNode == null) {
                resultNode = temp = new ListNode(sum % 10);
            }else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry > 0) {
            temp.next = new ListNode(carry);
        }
        return resultNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}