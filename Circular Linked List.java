import java.util.Scanner;

class CircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head = null;
    Node tail = null;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    void insertAtPosition(int data, int position) {
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        if (head == null) {
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;

            if (temp == head) {
                return;
            }
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }

        tail.next = head;
    }

    void deleteFromBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    void deleteFromEnd() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        tail = temp;
        tail.next = head;
    }

    void deleteFromPosition(int position) {
        if (head == null) {
            return;
        }

        if (position < 1) {
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;

            if (temp == head) {
                return;
            }
        }

        if (temp.next == head) {
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
        tail.next = head;
    }

    int LLlength() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Node temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CircularLinkedList list = new CircularLinkedList();

        int choice, data, position;

        do {
            System.out.println("\n===== CIRCULAR LINKED LIST =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Length of the List");
            System.out.println("8. Display");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    System.out.print("Enter position: ");
                    position = sc.nextInt();

                    list.insertAtPosition(data, position);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    list.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.deleteFromPosition(position);
                    break;

                case 7:
                    System.out.println(
                        "Number of nodes: " + list.LLlength()
                    );
                    break;

                case 8:
                    list.display();
                    break;

                case 9:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}