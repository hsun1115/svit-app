package com.svit.java.l2.example1;
/**
 * 
 * @author sv-it
 *
 */
public class Person implements Printable1
{
     private String name = new String("Bill");
     private int age = 22;
     @Override
     public void printAll() {
    	 System.out.println("Name is " + name + ", age is " + age);
     }
}
