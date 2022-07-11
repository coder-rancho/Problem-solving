/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        
        if ( !(head) || !(head -> next) ) return head;
        
        ListNode* node = head;
        int len = 0;
        
        while (node) {
            len++;
            node = node -> next;
        }
        
        int mid = len/2 + 1;
        node = head;
        
        for (int i = 1; i != mid; i++) {
            node = node -> next;
        }
        return node;
    }
};