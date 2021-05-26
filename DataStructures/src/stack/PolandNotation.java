package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 后缀表达式   逆波兰表达式
 * (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 -
 * 1.从左至右扫描，将3和4压入堆栈；
 * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
 * 3.将5入栈；
 * 4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
 * 5.将6入栈；
 * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果
 */
public class PolandNotation {

    public static void main(String[] args) {

        //先定义逆波兰表达式
        String suffixExpression = "3 4 + 5 × 6 -";

        //1. 先将 "3 4 + 5 × 6 - " => 放到ArrayList中
        //2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
    }


    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;

    }
}
