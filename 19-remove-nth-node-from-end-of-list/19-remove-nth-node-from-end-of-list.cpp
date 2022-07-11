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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        if ( !(head -> next) ) return nullptr;
        
        int check = _removeNode(head, n); 
        
        // if check == 0 => 1st item needs to be removed.
        
        if (check == 0) head = head -> next;
        
        return head;
    }
    
    int _removeNode(ListNode* node, int n) {
       
        if (node == nullptr) return n;
        
        int jumpForNext = _removeNode(node -> next, n);
        
        if (jumpForNext == 0) {
            // found
            ListNode* saveNext = node -> next -> next;
            delete node -> next;
            node -> next = saveNext;
        }
        
        return jumpForNext - 1;
    }
};