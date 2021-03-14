package offer;
/*
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。

现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。

 */
public class offer04 {
    
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length - 1,n = 0;
        while(m >= 0 && n <= matrix[0].length-1) {
            if(matrix[m][n] > target) {
                m = m - 1;
            }
            else if(matrix[m][n] < target) {
                n = n + 1;
            }
            else if(matrix[m][n] == target){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] a = {{1,4,7,11,15},
                    {2,5,8,12,19},
                    {3,6,9,16,22},
                    {10,13,14,17,24},
                    {18,21,23,26,30}};
        System.out.println(new offer04().findNumberIn2DArray(a, 5));
        int[] x = new int[10];
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
}
