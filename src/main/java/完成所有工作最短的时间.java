public class 完成所有工作最短的时间 {
    static int[] jobs;
    static int n,k;
    static int ans = Integer.MAX_VALUE;
    public static int minimumTimeRequired(int[] _jobs, int _k) {
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs2(0, sum, 0,0);
        return ans;
    }

    static void dfs(int u, int[] sum, int max){
        if(max>=ans){
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"被抛弃");
            return;
        }
        if(u==n){
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"返回");
            ans = max;
            return;
        }
        for (int i = 0; i < k; i++) {

            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]);
            sum[i] += jobs[u];
            dfs(u+1,sum,Math.max(sum[i],max));
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"所有的可能性都已经被探索了，返回");
            sum[i] -= jobs[u];

        }







    }


    /**
     * 多了一步 优先分配给空闲的工人
     * @param u 分配到第几个任务
     * @param sum
     * @param max
     * @param worker_id 分配到的工人的id
     */
    static void dfs2(int u, int[] sum, int max, int worker_id){
        if(max>=ans){
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"被抛弃");
            return;
        }
        if(u==n){
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"返回");
            ans = max;
            return;
        }

        if(worker_id < k){
            sum[worker_id] += jobs[u];
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]);

            dfs2(u+1,sum,Math.max(sum[worker_id],max),worker_id+1);
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"所有的可能性都已经被探索了，返回"+worker_id);
            sum[worker_id] -= jobs[u];

        }
        for (int i = 0; i < worker_id; i++) {

            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"worker_id"+worker_id);
            sum[i] += jobs[u];
            dfs2(u+1,sum,Math.max(sum[i],max),worker_id);
            System.out.println("当前的K:"+u+",当前的分配方案"+sum[0]+" "+sum[1]+" "+sum[2]+"所有的可能性都已经被探索了，返回");
            sum[i] -= jobs[u];

        }







    }

    public static void main(String[] args) {
        int[] jobs = new int[]{3,2,3};
        int k = 3;
        int i = minimumTimeRequired(jobs, k);
        System.out.println(i);

    }




}
