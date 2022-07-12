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
//     bool hasCycle(ListNode *head) {
        
//         if (!head) return false;
        
//         ListNode* node = head;
//         unordered_map <int, ListNode*> mp;
        
//         while (node -> next) {
            
//             if ( mp[node->next->val] == node -> next) return true;
            
//             mp[node -> val] = node;
//             node = node -> next;
//         }
//         return false;
        
//     }
    bool hasCycle(ListNode *head) {
        
        if (!head || !(head->next)) return false;
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        while (fast && fast -> next) {
            
            if (slow == fast) return true;
            
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        return false;
    }
};