/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
    
    if ( !head ) return head;
    
    let node = head;
    
    while (node) {
        let copy = new Node(node.val, node.next)
        node.next = copy;
        node = copy.next;
    }
    
    node = head;
    
    while (node) {        
        node.next.random = node.random ? node.random.next : null;
        node = node.next.next;
    }
    
    node = head
    copyHead = head.next;
    
    while (node) {
        let saveNext = node.next;
        node.next = node.next ? node.next.next : null;
        node = saveNext;
    }
    
    return copyHead;
};