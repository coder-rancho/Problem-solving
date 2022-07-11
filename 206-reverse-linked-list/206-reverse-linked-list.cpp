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
    ListNode* reverseList(ListNode* head) {
        
        if ( !head || !(head -> next) ) return head;
        
        ListNode* prev = nullptr;
        ListNode* node = head;
        
        while (node) {
            ListNode* saveNext = node -> next;
            node -> next = prev;
            prev = node;
            node = saveNext;
        }
        return prev;
    }
};