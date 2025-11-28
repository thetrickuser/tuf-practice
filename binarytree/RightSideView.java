package binarytree;

import java.util.*;

public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(8);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
//        root.left.right = new TreeNode(5);

        RightSideView rv = new RightSideView();
        List<Integer> integers = rv.rightSideView(root);
        integers.forEach(System.out::println);
    }

    record Tuple(TreeNode node, int vertical, int level) {}

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;

        TreeMap<Integer, Integer> map = buildMap(root);
        return map.values().stream().toList();
    }

    private static TreeMap<Integer, Integer> buildMap(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode currNode = tuple.node;
            int v = tuple.vertical;
            int l = tuple.level;

            map.put(l, currNode.data);

            if (currNode.left != null) q.offer(new Tuple(currNode.left, v-1, l+1));
            if (currNode.right != null) q.offer(new Tuple(currNode.right, v+1, l+1));
        }

        return map;
    }
}
