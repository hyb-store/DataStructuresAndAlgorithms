package stack;

public class ArrayStackDemo {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);

        //入栈-push
        arrayStack.push(1);
        arrayStack.push(4);
        arrayStack.push(7);
        arrayStack.push(11);

        System.out.println("遍历：");
        arrayStack.list();

        //出栈 pop
        System.out.println("第1个出栈元素为："+arrayStack.pop());//第1个出栈元素为：11
        System.out.println("第2个出栈元素为："+arrayStack.pop());//第2个出栈元素为：7
        System.out.println("第3个出栈元素为："+arrayStack.pop());//第3个出栈元素为：4

        System.out.println("当前栈内元素为：");
        arrayStack.list();//stack[0]=1
        System.out.println("继续出栈：");

        System.out.println("第4个出栈元素为："+arrayStack.pop());//第4个出栈元素为：1
        System.out.println("第5个出栈元素为："+arrayStack.pop());//Exception in thread "main" java.lang.RuntimeException: 栈空，没有数据~


    }
}

//定义一个ArrayStack表示栈
class ArrayStack{

    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}