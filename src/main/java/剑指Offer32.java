import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指Offer32 {
    public static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
                list.add(node.val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);

        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        int[] ints = levelOrder(root);
        for(int n:ints){
            System.out.println(n);
        }
    }

}


