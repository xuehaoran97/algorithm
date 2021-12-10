import java.util.LinkedList;
import java.util.Queue;

public class Offer55_1 {

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth =0;
        while(!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            depth++;
        }


        return depth;




    }


    static int ans = 0;
    public static void  dfs(TreeNode node, int depth){
        if(node.left == null && node.right == null){
            if(depth>ans){
                ans = depth;
            }
            return;
        }

        if(node.left!=null){
            depth+=1;
            dfs(node.left,depth);
            depth-=1;
        }
        if(node.right!=null){
            depth+=1;
            dfs(node.right,depth);
            depth-=1;
        }

    }

    public static void dfs2(TreeNode node, int depth){
        if(node == null){
            if(ans < depth){
                ans = depth;
            }
            return;
        }
        depth += 1;
        dfs2(node.left,depth);
        dfs2(node.right,depth);


        depth-=1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        root.left = node2;
//        root.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        int i = maxDepth(root);
//        System.out.println(i);

        //dfs(root,1);
        dfs2(root,0);
        System.out.println(ans);

    }
}
