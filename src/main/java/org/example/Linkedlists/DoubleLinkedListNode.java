package org.example.Linkedlists;

public class DoubleLinkedListNode {
    protected String data;
    protected DoubleLinkedListNode previousNode;
    protected DoubleLinkedListNode nextNode;

    public DoubleLinkedListNode(String data){
        this.data=data;
        this.previousNode=null;
        this.nextNode=null;
    }

}
