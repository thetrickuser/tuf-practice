package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        if (!isLeaf(root)) ans.add(root.data);

        addLeftBoundary(root.left, ans);
        addLeaves(root, ans);
        addRightBoundary(root.right, ans);

        return ans;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> res) {
        TreeNode curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> res) {
        TreeNode curr = node;
        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        Collections.reverse(temp);
        res.addAll(temp);
    }

    private void addLeaves(TreeNode node, List<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
