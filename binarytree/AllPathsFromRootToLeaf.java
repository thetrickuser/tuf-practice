package binarytree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromRootToLeaf {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        AllPathsFromRootToLeaf s = new AllPathsFromRootToLeaf();
        List<List<Integer>> lists = s.allRootToLeaf(root);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here
        List<List<Integer>> allPaths = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();

        getPaths(root, currentPath, allPaths);
        return allPaths;
    }

    private void getPaths(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(path));
        } else {
            getPaths(node.left, path, allPaths);
            getPaths(node.right, path, allPaths);
        }

        path.remove(path.size() - 1);
    }
}
