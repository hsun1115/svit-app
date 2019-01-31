package com.svit.java.l2.example1;
/**
 * 
 * @author sv-it 
 *  
 */

import java.io.PrintStream;

public class Cat implements Printable2
{

    public void printAll(PrintStream p)
    {
       System.out.println("Meow");
    }

    public void printAll()
    {
        printAll(System.out);
    }

}
