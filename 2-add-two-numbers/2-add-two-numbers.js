/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let head = new ListNode(0);
    let node = head;
    let prev = head;
    
    while (l1 && l2) {
        let sum = l1.val + l2.val + node.val;
        store(node, sum);
        l1 = l1.next;
        l2 = l2.next;
        prev = node;
        node = node.next;
    }
    
    while (l1) {
        let sum = l1.val + node.val;
        store(node, sum);
        l1 = l1.next;
        prev = node;
        node = node.next;
    };
    
    while(l2) {
        let sum = l2.val + node.val;
        store(node, sum);
        l2 = l2.next;
        prev = node;
        node = node.next;
    }
    
    if (node.val == 0) prev.next = null;
    
    return head;
}


var store = function (node, sum) {
    
    if (sum >= 10) {
        node.next = new ListNode(1);
    }
    else {
        node.next = new ListNode(0);
    }
    node.val = sum % 10;
}
