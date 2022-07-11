/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    
    if ( !(head) || !(head.next) ) return null;
    
    let fp = head;
    let bp = head;
    
    while (n--) {
        bp = bp.next;
    }
    
    // Remove first element
    if ( !bp ) return head.next;        
        
    while (bp.next) {
        fp = fp.next;
        bp = bp.next;
    }
    
    let saveNext = fp.next.next;
    delete fp.next;
    fp.next = saveNext;
    
    return head;
};