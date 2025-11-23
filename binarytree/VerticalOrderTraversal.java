package binarytree;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        VerticalOrderTraversal v = new VerticalOrderTraversal();
        List<List<Integer>> lists = v.verticalTraversal(root);
        lists.forEach(list -> {
            list.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        }
        );
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = buildMap(root);

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> verticalNodes = new ArrayList<>();
            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    verticalNodes.add(pq.poll());
                }
            }
            ans.add(verticalNodes);
        }

        return ans;
    }

    private static TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> buildMap(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node();
            int v = t.vertical();
            int l = t.level();

            map.computeIfAbsent(v, k -> new TreeMap<>())
                    .computeIfAbsent(l, k -> new PriorityQueue<>())
                    .add(node.data);

            if (node.left != null) q.add(new Tuple(node.left, v - 1, l + 1));
            if (node.right != null) q.add(new Tuple(node.right, v + 1, l + 1));
        }

        return map;
    }
}

record Tuple(TreeNode node, int vertical, int level) {}