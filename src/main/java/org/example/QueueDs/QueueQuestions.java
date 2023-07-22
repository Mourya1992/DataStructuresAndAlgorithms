package org.example.QueueDs;

import java.util.Stack;

public class QueueQuestions {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void implementingQueueWithStacks() {
        add(10);
        add(20);
        add(30);
      while (!stack1.empty()){
          System.out.println(stack1.pop());
      }
    }

    public void add(int number) {
        if (stack1.empty()) {
            stack1.push(number);
        }
        else{
            while(!stack1.empty()){
                int num = stack1.pop();
                stack2.push(num);
            }
            stack1.push(number);
            while (!stack2.empty()){
                int num2 = stack2.pop();
                stack1.push(num2);
            }

        }
    }

    public static void main(String[] args) {
QueueQuestions qq =new QueueQuestions();
qq.implementingQueueWithStacks();
    }
}
