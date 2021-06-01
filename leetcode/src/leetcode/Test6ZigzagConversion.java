package leetcode;

import java.util.ArrayList;
import java.util.List;

/** Z字型变换

 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Test6ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = convert(s, 3);
        System.out.println(convert);

    }
    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int curRow = 0;
        boolean isTurn = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1) {
                isTurn = !isTurn;
            }
            curRow += isTurn ? 1 : -1;
        }

        StringBuilder builder = new StringBuilder();
        for(StringBuilder bu : list){
            builder.append(bu);
        }
        return builder.toString();
    }
}
