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
    ListNode* reverseKGroup(ListNode* head, int k) {
        
        if (!head || !head->next) return head;
        
        ListNode* node = head;
        
        /* New Head */
        head = reverseKNodes(node, k);
        cout << head -> val << "  ";
        
        ListNode* prev = node;
        node = node -> next;
        
        while(node) {
            prev -> next = reverseKNodes(node, k);
            prev = node;
            node = node -> next;
        }
        return head;        
    }
    
    ListNode* reverseKNodes(ListNode* head, int k) {
        
        ListNode* node = head;
        ListNode* prev = nullptr;
        
        while (k-- && node) {
            ListNode* saveNext = node -> next;
            node -> next = prev;
            prev = node;
            node = saveNext;
        }
        head -> next = node;
        
        if (k != -1) {
            node = prev;
            prev = nullptr;
            
            while(node) {
                ListNode* saveNext = node -> next;
                node -> next = prev;
                prev = node;
                node = saveNext;
            }
            return head;
        }
        
        return prev;
    }
};