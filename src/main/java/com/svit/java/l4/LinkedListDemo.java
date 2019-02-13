package com.svit.java.l4;
//Demo LinkedList
import java.util.LinkedList;


class LinkedListDemo{
	public static void main(String args[]){
		//Create a linked list
		LinkedList list = new LinkedList();
		
		//add elements to the linked list
		list.add("F");	
		list.add("B");	
		list.add("D");	
		list.add("E");	
		list.add("C");	
		
		list.addLast("Z");
		list.addFirst("A");
		list.add(0, "A2"); //index starts from 0, then 1, 2, 3...
		
		System.out.println("Original contents of ll: " + list);
		
		//remove elements from the linked list
		list.remove("F");
		list.remove(2);
		
		System.out.println("Contents of ll after deletion: " + list);
		//remove first and last elemetns 
		list.removeFirst();
		list.removeLast();
		
		System.out.println("ll after deleting first and last: " + list);
		
		//get and set a value
		Object val = list.get(2);
		list.set(2, (String)val + " Changed");
		
		System.out.println("ll after change: " + list);
	}	
	
}