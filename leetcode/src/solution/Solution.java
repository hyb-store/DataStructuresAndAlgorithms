package solution;

import java.util.Scanner;

/*7-2 实现一个五边形 (10分)
        从下列的抽象类shape类扩展出一个正五边形（regular pentagon）类RPentagon,
        这个类将正五边形的边长作为私有成员，类中包含初始化这个值的构造方法。

public abstract class shape {//抽象类
    抽象方法 求面积  public abstract double getArea();
    抽象方法 求周长  public abstract double getPerimeter(); }
        请编程从键盘输入正五边形的边长值，创建一个正五边形对象，然后输出正五边形的面积和正五边形的周长。
        计算正五边形的面积公式为： S=5a^2/(4tan(36度))其中a为边长。 或者：S=(1/4)a^2√(25+10√5) 输出结果保留4位小数。
        输入正五边形的边长。例如：5
        输出正五边形的面积和周长。第一行输出面积，第二行输出周长。例如： 43.0119 25
        输入样例:16.8
        输出样例:485.58754154223004     84.0
*/
import java.util.Scanner;

class Circle
{
    private double radius;
    public Circle(double radius) {this.radius = radius;}
    public double getRadius() {
        return radius
                ;}
    public void setRadius(double radius) {
        this.radius = radius
        ;}
    public double getArea() {return
            3.14*radius*radius
            ;}
}

class Cylinder
        extends
        Circle
{
    double height =100;
    public Cylinder(double radius,double height) {super(radius); this.height = height ;}
    public double getVolumn() {
        return getArea()  * height;
    }
}

 class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        double radius = sc.nextDouble();
        Cylinder obj = new Cylinder(radius, height);
        System.out.printf("Cylinder obj Volumn is %.2f",
                obj.getVolumn()
        );
    }
}
public class Solution {

}