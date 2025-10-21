package binarytree;

import java.util.*;

public class ZigZagTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigZagTraversal z = new ZigZagTraversal();
        List<List<Integer>> ans = z.zigzagLevelOrder(root);
        ans.forEach(System.out::println);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        boolean l2r = true;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(size, 0));

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                int index = l2r ? i : (size - i - 1);
                level.set(index, node.data);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ans.add(level);
            l2r = !l2r;
        }

        return ans;

    }
}
