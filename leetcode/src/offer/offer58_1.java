package offer;

import java.util.Arrays;

/*剑指 Offer 58 - I. 翻转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
例如输入字符串"I am a student. "，则输出"student. a am I"。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class offer58_1 {

    public  static String reverseWords(String s) {
       int i = s.length() - 1,j = i;
       StringBuilder sb = new StringBuilder();

       s.trim();//去掉首尾空格
        while (i >= 0) {
            //从右向左找第一个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i+1, j+1) + " ");//起始索引（包括）,结束索引（不包括）
            while(i >= 0 && s.charAt(i) == ' ') {//跳过空格，到下个单词的末尾
                i--;
            }
            j = i;//j指向i，下个单词的末尾
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "a good   example";
        String s = reverseWords(str);
        System.out.println(s);
    }
}