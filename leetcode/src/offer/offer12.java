package offer;
/*
剑指 Offer 12. 矩阵中的路径
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
  A.      B.      C.      E
  S       F       C.      S
  A       D.      E.      E

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
 */
class offer12 {
    /**
     * 递推工作：
     *     1. 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问
     *     2. 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），
     *          并记录结果至 res
     *     3. 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k]
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k
     * @return
     */
    public static  boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //i,j越界 或者 当前字符不匹配 直接return false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {//所有字符都匹配完成
            return true;
        }
        board[i][j] = '\0';//不匹配时字符置为空，防止重复匹配
        //按照 上 下 右 左 的方向查找
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        //还原当前矩阵元素
        board[i][j] = word[k];
        return res;

    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED"));
    }

}
