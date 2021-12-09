public class 背包问题_1 {
    static int N;
    static int C;
    static int[][] dp = new int[N][C+1];

    /**
     * 二维数组法
     * @param N
     * @param C
     * @param v
     * @param w
     * @return
     */
    public int maxValue(int N, int C, int[] v, int[] w){

        for (int i = 0; i < C + 1; i++) {
            dp[0][i] = i>=v[0] ? w[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C+1; j++) {
                int x = dp[i-1][j];
                int y = j>v[i] ? dp[i-1][j-v[i]]+w[i]:0;
                dp[i][j] = Math.max(x,y);
            }
        }

        return dp[N-1][C];
    }

    /**
     * 优化后的两列数组版
     * @param N
     * @param C
     * @param v
     * @param w
     * @return
     */

    public int maxValue2(int N, int C, int[] v, int[] w){
        for (int i = 0; i < C + 1; i++) {
            dp[0][i] = i>=v[0] ? w[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C + 1; j++) {
                int x = dp[(i-1)&1][j];
                int y = j>v[i]? dp[(i-1)&1][j-v[i]]+w[i]:0;
                dp[i&1][j] = Math.max(x, y);
            }
        }

        return dp[N-1][C];

    }



}
