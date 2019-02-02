package com.svit.java.l3;
/**
 * 
 * @author sv-it
 *
 */
public class SqrtSolution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
       if (x<=0) return 0;

        long low=1, high=x;
        long mid = 0;
        while(low<=high){
            mid = low + (high-low)/2; //19
            System.out.print("low = " + low + "\t");
            System.out.print("high = " + high + "\t");
            System.out.print("mid = " + mid + "\t");
            System.out.print("====\n");
            
            if (mid * mid > x){
                high=mid-1;
            } else if (mid * mid <x){
                low = mid+1; 
            } else {
                return (int)mid;
            }
        }
        
        

        return (int)(low+high)/2;   
    }
    
	public static void main(String args[]) 
	{ 
		SqrtSolution s = new SqrtSolution(); 
		System.out.println(s.sqrt(38));		
	} 
}
