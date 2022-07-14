/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        
        if (!head) return head;
        
        Node* copyHead;
        Node* node = head;
        
        while (node) {
            Node* copy = new Node(node -> val);
            copy -> next = node -> next;
            node -> next = copy;
            node = copy -> next;
        }
        
        node = head;
        
        while (node) {
            node -> next -> random = node -> random ? node -> random -> next : nullptr;
            node = node -> next -> next;
        }
        
        copyHead = head -> next;
        node = head;
        
        while (node) {
            Node* saveNext = node -> next;
            node -> next = node -> next ? node -> next -> next : nullptr;
            node = saveNext;
        } 
        
        return copyHead;
    }
};


















