package offer;

import java.util.HashMap;
import java.util.Map;

/*剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:
s = "abaccdeff"
返回 "b"

s = ""
返回 " "
 */
public class offer50 {

//    public static char firstUniqChar(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {//不包含
//                map.put(s.charAt(i),1);
//            } else {
//                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
//            }
//        }
//        for (int j = 0; j < s.length(); j++) {
//            if (map.get(s.charAt(j)) == 1) {
//                return s.charAt(j);
//            }
//        }
//        return ' ';
//    }

    public static char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new HashMap<>();

        char[] array = s.toCharArray();

        for (char c : array) {
            dic.put(c, !dic.containsKey(c));//包含1个为true ，2个以上为false
        }

        for (char c : array) {
            if (dic.get(c)) return c;
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));

    }
}
