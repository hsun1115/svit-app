package com.svit.java.l2.example1;
/**
 *                           (interface) Printable1
 *                            ------------|-----------
 *                            |                       |
 *                                              (interface) Printable2
 *                                                    |
 *                      Person, Stock                Cat
 * @author sv-it                                       
 */
		
public class PrintableTest
{
	public static void main(String[] args)
    {
          Person p = new Person();
          Stock s = new Stock();
        
          p.printAll();
          s.printAll();
        
          System.out.println("---------------------");
          Printable1 pr;
          pr = p;
          pr.printAll();
          pr = s;
          pr.printAll();
         
          System.out.println("---------------------");
          
          if (pr instanceof Stock) 
          {
              ((Stock) pr).sell();
          }
          
          Printable2 cat = new Cat();
          cat.printAll(System.err);
          cat.printAll();          
    }

}
