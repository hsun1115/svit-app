package com.svit.java.l2.example1;
/**
 * 
 * @author sv-it
 *
 */
public class Stock implements Printable1
{
    private String tickerSymbol = new String("XYZ");
    private int shares = 100;
    private int currentPrice = 4000; // in pennies
     
    public void printAll()
    {
    	System.out.println(tickerSymbol + " " + shares + " shares at " + currentPrice);
    	System.out.println("Value: " + currentPrice * shares);    
    }
    
    //additional method not defined in interface
    public void sell() {
    	System.out.println(tickerSymbol + " sold");
    }
}
