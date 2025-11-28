package binarytree;

public class LCA {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        LCA l = new LCA();
        TreeNode treeNode = l.lowestCommonAncestor(root, root.left.left, root.left.right.right);
        System.out.println(treeNode.data);


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //your code goes here
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left == null) return right;
        if (right == null) return left;
        else return root;

    }
}
