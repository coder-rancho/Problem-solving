/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    
    if (!head || !head.next) return head;
    
    let node = head;
    
    /* New Head */
    head = reverseKNodes(node, k);
    
    let prev = node;
    node = node.next;
    
    while(node) {
        prev.next = reverseKNodes(node, k);
        prev = node;
        node = node.next;
    }
    return head;
};

var reverseKNodes = function(head, k) {
    let node = head;
    let prev = null;
    
    while (k-- && node) {
        let saveNext = node.next;
        node.next = prev;
        prev = node;
        node = saveNext
    }
    head.next = node
    
    if (k !== -1) {
        node = prev;
        prev = null;
        
        while(node) {
            let saveNext = node.next;
            node.next = prev;
            prev = node;
            node = saveNext;
        }
        return head;
    }
    return prev;
}