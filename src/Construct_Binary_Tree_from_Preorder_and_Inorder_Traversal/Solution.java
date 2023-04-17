package Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;

public class Solution {
    int currIdxOfPreorder;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currIdxOfPreorder = 0;

        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, inorder.length, map);
    }

    public TreeNode buildSubTree(int [] preorder, int l, int r, HashMap<Integer, Integer> map) {
        if(currIdxOfPreorder >= preorder.length) return null;
        if(l >= r) return null;

        // idx of the inorder array
        int idx = map.get(preorder[currIdxOfPreorder]);
        if(idx < l || idx >= r) return null;

        TreeNode curr = new TreeNode(preorder[currIdxOfPreorder]);
        currIdxOfPreorder++;

        // create left child for curr
        curr.left = buildSubTree(preorder, l, idx, map);
        curr.right = buildSubTree(preorder, idx + 1, r, map);

        return curr;
    }
}
