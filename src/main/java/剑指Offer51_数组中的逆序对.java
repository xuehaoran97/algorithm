public class 剑指Offer51_数组中的逆序对 {


    static int ans = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{7,5,6,4};
        partition(arr,0, arr.length-1);
        System.out.println(ans);
    }

    public static void partition(int[] arr, int left, int right){
        if(left == right){
            return;
        }
        int mid = left + (right-left)/2;
        partition(arr,left,mid);
        partition(arr,mid+1,right);
        int mergeCount = merge(arr, left, mid, right);
        ans += mergeCount;

    }

    public static int merge(int[] arr, int left, int mid, int right){
        int count = 0;
        int len = right - left+1;
        int[] temp = new int[len];
        int i = 0;
        int j = mid-left+1;
        int index=0;
        for (int k = 0; k < len; k++) {
            temp[k] = arr[left+k];
        }

        for (int k = 0; k < len; k++) {
            if(i == mid - left +1){
                arr[left+k] = temp[j];
                j++;
            }else if(j == right-left+1){
                arr[left+k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                arr[left+k] = temp[i];
                i++;
            }else if(temp[i] > temp[j]){
                count+= (len-1)/2-i+1;
                arr[left+k] = temp[j];
                j++;
            }
        }
        return count;
    }
}
