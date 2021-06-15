package offer;
/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 */
public class offer05 {
    public static String replaceSpace(String s) {
        return s.replace(" ","%20");

    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

}
