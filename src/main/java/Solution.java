import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()) ;
        int len = n;

        int[] times = new int[n];
        int[] symbols = new int[n];
        System.out.println(n);
        int index =0;


        while(n--!=0) {
            String data = scanner.nextLine();
            String[] s = data.split(" ");
            times[index] = Integer.parseInt(s[0]);
            symbols[index] = Integer.parseInt(s[1]);
            index++;

        }


        int max = 0;
        int cur = 0;


        for(int i=0;i<len;i++){
            int time = times[i];
            int symbol = symbols[i];


            if(symbol==1){
                cur++;
                if(cur>max){
                    max = cur;
                }
            }
            if(symbol==0){
                if(cur==0){
                    cur=0;
                }else{
                    cur--;
                }
            }

        }

        System.out.println(max);

    }
}
