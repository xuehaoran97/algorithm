import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指Offer32II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                list.add(node.val);

            }
            if(!flag){
                List<Integer> list1 = new LinkedList<>();
                for (int i = list.size()-1; i >=0 ; i--) {
                    list1.add(list.get(i));
                }
                res.add(list1);
            }else{

                res.add(list);
            }
            flag = !flag;

        }
        return res;

    }


}
