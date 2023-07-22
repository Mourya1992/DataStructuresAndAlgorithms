package org.example.StackDS;

import org.example.Linkedlists.Node;

import java.util.Stack;

public class StackPrototype {

    private Node head;

    public void push(String n) {
        System.out.println("PUSH OPERATION");
        Node node = new Node(n);
        if (isListEmpty()) {
            head = node;
            return;
        }
        node.next = head;
        head = node;

    }

    public String pop() {
        //  System.out.println("POP OPERATION");
        String name = null;
        if (!isListEmpty()) {
            name = head.data;
            head = head.next;
        }
        return name;
    }

    public String peek() {
        return head.data;
    }

    public boolean isListEmpty() {
        return head == null;
    }

    public void insertAtTheBottom(int num, java.util.Stack<Integer> s) {
        if (s.empty()) {
            s.push(num);
            return;
        }
        int top = s.pop();
        insertAtTheBottom(num, s);
        s.push(top);

    }

    public boolean paranthesisChecker(String x) {
        if (x == null) {
            return true;
        }
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < x.length(); i++) {

            if (stk.empty()) {
                stk.push(x.charAt(i));
            } else if ((stk.peek() == '[' && x.charAt(i) == ']') || (stk.peek() == '(' && x.charAt(i) == ')') || (stk.peek() == '{' && x.charAt(i) == '}')) {
                stk.pop();
            } else {
                stk.push(x.charAt(i));
            }

        }
        if (stk.empty()) {
            return true;
        } else {
            return false;
        }


    }

    public void reverseStak(Stack stackData) {
        if (stackData.empty()) {
            return;
        }
        int popped = (int) stackData.pop();
        reverseStak(stackData);
        insertAtTheBottom(popped, stackData);
    }

    public static void main(String[] args) {
        StackPrototype sp = new StackPrototype();
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
      /*  StackPrototype sp = new StackPrototype();
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek());*/
       /* sp.reverseStak(stack);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }*/

     //   StackPrototype sp = new StackPrototype();
       /*boolean result= sp.paranthesisChecker("[()]{(())}");
        System.out.println(result);
        [1,3,2,4,8,5,6]
        [1,2,3,4,5,6,8]
        2,4,3,5,6,8,-1

*/

        int[] stock = {100, 80, 60, 70, 60, 75, 85};
        int n= 7;
       int[] span =  sp.calculateSpan(stock,n);
        for(int i = 0;i<span.length;i++){
            System.out.print(span[i]+",");
        }

    }

    public  int[] calculateSpan(int price[], int n) {
        // Your code here
        Stack <Integer>stack=new Stack<>();
        int[] span=new int[n];
        for(int i=0;i<n;i++){
           while(!stack.empty() && price[i]>=price[stack.peek()]){
               stack.pop();
           }
           span[i]= stack.empty()?i+1:i-stack.peek();
           stack.push(i);
        }
        return span;
    }

}
