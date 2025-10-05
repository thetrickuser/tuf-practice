package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getGeneralUseTree();

    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursivePreorder(root, list);
        return list;
    }

    private void recursivePreorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.data);
        recursivePreorder(node.left, list);
        recursivePreorder(node.right, list);
    }

    private void iterativePreorder(TreeNode node, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = node;

        while (curr != null || !stack.isEmpty()) {


        }
    }


}
