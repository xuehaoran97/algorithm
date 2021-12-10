public class Offer57 {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int sum = 0;
        while(left<right){
            sum = nums[left] + nums[right];
            if(sum<target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                return new int[]{nums[left],nums[right]};
            }

        }

      return new int[]{};
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,7,11,15};
        int[] ints = twoSum(test, 9);
        for(int num:ints){
            System.out.print(num+" ");
        }
    }
}
