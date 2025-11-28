package binarytree;

import java.util.*;

public class TimeToBurnTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);


        TimeToBurnTree t = new TimeToBurnTree();
        System.out.println(t.timeToBurnTree(root, 1));
    }

    public int timeToBurnTree(TreeNode root, int start) {
        if (root == null) return 0;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = buildParentMap(parentMap, root, start);
        return calculateTime(startNode, parentMap);
    }

    private static int calculateTime(TreeNode startNode, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visitedSet = new HashSet<>();
        q.offer(startNode);
        visitedSet.add(startNode);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnedThisLevel = false;
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                TreeNode parent = parentMap.get(node);
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (didBurn(parent, visitedSet, q)) burnedThisLevel = true;
                if (didBurn(left, visitedSet, q)) burnedThisLevel = true;
                if (didBurn(right, visitedSet, q)) burnedThisLevel = true;
            }

            if (burnedThisLevel) time++;
        }
        return time;
    }

    private static boolean didBurn(TreeNode node, Set<TreeNode> visitedSet, Queue<TreeNode> q) {
        if (node != null && !visitedSet.contains(node)) {
            q.add(node);
            visitedSet.add(node);
            return true;
        }
        return false;
    }

    private static TreeNode buildParentMap(Map<TreeNode, TreeNode> map, TreeNode root, int start) {
        TreeNode startNode = new TreeNode(-1);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                TreeNode currentNode = q.poll();
                if (currentNode.data == start) startNode = currentNode;

                TreeNode left = currentNode.left;
                if (left != null) {
                    map.put(left, currentNode);
                    q.offer(left);
                }

                TreeNode right = currentNode.right;
                if (right != null) {
                    map.put(right, currentNode);
                    q.offer(right);
                }
            }
        }
        return startNode;
    }
}
