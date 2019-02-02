package com.svit.java.l3;
/**
 * @author sv-it
 *
 */
public class AddDigitsSolution {
    /**
     * @param num: a non-negative integer
     * @return: one digit
     */
    public int addDigits(int num) {
        int sum=0;
     
        String s = String.valueOf(num); // int 38 -> "38"
        for(int i=0; i<s.length(); i++){ //s.length = 2
            sum = sum + (s.charAt(i)-'0'); //s.charAt(i) = '8'
        }
     
        if(sum < 10){
            return sum;
        }else{
            return addDigits(sum);
        }
    }
    
//    public int addDigits(int num) {
//        return num - 9*((num-1)/9);
//    }
    
	// Driver code 
	public static void main(String args[]) 
	{ 
		AddDigitsSolution s = new AddDigitsSolution(); 
		System.out.println(s.addDigits(38));
		System.out.println(s.addDigits(138));
		
	} 
}
