import LeetCode.AddTwoNumbers.ListNode;

class AddTwoNumbers {

    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */

    public ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null && l2 != null) {
            return l2;
        }

        if (l2 == null && l1 != null) {
            return l1;
        }

        ListNode l3 = null;
        boolean carryOver = false;
        int result = 0;
        ListNode current = null;

        while (l1 != null || l2 != null) {
            int l1val;
            int l2val;

            if (l1 == null) {
                l1val = 0;
            } else {
                l1val = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) {
                l2val = 0;
            } else {
                l2val = l2.val;
                l2 = l2.next;
            }

            int num = l1val + l2val;

            if (carryOver) {
                num += 1;
            }

            if (num >= 10) {
                carryOver = true;
                result = num % 10;
                ListNode newNode = new ListNode(result);

                if (l3 == null) {
                    l3 = newNode;
                    current = l3;
                } else {
                    current.next = newNode;
                    current = newNode;
                }

            } else {
                carryOver = false;
                result = num;
                ListNode newNode = new ListNode(result);

                if (l3 == null) {
                    l3 = newNode;
                    current = l3;
                } else {
                    current.next = newNode;
                    current = newNode;
                }
            }
        }

        if (carryOver) {
            current.next = new ListNode(1);
        }

        return l3;

    }

    public ListNode OptimalAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
