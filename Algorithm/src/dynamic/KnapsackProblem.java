package dynamic;

/**
 * 背包问题：有一个背包，容量为4磅 ， 现有如下物品
 *
 *  物品	   重量	价格
 * 吉他(G)	1	1500
 * 音响(S)	4	3000
 * 电脑(L)	3	2000
 *
 * 要求达到的目标为装入的背包的总价值最大，并且重量不超出
 * 要求装入的物品不能重复
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值 这里val[i] 就是前面讲的v[i]
        int m = 4; //背包的容量
        int n = val.length; //物品的个数

        //创建二维数组，
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列, 这里在本程序中，可以不去处理，因为默认就是0
        for(int i = 0; i < v.length; i++) {
            v[i][0] = 0; //将第一列设置为0
        }
        for(int i=0; i < v[0].length; i++) {
            v[0][i] = 0; //将第一行设置0 (等于没有物品时，物品价值都为0)
        }

//        0 0 0 0 0
//        0 0 0 0 0
//        0 0 0 0 0
//        0 0 0 0 0


        //根据全面得到的公式来进行动态规划处理
        for (int i = 1; i < v.length; i++) { // 不处理第0行
            for (int j = 1; j < v[0].length; j++) { // 不处理第0列
                //公式
                // 新加的物品大于背包容量
                if(w[i-1]> j) { // 因为我们程序i 是从1开始的，因此原来公式中的 w[i] 修改成 w[i-1]
                    v[i][j]=v[i-1][j]; //直接使用上一个单元格的装入策略
                } else {
                    //说明:
                    //因为我们的i 从1开始的， 因此公式需要调整成
                    //v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if-else来体现公式
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //当新加物品的价值（原背包容量最大价值+新加的物品价值） > 原背包最大价值（新物品加不进去）把当前的情况记录到path
                        path[i][j] = 1;  //意味着 背包容量为j时，加了i
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下v 看看目前的情况v
        for(int i =0; i < v.length;i++) {
            for(int j = 0; j < v[i].length;j++) {
                System.out.printf("%-5s",v[i][j]);
            }
            System.out.println();
        }

        //动脑筋
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //从path的最后开始找
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //  背包容量 - 当前这一行所代表的物品重量
            }
            i--;
        }
    }
}
