package dac;

/**
 * 汉诺塔
 */
public class HanoiTowerDemo {

    public static void main(String[] args) {
        HanoiTower(2,'A','B','C');

    }

    /**
     * @param n 盘子个数
     * @param a 柱子
     * @param b 柱子
     * @param c 柱子
     */
    public static void HanoiTower(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("第"+1+"个盘子  "+""+a+"->"+c);
            return;
        }
        //先将A上边除了最下面的盘子之外所有盘子通过c移动到b
        HanoiTower(n - 1, a, c, b);

        //将A最下边一个移动到c
        System.out.println("第"+n+"个盘子  "+""+a+"->"+c);

        //将B中所有盘子移到C的一个盘子上
        HanoiTower(n - 1, b, a, c);
    }
}
