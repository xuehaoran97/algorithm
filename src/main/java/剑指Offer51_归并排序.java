public class 剑指Offer51_归并排序 {

    public static void mergeSort(int[] arr){
        partition(arr,0, arr.length-1);
    }


    public static void partition(int[] arr, int left, int right){
        if(left == right){
            return;
        }
        int mid = left + (right - left)/2;
        partition(arr,left,mid);
        partition(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    public static void merge(int[] arr, int left, int mid ,int right){

        int len = right - left + 1;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = arr[left+i];
        }
        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            if(i == mid -left +1){
                arr[left+k] = temp[j];
                j++;
            }else if(j == right-left+1) {
                arr[left+k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                arr[left+k] = temp[i];
                i++;
            }else{
                arr[left+k] = temp[j];
                j++;
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,5,6,4};
        mergeSort(arr);
        for (int num: arr) {
            System.out.print(num +" ");
        }
    }
}
