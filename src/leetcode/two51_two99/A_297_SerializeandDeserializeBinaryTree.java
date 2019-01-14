package leetcode.two51_two99;


import leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Codec {

    private static final String COMMA = ",";
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serialize(root, sb);

    }

    public String serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL);
            return sb.toString();
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left, sb);
        sb.append(",");
        serialize(root.right, sb);

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        return deHelper(list);
    }

    public TreeNode deHelper(List<String> l) {

        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = deHelper(l);
        root.right = deHelper(l);

        return root;
    }
}

public class A_297_SerializeandDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String a = codec.serialize(root);
        System.out.println(a);
        TreeNode node = codec.deserialize(a);
        System.out.println(node);
    }


}

/*
                                            1
                                 2                      3
                         null       null        4               5
                                            null  null     null   null
 */
/*
    - Use Pre-order: root left right
 */
