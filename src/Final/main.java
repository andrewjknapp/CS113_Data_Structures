package Final;

public class main {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        ListNode newList = null;
        int currentValue;

        while (pointer1 != null || pointer2 != null) {
            if (pointer1 != null && pointer2 != null) {
                currentValue = Math.min(pointer1.val, pointer2.val);
                if (currentValue == pointer1.val) {
                    pointer1 = pointer1.next;
                } else {
                    pointer2 = pointer2.next;
                }
            }
        }
        return new ListNode();
    }
}
