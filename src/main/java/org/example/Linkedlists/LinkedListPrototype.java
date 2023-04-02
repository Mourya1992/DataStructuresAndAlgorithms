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

    public void reverseLinkedList() {

        if (head == null || head.next == null) {
            return;
        }
        Node previous = head;
        Node currentNode = head.next;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = previous;
    }

    public int find(String value){
        int count = -1;
        if(head==null){
            return  -1;
        }
        if(head.next==null){
            if(head.data==value){
                count++;
            }
            return count;
        }
        Node currentNode = head;
        while(currentNode!=null){
            count++;
            if(currentNode.data==value){
                return count;
            }
            currentNode=currentNode.next;

        }
        return  -1;
    }


    public static void main(String[] args) {
        LinkedListPrototype linkedListPrototype = new LinkedListPrototype();
        linkedListPrototype.addLast("one");
        linkedListPrototype.addLast("two");
        linkedListPrototype.addLast("three");
        linkedListPrototype.addLast("four");
        linkedListPrototype.addLast("five");
        linkedListPrototype.printList();
        linkedListPrototype.reverseLinkedList();
        linkedListPrototype.printList();
        int index = linkedListPrototype.find("twelve");
        System.out.println("two is presengt at :"+index);

    }
}
