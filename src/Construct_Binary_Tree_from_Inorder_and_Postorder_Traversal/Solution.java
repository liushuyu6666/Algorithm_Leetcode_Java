package Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;

public class Solution {
    int currIdxInPostorder;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        currIdxInPostorder = postorder.length - 1;
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubtree(postorder, 0, inorder.length);
    }

    public TreeNode buildSubtree(int[] postorder, int l, int r) {
        if(l >= r) return null;

        // curr index in the inorder
        if(currIdxInPostorder < 0) return null;
        int currIdx = map.get(postorder[currIdxInPostorder]);
        // System.out.println("curr postorder is " + postorder[currIdxInPostorder] + " index in inorder is " + currIdx + " l ,r is " + l + ", " + r);
        if(currIdx < l || currIdx >= r) return null;

        // create the node
        TreeNode curr = new TreeNode(postorder[currIdxInPostorder]);
        currIdxInPostorder--;
        // System.out.println(currIdxInPostorder);

        curr.right = this.buildSubtree(postorder, currIdx + 1, r);
        curr.left = this.buildSubtree(postorder, l, currIdx);

        return curr;
    }
}
