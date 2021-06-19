package offer;

import java.util.HashMap;
import java.util.Map;
/**有限状态自动机*/
/*
剑指 Offer 20. 表示数值的字符串.请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：
    若干空格
    一个 小数 或者 整数
    （可选）一个 'e' 或 'E' ，后面跟着一个 整数
    若干空格
小数（按顺序）可以分成以下几个部分：
    （可选）一个符号字符（'+' 或 '-'）
    下述格式之一：
    至少一位数字，后面跟着一个点 '.'
    至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
    一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：
    （可选）一个符号字符（'+' 或 '-'）
    至少一位数字
部分数值列举如下：
    ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：
    ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 */
public class offer20 {
    public static boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.开始的空格
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.幂符号前的正负号
                new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.小数点前的数字
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.小数点、小数点后的数字
                new HashMap<Character, Integer>() {{ put('d', 3); }},                                        // 4.当小数点前为空格时，小数点、小数点后的数字
                new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.幂符号
                new HashMap<Character, Integer>() {{ put('d', 7); }},                                        // 6.幂符号后的正负号
                new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.幂符号后的数字
                new HashMap<Character, Integer>() {{ put(' ', 8); }}                                         // 8.结尾的空格
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;        //合法的结束状态有 2, 3, 7, 8
    }
    public static void main(String[] args) {
        System.out.println(isNumber("12e+5.4"));


    }
}
