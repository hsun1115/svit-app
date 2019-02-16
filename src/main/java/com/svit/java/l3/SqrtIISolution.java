package com.svit.java.l3;
/**
 * 
 * @author sv-it
 *
 */
public class SqrtIISolution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
      if (x == 0) return 0;
      double last = 0.0;
      double res = 1.0;
      while (res != last)
      {
          last = res;
          res = (res + x / res) / 2;
      } 
      return res;
    }
    
	public static void main(String args[]) 
	{ 
		SqrtIISolution s = new SqrtIISolution(); 
		System.out.println(s.sqrt(38.987));
	
		System.out.println(Math.sqrt(38));
	} 
}
