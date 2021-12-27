public class 背包问题_2 {

    public static int maxValue(int N, int C, int[] v,int[] w){
        int[][] dp = new int[N][C+1];
        for (int i = 1; i < C+1; i++) {
            int k = i/v[0];
            int value = v[0] * k;
            dp[0][i] = value;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C+1; j++) {
                int max = 0;
                for (int k = 0; v[i] *k < j; k++) {
                    max = Math.max(dp[i-1][j-k*v[i]]+ k * w[i],max);
                }

                dp[i][j] = max;
            }

        }
        return dp[N-1][C];
    }



    //滚动数组法
    public static int maxValue2(int N, int C,int[] v, int[] w){

        int[][] dp = new int[2][C+1];
        for (int i = 1; i < C+1; i++) {
            int k = i/v[0];
            dp[0][i] = k*v[0];
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C+1; j++) {

                int max = 0;
                for (int k = 0; k *v[i] < j; k++) {
                    max = Math.max(max,dp[(i-1)%2][j-k*v[i]]+ k * w[i]);
                }

                dp[(i%2)][j] = max;

            }
        }

        return dp[(N-1)%2][C];
    }
    //dp[i][j] = max(d[i-1][j],dp[i-1][j-v[i]]+w[i],dp[i-1][j-2*v[i]]+2*w[i],...,dp[i-1][j-k*v[i]]+k*w[i]), 0<=k*v[i] <=j
    //dp[i][j-v[i]] = max(dp[i][j-v[i]],dp[i-1][j-2*v[i]]+w[i],..,dp[i-1][j-k*v[i]]+k*w[i]), 0<=k*v[i] <=j
    //简化为一维数组 dp[i][j] = max(dp[i-1][j]，dp[i][j-v[i]]+w[i])
    public static int maxValue3(int N, int C,int[] v, int[] w){
        int[] dp = new int[C+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C+1; j++) {
                int n = dp[j];

                int y = j - v[i] >= 0? dp[j - v[i]] + w[i] : 0;
                dp[j] = Math.max(n,y);
            }
        }
        return dp[C];
    }


    public static void main(String[] args) {
        int[] v = new int[]{1,2};
        int[] w = new int[]{1,2};
        System.out.println("原始方法"+maxValue(2, 5, v, w));
        System.out.println("滚动数组答案"+maxValue2(2,5,v,w));
        System.out.println("一维数组答案"+maxValue3(2,5,v,w));
    }
}
