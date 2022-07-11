/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        
        if (!head) return false;
        
        ListNode* node = head;
        unordered_map <int, ListNode*> mp;
        
        while (node -> next) {
            
            if ( mp[node->next->val] == node -> next) return true;
            
            mp[node -> val] = node;
            node = node -> next;
        }
        return false;
        
    }
};