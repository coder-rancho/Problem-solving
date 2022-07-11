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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        
        if ( !list1 ) return list2;
        if ( !list2 ) return list1;
            
        ListNode* l1 = list1;
        ListNode* l2 = list2;
        ListNode* head;
        
        if ( (l1 -> val) < (l2 -> val) ) {
            head = l1;
            l1 = l1 -> next;
        } else {
            head = l2;
            l2 = l2 -> next;
        }
        
        ListNode* node = head;
        
        while ( l1 && l2 ) {
           
            if ( (l1 -> val) < (l2 -> val) ) {
                node -> next = l1;
                node = l1;
                l1 = l1 -> next;
            } else {
                node -> next = l2;
                node = l2;
                l2 = l2 -> next;
            }            
        }
        
        while ( l1 ) {
            node -> next = l1;
            node = l1;
            l1 = l1 -> next;
        }
        
        while ( l2 ) {
            node -> next = l2;
            node = l2;
            l2 = l2 -> next;
        }
        return head;
    }
};