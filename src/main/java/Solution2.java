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
}
