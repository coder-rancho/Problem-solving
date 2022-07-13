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
var rotateRight = function(head, k) {
    
    if (!head || !(head.next) ) return head;
    
    let fw = head;
    let bw = head;
    
    while (k--) fw = fw.next ? fw.next : head;
    
    while (fw.next) {
        fw = fw.next
        bw = bw.next
    }
    
    fw.next = head;
    head = bw.next;
    bw.next = null
    
    return head;
    
};