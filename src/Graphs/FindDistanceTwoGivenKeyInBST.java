package Graphs;

import java.util.List;
import java.util.ArrayList;

/**
 * find distance between two given key of nodes in BST
 *
 *       5
 *      /\
 *     3  7
 *    /\
 *   2  4
 *  /
 * 1
 *
 * distance(2,4) = 2
 * distance(1,2) = 1
 * distance(1,7) = 4
 * distance(1,5) = 3
 * distance(1,8) = -1 // when either value NOT exist return -1
 *
 * Created by minsukheo on 1/18/17.
 */
public class FindDistanceTwoGivenKeyInBST {
    public static void main(String[] args) {
        // BST node keys are in int array
        int[] input = {5,3,7,4,2,1};

        // generate binary search tree
        BST bst = new BST(input[0]);
        for(int i=1;i<input.length;i++) {
            bst.insert(input[i]);
        }

        FindDistanceTwoGivenKeyInBST solution = new FindDistanceTwoGivenKeyInBST();

        // Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
        int distance = solution.findDistance(bst, 5, 1);
        System.out.println("distance: "+distance);

    }

    private int findDistance(BST bst, int n1, int n2) {
        int x = pathLength(bst.head, n1);
        int y = pathLength(bst.head, n2);
        if(x == -1 || y == -1) {
            return -1;
        }

        int lcaData = findLCA(bst.head, n1, n2);
        int lcaDistance = pathLength(bst.head, lcaData) ;
        return (x + y) - 2 * lcaDistance;

    }

    private int findLCA(BST_Node head, int n1, int n2) {
        BST_Node cur = head;
        List<Integer> v1 = getAncestors(head, n1);
        List<Integer> v2 = getAncestors(head, n2);
        if(v1.isEmpty() || v2.isEmpty()) {
            return head.val;
        }
        int minLength = Math.min(v1.size(), v2.size());
        int LCA_index = 0;
        for(int i=0;i<minLength;i++) {
            if(!v1.get(i).equals(v2.get(i))) {
                return v1.get(i-1);
            }
            else{
                LCA_index++;
            }
        }
        // if all ancestors are same, use the last ancestor from any list
        if(LCA_index ==  v1.size() && LCA_index == v2.size()) {
            return v1.get(v1.size()-1);
        }

        if(v1.size() > v2.size()) {
            return v1.get(LCA_index-1);
        }
        else {
            return v2.get(LCA_index-1);
        }
    }

    private List<Integer> getAncestors(BST_Node head, int n) {
        List<Integer> v = new ArrayList<Integer>();

        BST_Node cur = head;
        while(cur.val != n) {
            v.add(cur.val);
            if(cur.val > n) {
                if(cur.left != null) {
                    cur = cur.left;
                }
                else {
                    return v;
                }
            }
            else {
                if(cur.right != null) {
                    cur = cur.right;
                }
                else {
                    return v;
                }
            }
        }
        v.add(cur.val);

        return v;
    }

    private int pathLength(BST_Node head, int n) {
        int length = 0;
        if(head.val == n) {
            return length;
        }
        BST_Node cur = head;

        while(cur.val != n) {
            if(cur.val > n) {
                if(cur.left != null) {
                    cur = cur.left;
                    length++;
                }
                else {
                    return -1;
                }
            }
            else {
                if(cur.right != null) {
                    cur = cur.right;
                    length++;
                }
                else {
                    return -1;
                }
            }
        }

        return length;
    }
}

class BST_Node {
    int val;
    BST_Node left;
    BST_Node right;
    BST_Node(int n) {
        val = n;
    }
}

class BST {
    BST_Node head;

    BST(int n){
        head = new BST_Node(n);
    }

    public void insert(int n) {
        insertNode(head, n);
    }

    private void insertNode(BST_Node cur, int n) {
        if(cur.val > n) {
            if(cur.left == null) {
                cur.left = new BST_Node(n);
            }
            else {
                insertNode(cur.left, n);
            }
        }
        else {
            if(cur.right == null) {
                cur.right = new BST_Node(n);
            }
            else {
                insertNode(cur.right, n);
            }
        }
    }

    public void inorder() {
        inorderTraverse(head);
    }

    private void inorderTraverse(BST_Node cur) {
        if(cur.left != null) inorderTraverse(cur.left);
        System.out.println(cur.val);
        if(cur.right != null) inorderTraverse(cur.right);
    }
}
