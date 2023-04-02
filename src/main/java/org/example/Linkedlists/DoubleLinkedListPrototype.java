package org.example.Linkedlists;

public class DoubleLinkedListPrototype {

    DoubleLinkedListNode head;

    public static void main(String[] args) {
        DoubleLinkedListPrototype dl = new DoubleLinkedListPrototype();
        dl.addLast("one");
        dl.addLast("two");
        dl.addLast("three");
        dl.addLast("four");
        dl.addFirst("zero");

        dl.printDoubleLinkedList();
        dl.deleteFirst();
        dl.deleteFirst();
        dl.deletelast();
        dl.deletelast();
        dl.deleteFirst();
        dl.printDoubleLinkedList();

    }

    public void printDoubleLinkedList() {
        if (head == null) {
            System.out.print("List is empty");
            return;
        }
        DoubleLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.nextNode;
        }
        System.out.println("NULL");
    }

    public void addFirst(String data) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.previousNode = null;
        newNode.nextNode = head;
        head.previousNode = newNode;
        head = newNode;

    }

    public void addLast(String data) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DoubleLinkedListNode currentNode = head;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;

        }
        newNode.nextNode = null;
        currentNode.nextNode = newNode;
        newNode.previousNode = currentNode;


    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("the List is empty:");
        }
        if(head.nextNode==null){
            head=null;
            return;
        }
        head.nextNode.previousNode = null;
        head = head.nextNode;
    }

    public void deletelast() {
        if (head == null) {
            System.out.println("the List is empty:");
        }
        if (head.nextNode == null) {
            head = null;
            return;
        }
        DoubleLinkedListNode currentNode = head;
        DoubleLinkedListNode previousCurrentNode = null;
        while (currentNode.nextNode != null) {
            previousCurrentNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        previousCurrentNode.nextNode = null;
    }




}
