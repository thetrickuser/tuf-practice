package binarytree;

import java.util.*;

public class TopView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TopView tv = new TopView();
        List<Integer> integers = tv.topView(root);
        integers.forEach(System.out::println);
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = buildMap(root);
        return map.values().stream().toList();
    }

    private static TreeMap<Integer, Integer> buildMap(TreeNode node) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(node, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode currNode = tuple.node;
            int v = tuple.vertical;
            int l = tuple.level;

            map.computeIfAbsent(v, k -> currNode.data);

            if (currNode.left != null) q.offer(new Tuple(currNode.left, v-1, l+1));
            if (currNode.right != null) q.offer(new Tuple(currNode.right, v+1, l+1));
        }

        return map;
    }

    record Tuple(TreeNode node, int vertical, int level) {}
}




