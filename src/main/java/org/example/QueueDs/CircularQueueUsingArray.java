package org.example.QueueDs;

import javax.naming.PartialResultException;

public class CircularQueueUsingArray {
    private int[] queueDs;
    private int size;
    private int head = -1;
    private int rear = -1;

    public CircularQueueUsingArray(int size) {
        this.size = size;
        queueDs = new int[size];
    }

    public boolean isQueueFull() {
        return rear == size - 1;
    }

    public boolean isQueueEmpty() {
        return head == -1 && rear == -1;
    }

    public int remove() {

        if (head == -1) {
            head = 0;
            return queueDs[head];
        } else if (head == rear) {
            head=rear=-1;
            return queueDs[head];
        } else {
            head = (head + 1) % size;
            return queueDs[head];
        }
    }

    public void add(int data) {
        if (!isQueueFull()) {
            rear = (rear + 1) % size;
            queueDs[rear] = data;
        }
    }

    public static void main(String[] args) {
        CircularQueueUsingArray queue = new CircularQueueUsingArray(5);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        System.out.println(queue.remove());
        queue.add(6);
        System.out.println(queue.remove());
        queue.add(7);



    }
}
