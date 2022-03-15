package top100;

class leetcode2 {
    /**
     * 两数相加
     *
     *
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNodePre = new ListNode();
        ListNode lastNode = firstNodePre;
        ListNode nowNode =  new ListNode(0);
        lastNode.next = nowNode;
        int ln = 0;
        while(true){
            if(l1 == null && l2 == null){
                break;
            } else if(l1 == null){
                nowNode = new ListNode( (l2.val + ln) % 10);
                ln = l2.val + ln >= 10 ? 1 : 0;
                lastNode.next = nowNode;
                lastNode = nowNode;
                l2 = l2.next;
            } else if(l2 == null){
                nowNode = new ListNode( (l1.val + ln) % 10);
                ln = l1.val + ln >= 10 ? 1 : 0;
                lastNode.next = nowNode;
                lastNode = nowNode;
                l1 = l1.next;
            }else{
                nowNode = new ListNode((l1.val + l2.val + ln) % 10);
                ln = l1.val + l2.val + ln >= 10 ? 1 : 0;
                lastNode.next = nowNode;
                lastNode = nowNode;
                l1 = l1.next;
                l2 = l2.next;
            }

        }
        if(ln == 1) nowNode.next = new ListNode(1);
        return firstNodePre.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/**
 * 题解：结果链表中每个节点的值为 节点1val + 节点2val + 进位
 */
