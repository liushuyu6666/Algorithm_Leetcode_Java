package Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Solution {
    Node prev;
    Node head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        prev = null;
        head = null;
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    public void dfs(Node curr) {
        if(curr == null) return;
        dfs(curr.left);
        if(prev == null) {
            prev = curr;
            head = curr;
        } else {
            prev.right = curr;
            curr.left = prev;
            prev = curr;
        }
        dfs(curr.right);
    }
}
