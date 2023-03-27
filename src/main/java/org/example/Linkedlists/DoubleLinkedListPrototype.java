package org.example.Linkedlists;

public class DoubleLinkedListPrototype {

    DoubleLinkedListNode head;
    public static void main(String[] args) {
        DoubleLinkedListPrototype dl = new DoubleLinkedListPrototype();
        dl.addFirst("one");
        dl.addFirst("two");
        dl.printDoubleLinkedList();

    }

    public void printDoubleLinkedList(){
        if(head == null){
            System.out.print("List is empty");
            return;
        }
        DoubleLinkedListNode currentNode = head;
        while(currentNode!=null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.nextNode;
        }
    }


    public void addFirst(String data){
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
        if(head == null){
            head=newNode;
            return;
        }
        newNode.previousNode=null;
        newNode.nextNode=head;
        head.previousNode=newNode;
        head=newNode;

    }

}
