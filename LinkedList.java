class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Node head = null;
        
        head = insertToBack(head, 5); // 5 -> NULL
        head = insertToBack(head, 8); // 5 -> 8 -> NULL
        head = insertToBack(head, 2); // 5 -> 8 -> 2 -> NULL
        head = insertToFront(head, 11); // 11 -> 5 -> 8 -> 2 -> NULL
        head = insertToBack(head, 23); // 11 -> 5 -> 8 -> 2 -> 23 -> NULL
        head = insertToMiddle(head, 2, 14); // 11 -> 5 -> 14 -> 8 -> 2 -> 23 -> NULL
        printList(head);

        head = deleteLastNode(head); // 11 -> 5 -> 14 -> 8 -> 2 -> NULL
        printList(head);

        head = deleteNode(head, 14); // 11 -> 5 -> 8 -> 2 -> NULL
        printList(head);

        head = deleteFrontNode(head); // 5 -> 8 -> 2 -> NULL
        printList(head);
    }

    public static Node insertToFront(Node head, int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        return newHead;
    }

    public static Node insertToBack(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);

        return head;
    }

    public static Node insertToMiddle(Node head, int index, int data) {
        if (head == null || index == 0) {
            Node newHead = new Node(data);
            newHead.next = head;
            return newHead;
        } 

        Node prev = null;
        Node current = head;
        Node newNode = new Node(data);

        while (current != null && index > 0) {
            prev = current;
            current = current.next;
            index--;
        }

        if (current == null) {
            prev.next = newNode;
        } else {
            prev.next = newNode;
            newNode.next = current;
        }

        return head;
    }

    public static Node deleteFrontNode(Node head) {
        if (head == null) return null;
        return head.next;
    }

    public static Node deleteLastNode(Node head) {
        if (head == null) return null;

        Node prev = null;
        Node current = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;

        return head;
    }

    public static Node deleteNode(Node head, int data) {
        if (head == null) return null;

        Node prev = null;
        Node current = head;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }

        return head;
    }

    public static void destroyList(Node head) {
        head = null;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }
}