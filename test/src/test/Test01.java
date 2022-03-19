package test;

class A {
    static {
        System.out.println("bootstrap F init");
    }
}
public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("test.A");
        System.out.println(aClass.getClassLoader());
    }
}
