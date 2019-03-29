package leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                TreeNode node = queue.remove();
                String out = node == null? "null": Integer.toString(node.val);
                System.out.println(out);
                if(node!= null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }


        }
        return "end to String";
    }
}
