import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()) ;
        int[][] graph = new int[n][3];
        int len = n;
        int index =0;

        while(n--!=0) {
            String data = scanner.nextLine();
            String[] s = data.split(" ");
            graph[index][0] = Integer.parseInt(s[0]);
            graph[index][1] = Integer.parseInt(s[1]);
            graph[index][2] = Integer.parseInt(s[2]);
        }
        int[] intAttack = new int[2];
        String da = scanner.nextLine();
        String[] datas = da.split(" ");

        intAttack[0] = Integer.parseInt(datas[0]);
        intAttack[1] = Integer.parseInt(datas[1]);

        int attack = findAttack(graph, intAttack);
        System.out.println(attack);


    }

    public static int findAttack(int[][] graph, int[] intAttack){
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = -1;
        }
        int c = 0;
        for (int i = 0; i < n;++i) {
            if(colors[i] == -1){
                dfs(graph,colors,i,c++);
            }
        }
        int[] size = new int[c];
        for (int color:colors) {
            size[color]++;
        }

        int[] colorCount = new int[c];
        for(int index:intAttack){
            colorCount[colors[index]]++;
        }

        int ans = Integer.MAX_VALUE;
        for(int index:intAttack){
            int count = colors[index];
            if(colorCount[count] == 1){
                if(ans == Integer.MAX_VALUE){
                    ans = index;
                }else if(size[count] > size[colors[ans]]){
                    ans = index;
                }else if(size[count] == size[colors[ans]] && index<ans){
                    ans = index;
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            for (int index:intAttack){
                ans = Math.min(ans,index);
            }
        }
        return ans;

    }


    public static void dfs(int[][] graph, int[] colors, int n,int color){
        colors[n] = color;
        for (int i = 0; i < graph.length; ++i) {
            if(graph[n][i] == 1 && colors[n] == -1){
                dfs(graph,colors,n,color);
            }
        }
    }
    
    
    class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int N = graph.length;
        DSU dsu = new DSU(N);
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                if (graph[i][j] == 1)
                    dsu.union(i, j);

        int[] count = new int[N];
        for (int node: initial)
            count[dsu.find(node)]++;

        int ans = -1, ansSize = -1;
        for (int node: initial) {
            int root = dsu.find(node);
            if (count[root] == 1) {  // unique color
                int rootSize = dsu.size(root);
                if (rootSize > ansSize) {
                    ansSize = rootSize;
                    ans = node;
                } else if (rootSize == ansSize && node < ans) {
                    ansSize = rootSize;
                    ans = node;
                }
            }
        }

        if (ans == -1) {
            ans = Integer.MAX_VALUE;
            for (int node: initial)
                ans = Math.min(ans, node);
        }
        return ans;
    }
}


class DSU {
    int[] p, sz;

    DSU(int N) {
        p = new int[N];
        for (int x = 0; x < N; ++x)
            p[x] = x;

        sz = new int[N];
        Arrays.fill(sz, 1);
    }

    public int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    public void union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        p[xr] = yr;
        sz[yr] += sz[xr];
    }

    public int size(int x) {
        return sz[find(x)];
    }
}


}
