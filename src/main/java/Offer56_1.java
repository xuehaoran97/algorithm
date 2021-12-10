public class Offer56_1 {
    public static int[] singleNumbers(int[] nums) {
        int stat = 0;
        //对数组中所有的树进行异或
        for(int n:nums){
            stat ^= n;
        }
        //找到结果中为1的那一位
        int div = 1;
        while((div&stat)==0){
            div <<=1;
        }
        //分组
        int a = 0;
        int b = 0;
        for(int num:nums){
            if((num&div)!=0){
                a^=num;
            }else{
                b^=num;
            }
        }
        return new int[]{a,b};

    }

    public static void main(String[] args) {
        int[]  test = new int[]{1,2,10,4,1,4,3,3};
        int[] res = singleNumbers(test);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}
