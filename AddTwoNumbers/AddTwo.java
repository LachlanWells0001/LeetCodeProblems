public class AddTwo{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){
            //Check for values in l1 and l2, if they are null default to 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            //Self explainatory
            int sum = x + y + carry;

            //Get the carry value
            carry = sum / 10;
            
            //Get the remainder and add it into the list
            current.next = new ListNode(sum % 10);
            current = current.next;

            //If there is still values get them
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }

    // Helper method to create a singularly linked list from an array
    public static ListNode createLinkedList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode current = head;

        for (int value : array) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return head.next;
    }

    // Helper method to print a singularly linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] array1 = {2, 4, 3};
        int[] array2 = {5, 6, 4};

        ListNode l1 = createLinkedList(array1);
        ListNode l2 = createLinkedList(array2);

        AddTwo solution = new AddTwo();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("Input: ");
        printLinkedList(l1);

        System.out.print("Input: ");
        printLinkedList(l2);

        System.out.print("Output: ");
        printLinkedList(result);
    }
}