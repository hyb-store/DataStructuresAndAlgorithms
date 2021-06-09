package huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("压缩前编码长度：" + contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);


    }
    /**
     * @param bytes 接收字节数组
     * @return 返回的就是List形式   [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......],
     */
    public static List<Node> getNodes (byte[] bytes) {
        //1.创建一个ArrayLi
        ArrayList<Node> nodes = new ArrayList<Node>();

        //遍历 bytes,统计每一个byte出现的次数->map[key,value]
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer count = map.get(b);//取出该字符出现的次数
            if (count == null) {//首次放入
                map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }
        System.out.println(map);

        //把每一个键值对转成一个Node 对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}

//创建Node ,待数据和权值
class Node implements Comparable<Node>  {
    Byte data; // 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    int weight; //权值, 表示字符出现的次数
    Node left;
    Node right;
    public Node(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}
