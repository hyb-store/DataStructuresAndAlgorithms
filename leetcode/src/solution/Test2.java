package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 生成预测分析表
 */
public class Test2 {
    public static void main(String[] args) {
        //终结符
        String[] terminal = {"i","+","*","(",")"};
        //非终结符
        String[] nonTerminal = {"E","E'","T","T'","F"};

        //输入文法
        Map<String,String[]> map = new HashMap<String,String[]>();
        map.put("E", new String[]{"TE'"});
        map.put("E'", new String[]{"+TE'","ε"});
        map.put("T", new String[]{"FT'"});
        map.put("T'", new String[]{"*FT'","ε"});
        map.put("F", new String[]{"(E)","i"});
//        for (String s : map.keySet()) {
//            System.out.println(s+ Arrays.toString(map.get(s)));
//        }

        //First集
        Map<String,String[]> first = new HashMap<>();
        first.put("E", new String[]{"(","i"});
        first.put("E'", new String[]{"+","ε"});
        first.put("T", new String[]{"(","i"});
        first.put("T'", new String[]{"*","ε"});
        first.put("F", new String[]{"(","i"});

        //Follow集
        Map<String,String[]> follow = new HashMap<>();
        follow.put("E", new String[]{")","#"});
        follow.put("E'", new String[]{")","#"});
        follow.put("T", new String[]{"+",")","#"});
        follow.put("T'", new String[]{"+",")","#"});
        follow.put("F", new String[]{"*","+",")","#"});

        //System.out.println(contain(new String[]{"*FT'","ε"},"*FT'"));

        //创建预测分析表
        String[][] table = new String[nonTerminal.length+1][terminal.length+2];
        //放置非终结符
        for (int i = 0; i < nonTerminal.length; i++) {
            table[i+1][0] = nonTerminal[i];
        }
        //放置终结符
        for (int j = 0; j < terminal.length; j++) {
            table[0][j+1] = terminal[j];
        }
        table[0][table[0].length-1] = "#";

        //填入
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (contain(first.get(table[i][0]),"ε")) {//先判断first集中有无ε，有就需要考虑follow
                    if (contain(first.get(table[i][0]),table[0][j]) ||  contain(follow.get(table[i][0]),table[0][j])) {//如果first集或者follow集中有这个终结符，就赋值
                        table[i][j] = table[i][0]+"->"+judge(map.get(table[i][0]),table[0][j]);
                    }
                }else if (contain(first.get(table[i][0]),table[0][j])) {//判断first集中有无该非终结符
                    if(table[i][j] == null){  //如果没有被赋值
//                        if (map.get(table[i][0]).length == 1) { //如果原产生式只能推导出一个式子，直接存
//                            table[i][j] = table[i][0]+"->"+map.get(table[i][0])[0];
//                        }else if(map.get(table[i][0]).length > 1) {// 如果有多个式子，则判断该用哪个式子
                            table[i][j] = table[i][0]+"->"+judge(map.get(table[i][0]),table[0][j]);
//                        }
                    }
                }
//                if (contain(first.get(table[i][0]),table[0][j]) && contain(first.get(table[i][0]),"ε")) {//判断first集中有无该非终结符,且first集中有ε,需要考虑follow
//                    if (map.get(table[i][0]).length == 1) { //如果原产生式只能推导出一个式子，直接存
//                        table[i][j] = table[i][0]+"->"+map.get(table[i][0])[0];
//                    }else if(map.get(table[i][0]).length > 1) {// 如果有多个式子，则判断该用哪个式子
//                        table[i][j] = table[i][0]+"->"+judge(map.get(table[i][0]),table[0][j]);
//                    }
//
//                }else if (contain(first.get(table[i][0]),table[0][j])) {//判断first集中有无该非终结符
//                    if(table[i][j] == null){  //如果没有被赋值
//                        if (map.get(table[i][0]).length == 1) { //如果原产生式只能推导出一个式子，直接存
//                            table[i][j] = table[i][0]+"->"+map.get(table[i][0])[0];
//                        }else if(map.get(table[i][0]).length > 1) {// 如果有多个式子，则判断该用哪个式子
//                            table[i][j] = table[i][0]+"->"+judge(map.get(table[i][0]),table[0][j]);
//                        }
//                    }
//                }
            }
        }

        //处理。null变“ ”
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if(table[i][j] == null)
                    table[i][j] = "";
            }
        }

        //遍历表
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.printf("%-15s",table[i][j]);
            }
            System.out.println();
        }
        //System.out.println(judge( new String[]{"+TE'","ε"}, ")"));
    }

    //判断该返回哪个产生式
    public static String judge (String[] strings, String s) {
        String temp = strings[0];
        if (s.equals("#")) {
            return "ε";
        }
        for (String string : strings) {
            if ((string.charAt(0)+"").equals(s)) {//遍历String数组，如果首个字符 与 该非终结符 一样，直接返回
                return string;
            }else {
                temp = string;
            }
        }
        return temp;
    }

    //判断该String[] 有没有该String
    public static boolean contain (String[] strings, String s) {
        if (strings.length == 0) {
            return false;
        }
        for (String string : strings) {
            if(string.equals(s))
                return true;
        }
        return false;
    }

}
