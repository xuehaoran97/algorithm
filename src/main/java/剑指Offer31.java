import java.util.Stack;

public class 剑指Offer31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        int n = pushed.length;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }



        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
}
