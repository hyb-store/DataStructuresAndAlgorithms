package solution;

import java.util.*;

public class Solution01 {
    public static String formate(String s) {//输入处理函数
        String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '!'||s.charAt(i) == '.'||s.charAt(i) == ','||s.charAt(i) == ':'||s.charAt(i) == '*'||s.charAt(i) == '?')
                continue;
            else {
                sb.append(s.charAt(i));
            }
        }
        str = sb.toString();//把其转回String类型
        str = str.toLowerCase();//全部转化为小写
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> hashmap = new HashMap<String,Integer>();
        //工作1：读入处理好的数据
        while(true) {
            String ss = sc.nextLine();
            //Set<String> wordSet = hashmap.keySet();
            if(ss.equals("!!!!!"))
                break;
           /* if (ss !=null && ss.equals(""))
                continue;*/
            String[] lineWords=ss.split(" ");//用非单词符来做分割，分割出来的就是一个个单词
            for(int i = 0;i < lineWords.length;i++) {
                String str = formate(lineWords[i]);
                if(str == null ||str.length() == 0) continue;
                if(!hashmap.containsKey(str))
                    hashmap.put(str, 1);
                else {
                    int num = hashmap.get(str);
                    num++;
                    hashmap.put(str, num);
                }
            }
        }
        //工作2：进行排序
        List<Map.Entry<String, Integer>> lis = new ArrayList<Map.Entry<String, Integer>>(hashmap.entrySet());
        Collections.sort(lis, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() - e2.getValue() != 0)//次序不同就降序排列
                    return e2.getValue().compareTo(e1.getValue());
                else
                    return e1.getKey().compareTo(e2.getKey());//次序相同就升序排列
                //return e1.getValue().compareTo(e2.getValue());
            }
        });

        //工作3：处理输出
        System.out.println(hashmap.size());
        int num = 0;
        for (Map.Entry<String, Integer> map : lis) {
            System.out.println(map.getKey() + "=" + map.getValue());
            num ++;
            if(num == 10)
                break;
        }
        /*
        Iterator<String> it=hashmap.keySet().iterator();
    	while(it.hasNext())
    	{
    		String word=it.next();
    		System.out.println(word+"="+hashmap.get(word));
    	}
    	*/

        sc.close();


    }

}
