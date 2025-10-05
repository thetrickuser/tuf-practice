package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getGeneralUseTree();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inorder(root).forEach(System.out::println);
    }

    public List<Integer> inorder(TreeNode root) {
        //your code goes here
        List<Integer> list = new ArrayList<>();
        // recursiveInorder(root, list);
        // return list;

        iterativeInorder(root, list);
        return list;
    }

    private void recursiveInorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        recursiveInorder(node.left, list);
        list.add(node.data);
        recursiveInorder(node.right, list);
    }

    private void iterativeInorder(TreeNode node, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = node;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.data);

            curr = curr.right;
        }
    }
}
