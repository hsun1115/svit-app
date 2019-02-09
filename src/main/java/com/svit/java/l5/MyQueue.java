package com.svit.java.l5;
/**
 * @author sv-it
 */
import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
       // do initialization if necessary
       stack1 = new Stack();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(element);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        // write your code here
        return stack1.pop();
    }

    public int top() {
        // write your code here
        return stack1.peek();
    }
    
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		System.out.println(myQueue.pop());//1
		myQueue.push(2);
		myQueue.push(3);
		System.out.println(myQueue.top());//2
		System.out.println(myQueue.pop());//2
		System.out.println(myQueue.pop());//3
		
		

	}

}
