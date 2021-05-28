package Final;

public class main {
    public static void main(String[] args) {

        ListNode[] lists = generateLists();

        //ListNode mergedList = mergeTwoLists(lists[0], lists[1]);
        ListNode mergedList = mergeSortedLists(lists);

        ListNode currentNode = mergedList;

        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }

    }

    /**
     *
     * @param l1 - Sorted Linked List
     * @param l2 - Sorted Linked List
     * @return   - Merged Linked List from Linked List inputs
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = null;
        ListNode currentNode = new ListNode();
        int currentVal;

        while (true) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    currentVal = l1.val;
                    l1 = l1.next;
                } else {
                    currentVal = l2.val;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                currentVal = l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                currentVal = l2.val;
                l2 = l2.next;
            } else {
                break;
            }

            if (newList == null) {
                newList = new ListNode(currentVal);
                currentNode = newList;
            } else {
                currentNode.next = new ListNode(currentVal);
                currentNode = currentNode.next;
            }
        }

        return newList;
    }

    /**
     *
     * @param lists An array of Linked Lists made up of ListNodes
     * @return The merged, sorted list from all lists provided
     */
    public static ListNode mergeSortedLists(ListNode[] lists) {

        ListNode newList = null;
        ListNode currentNode = new ListNode();
        Integer indexToMerge;

        while (true) {
            indexToMerge = findSmallestValue(lists);

            if (indexToMerge == null) {
                break;
            }

            if (newList == null) {
                newList = new ListNode(lists[indexToMerge].val);
                currentNode = newList;
            } else {
                currentNode.next = new ListNode(lists[indexToMerge].val);
                currentNode = currentNode.next;
            }

            lists[indexToMerge] = lists[indexToMerge].next;
        }

        return newList;
    }

    private static Integer findSmallestValue(ListNode[] lists) {
        int index = 0;
        int minimumVal = Integer.MAX_VALUE;
        int minIndex = 0;
        int nullCount = 0;

        for (ListNode node : lists) {
            if (node == null) {
                nullCount++;
                index++;
                continue;
            }
            if (node.val < minimumVal) {
                minimumVal = node.val;
                minIndex = index;
            }

            index++;
        }

        if (nullCount == lists.length) {
            return null;
        }
        return minIndex;
    }

    public static ListNode[] generateLists() {
        ListNode listOne = new ListNode(1);
        listOne.next = new ListNode(4);
        listOne.next.next = new ListNode(5);

        ListNode listTwo = new ListNode(1);
        listTwo.next = new ListNode(3);
        listTwo.next.next = new ListNode(4);

        ListNode listThree = new ListNode(2);
        listThree.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];

        lists[0] = listOne;
        lists[1] = listTwo;
        lists[2] = listThree;

        return lists;
    }
}
