package kmp;

import java.util.Arrays;

public class KMPAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABC";
        //String str2 = "BBC";

        int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
//        int[] next = kmpNext("AAACDAAAD"); //[0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));
    }

    /**写出我们的kmp搜索算法
     *
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历
        for(int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            //KMP算法核心点, 可以验证...
            while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if(j == str2.length()) {//找到了 // j = 3 i
                return i - j + 1;
            }
        }
        return  -1;
    }

    /**
     *  j首先固定为首位A位置，i向后找，当找到的字符不等于A，next【i】置为0，当找到等于A的字符后，j后移到B，i继续向后找，
     *  看A下一个字母是否和j后移后的字符相等。当不等时，j = next[j-1]
     * @param dest
     * @return
     */
    //获取到一个字符串(子串) 的部分匹配值表
    public static  int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for(int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];//当遇到无法匹配的字母时，j不停的向前回退，找到和i字符相同的的字符，
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
