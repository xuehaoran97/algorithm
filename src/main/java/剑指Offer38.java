import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 剑指Offer38 {
    static List<String> res;
    static boolean[] visited;

    public static String[] permutation(String s) {
        res = new LinkedList<>();
        visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        dfs(chars,0,chars.length,sb);
        String[] resc = new String[res.size()];
        int index = 0;
        for(String string:res){
            resc[index] = string;
            index++;
        }
        return resc;

    }


    public static void dfs(char[] chars, int i, int n,StringBuilder sb){
        if(i == n){
            res.add(sb.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if(visited[j] || j>0&&!visited[j-1] && chars[j] == chars[j-1]){
                continue;
            }

            visited[j] = true;
            sb.append(chars[j]);
            dfs(chars,i+1,n,sb);

            sb.deleteCharAt(sb.length()-1);
            visited[j] = false;

        }


    }




    public static void main(String[] args) {
        String[] aabs = permutation("aab");
        for(String s:aabs){
            System.out.println(s);
        }
    }


}
