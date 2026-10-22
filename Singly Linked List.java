import java.util.Scanner;

class SinglyLinkedList {
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
    
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void insertAtMid(int data, int position) {

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        
    }
   
    void deleteFromBeginning() {

        if (head == null) {
            return;
        }
        
        head = head.next;
    }
    
    void deleteFromEnd() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
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

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }
   
    int LLlength() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
    
    void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    void reverse() {

        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int choice, data, position;

        do {
            System.out.println("\n===== SINGLY LINKED LIST =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Length of the List");
            System.out.println("8. Display");
            System.out.println("9. Reverse");
            System.out.println("10. Exit");

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

                    list.insertAtMid(data, position);
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
                    System.out.println("Number of nodes: " + list.LLlength());
                    break;

                case 8:
                    list.display();
                    break;

                case 9:
                    list.reverse();
                    break;

                case 10:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}