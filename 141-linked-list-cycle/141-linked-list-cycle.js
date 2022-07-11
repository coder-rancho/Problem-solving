/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    
    if ( !head ) return false;
    
    let mp = {}
    let node = head;
    
    while (node.next) {
        
        if ( mp[ node.next.val ] == node.next ) return true
        
        mp[node.val] = node;
        node = node.next;
    }
    return false
    
};