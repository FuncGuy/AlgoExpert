public class DoublyLinkedList {
    private static DoublyLinkedList head;
    private static DoublyLinkedList tail;

    private int data;
    private DoublyLinkedList next;
    private DoublyLinkedList prev;

    public DoublyLinkedList(int data) {
        this.data = data;
    }


    public static void removeNode(DoublyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void insertAtPos(DoublyLinkedList node, int pos) {
        int counter = 0;

        DoublyLinkedList temp = head;
        while (temp != null && counter != pos - 1) {
            counter += 1;
            temp = temp.next;
        }

        DoublyLinkedList temp2 = temp.next;
        temp.next = node;
        node.prev = temp;
        node.next = temp2;
    }


    public static void insertAtFirst(DoublyLinkedList node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;

    }

    public static void insertAtLast(DoublyLinkedList node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public static void display() {
        DoublyLinkedList temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList first = new DoublyLinkedList(1);
        head = first;
        DoublyLinkedList second = new DoublyLinkedList(2);
        head.next = second;
        second.prev = head;
        DoublyLinkedList third = new DoublyLinkedList(3);
        second.next = third;
        third.prev = second;
        DoublyLinkedList fourth = new DoublyLinkedList(4);
        fourth.prev = third;
        third.next = fourth;

        tail = fourth;

        insertAtFirst(new DoublyLinkedList(0));

        insertAtLast(new DoublyLinkedList(5));

        removeNode(third);

        insertAtPos(new DoublyLinkedList(2), 3);

        display();
    }
}
