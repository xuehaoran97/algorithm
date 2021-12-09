import java.util.LinkedList;
import java.util.List;

public class 剑指Offer34 {

    static List<TreeNode> list = new LinkedList<>();
    static List<List<Integer>> ans = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null){
            return new LinkedList<>();
        }
        list.add(root);
        dfs(root,target-root.val,list);
        return ans;

    }

    public static void dfs(TreeNode node, int target, List<TreeNode> list){
        if(target == 0 && node.left == null && node.right==null){
            List<Integer> res = new LinkedList<>();
            for(TreeNode treeNode:list){
                res.add(treeNode.val);

            }
            ans.add(res);

        }


        if(node.left!=null){
            list.add(node.left);
            target = target-node.left.val;
            dfs(node.left,target,list);
            list.remove(list.size()-1);
            target = target+node.left.val;

        }

        if(node.right!=null){
            list.add(node.right);
            dfs(node.right,target-node.right.val,list);
            list.remove(list.size()-1);
            target = target+node.right.val;
        }
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

        List<List<Integer>> lists = pathSum(root, 8);
        for (List list:lists){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            System.out.println("+++++++");
        }


    }
}
