import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

public class 剑指Offer37 {

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

        String serialize = serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = deserialize(serialize);
        System.out.println(root.right.val);




    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                stringBuilder.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                stringBuilder.append("null,");
            }




        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();


    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data .equals("[]")){
            return null;
        }

        String[] vals = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;

    }




}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}



