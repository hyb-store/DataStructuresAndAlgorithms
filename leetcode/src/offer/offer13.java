package offer;

import java.util.LinkedList;
import java.util.Queue;

/*剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

示例 1：
输入：m = 2, n = 3, k = 1
输出：3

示例 2：
输入：m = 3, n = 1, k = 0
输出：1

提示：
1 <= n,m <= 100
0 <= k <= 20
 */
public class offer13 {

//    //************方法一核心：仅通过向右和向下移动，就可以访问所有可达解 ******************************************
//    /**                             深度优先遍历 DFS
//     * 算法解析：
//     *      递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
//     *      终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访问过时，返回 0 ，代表不计入可达解。
//     *      递推工作：
//     *          1.标记当前单元格 ：将索引 (i, j) 存入 visited 中，代表此单元格已被访问过。
//     *          2.搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
//     *      回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
//     */
//    int m, n, k;
//    boolean[][] visited ;
//    /**
//     * @param m 矩阵行
//     * @param n 矩阵列
//     * @param k target
//     * @return
//     */
//    public int movingCount(int m, int n, int k) {
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        this.visited = new boolean[m][n];
//        return dfs(0, 0, 0, 0);
//    }
//    /**
//     * @param i 行
//     * @param j 列
//     * @param si 行坐标的数位之和
//     * @param sj 列坐标的数位之和
//     * @return
//     */
//    public int dfs(int i, int j, int si, int sj) {
//        //如果当前位置越界，或者 位数和超过k，或者访问过
//        if (i >= m || j >= n || k < si + sj || visited[i][j]) {
//            return 0;
//        }
//        visited[i][j] = true;
//        //1 + 向右的数量 + 向下的数量
//        return 1 + dfs(i, j + 1, (j + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
//                dfs(i + 1, j, si, (i + 1) % 10 != 0 ? sj + 1 : sj - 8);
//    }

    //**************************************方法二 ：将当前元素的 下方、右方 单元格的索引、数位和加入queue  *************

    /**  广度优先遍历 BFS
     * @param m 矩阵行
     * @param n 矩阵列
     * @param k target
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        // 数组元素为 当前索引 i,j 以及 数位和si，sj
        queue.add(new int[] { 0, 0, 0, 0 });

        while (queue.size() > 0 ) {
            //将队列首位元素取出
            int[] poll = queue.poll();
            //取出首位元素的位置以及数位和
            int i = poll[0], j = poll[1], si = poll[2], sj = poll[3];
            //如果越界，或者访问过了
            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            //向下
            queue.add(new int[]{ i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            //向右
            queue.add(new int[]{ i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }

    public static void main(String[] args) {
        offer13 offer13 = new offer13();
        int i = offer13.movingCount(2, 3, 1);
        System.out.println(i);
    }
}
