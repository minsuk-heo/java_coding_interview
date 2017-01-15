package CrackingTheCodingInterview;

/**
 *
 * Check if the Binary Search Tree is balanced
 *
 * Created by minsukheo on 1/14/17.
 */
public class CheckBalancedBST {
    public static void main(String[] args) {

        TreeNode BST = new TreeNode(3);
        BST.left = new TreeNode(2);
        BST.left.left = new TreeNode(1);
        BST.right = new TreeNode(4);
        BST.right.right = new TreeNode(5);
        //BST.right.right.right = new TreeNode(6);

        CheckBalancedBST solution = new CheckBalancedBST();
        System.out.println(solution.run(BST));

    }

    private boolean run(TreeNode bst) {
        if (bst == null) {
            return true;
        }
        else {
            return isBalancedBST(bst);
        }
    }

    private boolean isBalancedBST(TreeNode bst) {
        if(checkHeight(bst) == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    private int checkHeight(TreeNode curNode) {
        if (curNode == null){
            return 0;
        }
        int leftHeight = checkHeight(curNode.left);
        int rightHeight = checkHeight(curNode.right);
        if(Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        else {
            int balanceValue = Math.max(leftHeight, rightHeight)+1;
            return balanceValue;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int n){
        val = n;
    }
}
