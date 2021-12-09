import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()) ;
        int[][] graph = new int[n][n];
        int len = n;
        int index =0;

        while(n--!=0) {
            String data = scanner.nextLine();
            String[] s = data.split(" ");
            for (int i = 0; i < len; i++) {
                graph[index][i] = Integer.parseInt(s[i]);
            }
        }

        String da = scanner.nextLine();
        String[] datas = da.split(" ");
        int[] intAttack = new int[datas.length];
        for(int i =0;i< datas.length;i++){
            intAttack[i] = Integer.parseInt(datas[i]);
        }

        int attack = findAttack(graph, intAttack);
        System.out.println(attack);
    }








    public static int findAttack(int[][] graph, int[] intAttack) {
        int number = graph.length;
        DSU dsu = new DSU(number);
        for (int i = 0; i < number; ++i)
            for (int j = i+1; j < number; ++j)
                if (graph[i][j] == 1)
                    dsu.union(i, j);

        int[] count = new int[number];
        for (int node: intAttack)
            count[dsu.find(node)]++;

        int ans = -1, ansSize = -1;
        for (int node: intAttack) {
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
            for (int node: intAttack)
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