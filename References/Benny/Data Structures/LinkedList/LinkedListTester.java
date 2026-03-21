public class LinkedListTester {

    public static void main(String[] args) {
        // Create and populate the list
        LinkedList<Integer> list = new LinkedList<>();
        list.add(new Integer[]{5, 2, 9, 1, 7, 3});

        System.out.println("Original list: " + list);

        // Sort the list
        insertionSort(list);

        System.out.println("Sorted list:   " + list);
    }

    // In-place insertion sort for LinkedList
    public static void insertionSort(LinkedList<Integer> list) {
        if (list.head == null || list.head.next == null) {
            return; // empty or single element
        }

        Node sorted = null; // sorted sublist
        Node current = list.head;

        while (current != null) {
            Node next = current.next;

            // Insert current into sorted sublist
            if (sorted == null || ((Integer) sorted.data) >= ((Integer) current.data)) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && ((Integer) temp.next.data) < ((Integer) current.data)) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }

        // Update the original list's head and tail
        list.head = sorted;
        list.updateTail();
    }
}