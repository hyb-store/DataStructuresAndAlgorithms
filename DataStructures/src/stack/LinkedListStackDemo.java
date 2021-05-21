package stack;

//练习：单向链表实现栈
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();

        //入栈
        linkedListStack.push(new LinkedListNode(3));
        linkedListStack.push(new LinkedListNode(6));
        linkedListStack.push(new LinkedListNode(9));
        linkedListStack.push(new LinkedListNode(12));
        linkedListStack.push(new LinkedListNode(85));

        //遍历
        System.out.println("遍历：");
        linkedListStack.list();

        //出栈
        System.out.println("出栈");
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();

        System.out.println("遍历");
        linkedListStack.list();

        System.out.println("继续出栈");
        linkedListStack.pop();
        linkedListStack.pop();

    }
}

class LinkedListStack{

    private LinkedListNode head = new LinkedListNode(0);

    //获取头结点
    public LinkedListNode getHead(){
        return head;
    }

    //判断是否为空
    public boolean isEmpty(){
        if(head.next == null){
            return true;
        }else{
            return false;
        }
    }

    //入栈 push    头插法
    public void push(LinkedListNode newNode){
        LinkedListNode temp = head;
        if(isEmpty()){
            head.next = newNode;
        }else{
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    //出栈 pop
    public void pop(){
        int value;
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }else {
            value = head.next.num;
            head.next = head.next.next;
        }
        System.out.println(value);
    }

    //遍历
    public void list(){
        LinkedListNode temp = head;
        if(isEmpty()) {
            System.out.println("栈为空");
        }else {
            while (temp.next != null) {
                System.out.println(temp.next.num);
                temp = temp.next;
            }
        }
    }


}

class LinkedListNode{

    public int num; //存储数据
    public LinkedListNode next;//指向下一个节点

    public LinkedListNode(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "num=" + num +
                ", next=" + next +
                '}';
    }
}