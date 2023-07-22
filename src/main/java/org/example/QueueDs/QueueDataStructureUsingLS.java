package org.example.QueueDs;

import org.example.Linkedlists.Node;

public class QueueDataStructureUsingLS {

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null && tail==null;
    }

    public void add(String data) {
        Node dataNode = new Node(data);
        if (head == null) {
            head = tail = dataNode;
            return;
        } else {
            tail.next = dataNode;
            tail = dataNode;
        }
    }

    public String remove() {
        String data = null;
        if (head == tail) {
            data = head.data;
            head = tail = null;
            return data;
        } else {
            data = head.data;
            head = head.next;
        }

        return data;
    }

    public String peek() {
        return head.data != null ? head.data : null;
    }

    public static void main(String[] args) {
        QueueDataStructureUsingLS queue = new QueueDataStructureUsingLS();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("Four");
        queue.add("Five");
        while(!queue.isEmpty())
        {
            String dataFromQueue=queue.remove();
            System.out.println("peek object :"+queue.peek());
        }
    }
}
