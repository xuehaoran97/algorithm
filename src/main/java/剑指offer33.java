public class 剑指offer33 {


    public static void main(String[] args) {
        int[] test = new int[]{1,2,5,10,6,9,4,3};
        boolean b = verifyPostorder(test);
        System.out.println(b);
    }

    public static boolean verifyPostorder(int[] postorder) {
        return helper(postorder,0,postorder.length-1);
    }

    public static boolean helper(int[] postorder, int start, int end){
        if(start >= end){
            return true;
        }

        int p = -1;


        for(int i = start;i<=end;i++){
            if(postorder[i] > postorder[end]){
                p = i;
                break;
            }

        }
        if(p==-1){
            p=end;
        }
        System.out.println(p);
        for(int i=p;i<end;i++){
            System.out.println(postorder[i]);
            if(postorder[i] <= postorder[end]){
                return false;
            }
        }
        return helper(postorder,start,p-1) && helper(postorder,p,end-1);
    }
}
