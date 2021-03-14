package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
学术会议地点统计问题
秘书统计张教授[以后简称z]和王教授[以后简称w ]上一 年度参加学术会议的情况，教
授详细行程清单如下:
z:bj 3,hz 2,qd 4,nj 5,wh 3,bj 3
w:hn 7,xm 6,bj 4,gz 6,wh 4
现在秘书需要完成以下统计工作。找出两位教授共同去过的城市，并找出住宿天数长的教
授，按照如下格式输出:z:bj 6,wwh4
请同学们编写代码帮助搞定。
输入格式:
固定为2行
[数据说明]冒号前面为教授简称，冒号后面为会议详情，分组内使用空格分开，左边为城
市地点简称，右边为住宿天数，多个分组之间使用逗号分开[以上字符均为西文] (测试数
据经过专门处理，不存在共同去过的城市有相同天数的情况)
输出格式:
固定为1行
由0个或者多个记录组成，记录格式为:
教授简称冒号城市简称空格天数
多个记录之间使用逗号分开，最后-个记录末尾没有逗号
如果0个记录时，输出none
[输出顺序说明]输出按照城市地点简称字母升序排序
[输出内容说明]如果没有共同去过的城市，输出为none四个字母，两边均无空格
输入样例:
在这里给出一组输入。例如:
z:bj 3,hz 2,qd 4,nj 5,wh 3,bj 3w:hn 7,xm 6,bj 4,gz 6,wh 4输出样例:
在这里给出相应的输出。例如:
z:bi 6,w:wh 4

 */
public class Solution02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> z = new HashMap<>();
        Map<String,Integer> w = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            String ss = sc.nextLine();
            String[] split = ss.split(":");
            String[] place = split[1].split(",");
            for (int j = 0; j < place.length; j++) {
                String[] cityday = place[j].split(" ");
                if(i == 0) {
                    if (!z.containsKey(cityday[0])){
                        z.put(cityday[0],Integer.parseInt(cityday[1]));
                    }else{
                        z.put(cityday[0],Integer.parseInt(cityday[1])+z.get(cityday[0]));
                    }

                }else {
                    if (!w.containsKey(cityday[0])){
                        w.put(cityday[0],Integer.parseInt(cityday[1]));
                    }else{
                        w.put(cityday[0],Integer.parseInt(cityday[1])+w.get(cityday[0]));
                    }
                }
            }
        }
//        Set<String> set1 = w.keySet();
//        for (String key : set1) {
//            System.out.println(key+"=="+w.get(key));
//        }
        String maxkeyz = null;
        String maxkeyw = null;
        Set<String> set = w.keySet();
        for (String key : set) {
               if(z.containsKey(key)) {
                   if(z.get(key) < w.get(key)) {
                       maxkeyw = key;
                   }else {
                       maxkeyz = key;
                   }
               }else{

               }
        }
        //System.out.println(maxkeyw+"--"+maxkeyz);
        if (maxkeyw == null && maxkeyz == null) {
            System.out.println("none");
        }else{
            if (maxkeyz.compareTo(maxkeyw) < 0) {
                System.out.print("z:"+maxkeyz+" "+z.get(maxkeyz)+",");
                System.out.print("w:"+maxkeyw+" "+w.get(maxkeyw));
            }else if(maxkeyz.compareTo(maxkeyw) > 0){
                System.out.print("w:"+maxkeyw+" "+w.get(maxkeyw)+",");
                System.out.print("z:"+maxkeyz+" "+z.get(maxkeyz));
            }
        }

    }

}
