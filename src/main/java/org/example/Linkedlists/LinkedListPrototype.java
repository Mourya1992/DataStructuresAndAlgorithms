package org.example.Linkedlists;

public class LinkedListPrototype {
    Node head = null;

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;


    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("the list is empty");
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }

        System.out.println("NULL");
    }

    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }


        head = head.next;
    }

    public void deleteLastNode() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLastNode = null;
        Node lastNode = head;

        while (lastNode.next != null) {
            secondLastNode = lastNode;
            lastNode = lastNode.next;


        }
        secondLastNode.next = null;
    }


    public static void main(String[] args) {
        LinkedListPrototype linkedListPrototype = new LinkedListPrototype();
        linkedListPrototype.addFirst("This");
        linkedListPrototype.addFirst("Hi");
        linkedListPrototype.addLast("is");
        linkedListPrototype.addLast("Mourya");
        linkedListPrototype.printList();
        linkedListPrototype.deleteLastNode();
        linkedListPrototype.deleteLastNode();
        linkedListPrototype.deleteLastNode();
        linkedListPrototype.deleteLastNode();


        linkedListPrototype.printList();


    }


}
