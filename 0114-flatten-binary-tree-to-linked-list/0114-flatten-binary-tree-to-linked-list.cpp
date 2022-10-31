/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void flatten(TreeNode* root) {
        _flatten(root, NULL);
    }

    TreeNode* _flatten(TreeNode* root, TreeNode* tail) {
        if (root == NULL) return tail;
        TreeNode* newTail = _flatten(root->right, tail);
        root->right = _flatten(root->left, newTail);
        root->left = NULL;
        return root;
    }
};