package binarytree;

import java.util.*;

public class KDistanceNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        KDistanceNodes k = new KDistanceNodes();
        List<Integer> nodes = k.distanceK(root, root.left.right, 0);
        System.out.println(nodes);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(parentMap, root);
        Queue<TreeNode> q = getNodesAtKDistance(target, k, parentMap);
        q.forEach(node -> ans.add(node.data));
        return ans;
    }

    private static Queue<TreeNode> getNodesAtKDistance(TreeNode target, int k, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visitedSet = new HashSet<>();
        int dist = 0;
        q.offer(target);
        visitedSet.add(target);

        while (!q.isEmpty() && dist < k) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                TreeNode parent = parentMap.get(node);
                TreeNode left = node.left;
                TreeNode right = node.right;

                updateQueue(parent, visitedSet, q);
                updateQueue(left, visitedSet, q);
                updateQueue(right, visitedSet, q);
            }

            dist++;
        }
        return q;
    }

    private static void updateQueue(TreeNode node, Set<TreeNode> visitedSet, Queue<TreeNode> q) {
        if (node != null && !visitedSet.contains(node)) {
            q.add(node);
            visitedSet.add(node);
        }
    }

    private static void buildParentMap(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) map.put(left, root);
        if (right != null) map.put(right, root);

        buildParentMap(map, left);
        buildParentMap(map, right);
    }
}
