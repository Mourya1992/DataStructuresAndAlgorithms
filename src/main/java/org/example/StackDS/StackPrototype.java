package org.example.StackDS;

import org.example.Linkedlists.Node;

public class StackPrototype {

   private  Node head ;
    public void push(String n){
        System.out.println("PUSH OPERATION");
        Node node = new Node(n);
        if(isListEmpty()){
            head = node;
            return;
        }
            node.next = head;
            head = node;

    }

    public  String pop(){
      //  System.out.println("POP OPERATION");
        String name=null;
        if(!isListEmpty()) {
            name = head.data;
            head = head.next;
        }
        return name;
    }

    public String peek(){
        return head.data;
    }

    public  boolean isListEmpty(){
        return head==null;
    }

    public void insertAtTheBottom(int num, java.util.Stack<Integer> s){

        if(s.empty()){
            s.push(num);
            return;
        }
         int top= s.pop();
        insertAtTheBottom(num,s);
        s.push(top);

    }

    public static void main(String[] args) {

       /* Stack stack = new Stack();
        stack.push("ONE");
        stack.push("TWO");
        stack.push("THREE");
        stack.push("FOUR");
        String name = null;
        while(!stack.isListEmpty()){
            name = stack.pop();
            System.out.println(name);

        }*/
        StackPrototype sp =new StackPrototype();
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        sp.insertAtTheBottom(50,stack);
        while(!stack.empty()){
            System.out.println(stack.pop());
        }


    }



}
