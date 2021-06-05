package tree;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        //以ArrayList 为例，看看底层怎样进行数组扩容的
        ArrayList arrayList = new ArrayList();

        //ArrayList 维护了数组 transient Object[] elementData;

        //ArrayList底层进行了数组扩容
    }
}
