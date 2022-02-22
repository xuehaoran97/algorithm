import java.util.ArrayList;
import java.util.List;

public class 剑指OfferII_2 {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        dfs(candidates,target,path,0);
        for(List<Integer> list:res){
            System.out.println("答案是");
            for (int num:list) {
                System.out.print(num+" ");
            }
            System.out.println(" ");
        }
        return res;




    }

    public static void dfs(int[] candidates, int target, List<Integer> path, int index){
        System.out.println("指数："+index);

        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target<0 ){
            return;
        }
        for(int i = index;i<candidates.length;i++){

            path.add(candidates[i]);
            System.out.println("此时路径" + "此时i"+i);
            for (int n:path) {
                System.out.print(n+" ");
                System.out.println();
            }

            dfs(candidates,target-candidates[i],path,i);
            System.out.println("移出元素");
            path.remove(path.size()-1);
            //dfs(candidates,target,path,i+1);
        }

    }

    public static void dfs2(int[] candidates, int target, List<Integer> path, int index){
        if(target<0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(candidates[index]);
        dfs(candidates,target-candidates[index],path,index);
        path.remove(path.size()-1);
        dfs(candidates,target,path,index+1);
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        combinationSum(candidates,target);

        System.out.println(1&1000);

        System.out.println(Long.toBinaryString(1));

    }
}
