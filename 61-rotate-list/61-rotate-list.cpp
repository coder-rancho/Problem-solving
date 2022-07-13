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
    ListNode* rotateRight(ListNode* head, int k) {
        
        if ( !(head) || !(head -> next) ) return head;
        
        ListNode* fw = head;
        ListNode* bw = head;
        int len = 0;
        int ahead = k;
        
        while (ahead--) {
            len += 1;
            
            if ( !(fw -> next) ) {
                ahead = k % len;
                fw = head;
                break;
            }
            
            fw = fw -> next;
        }
        
        if (ahead == 0) return head;
        
        while (ahead > 0) {
            fw = fw -> next;
            ahead--;
        }
        
        while (fw -> next) {
            fw = fw -> next;
            bw = bw -> next;
        }
        
        fw -> next = head;
        head = bw -> next;
        bw -> next = nullptr;
        
        return head;
    }
};