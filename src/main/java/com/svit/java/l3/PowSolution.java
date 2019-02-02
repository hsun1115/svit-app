package com.svit.java.l3;
/**
 * 
 * @author sv-it
 * 
 */
public class PowSolution {
	public double pow(double x, int n) {
        if (n==0) return 1;
        boolean positive = true;
        if (n<0){
            positive = false;  
            n = -n;
        } 
        
        double result = 1.0;
        while(n>0){
            if (n%2==1){
                result *= x;
            }
            x = x * x ;
            n = n/2;
        }
        return positive?result:(1/result);
	}

    
	public static void main(String args[]) 
	{ 
		PowSolution s = new PowSolution(); 
		System.out.println(s.pow(3,3));
		
	} 
}
