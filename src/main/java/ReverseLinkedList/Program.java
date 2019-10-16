package ReverseLinkedList;

public class Program {
    // O(n) time | O(1) space - where n is the number of nodes in the Linked List
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList p1 = null;
        LinkedList p2 = head;
        while (p2 != null) {

            // keep the reference of next node before p2 points to previous node
            LinkedList p3 = p2.next;

            // main logic goes here i.e reverse arrow here to point to previous node
            p2.next = p1;

            // here just right shift the nodes
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    public static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
