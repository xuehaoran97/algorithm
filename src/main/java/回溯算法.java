import java.util.ArrayList;
import java.util.List;

public class 回溯算法 {
    public static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        help2(arr,0,0,3,3,new ArrayList<>());
        for(List<Integer> list:res){
            for(int num:list){
                System.out.print(num+" ");
            }
            System.out.println("   ");
        }

    }

    public static void help(int[] arr, int index, int target, List<Integer> list){
        if(target == 0){
            if(!res.contains(list)){
               res.add(new ArrayList<>(list));
               return;
            }
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[index]);
            index += 1;
            target -=1;
            help(arr,index,target,list);
            list.remove(list.size()-1);
            target+=1;
        }
    }

    public static void help2(int[] arr, int index1,int index2, int target1, int target2,List<Integer> list){
        if(target1 == 0 && target2 == 0){
            if(!res.contains(list)){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = index1; i < arr.length; i++) {
            list.add(arr[index1]);
            index1 += 1;
            target1 -=1;
            help2(arr,index1,index2,target1,target2,list);


            for (int j = 0; j < index2; j++) {
                list.add(arr[index2]);
                index2 +=1;
                target2-=1;
                help2(arr,index1,index2,target1,target2,list);
                list.remove(list.size()-1);
                target2+=1;
            }
            list.remove(list.size()-1);
            target1+=1;

        }
    }
}
