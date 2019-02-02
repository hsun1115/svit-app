package com.svit.java.l3;
/**
 * 
 * @author sv-it
 * 
 */
public class ExceptionHandlingDemo {
    public static void main(String args[]) {
        try {
            aMethod();
        } catch (Exception e) /* Line 20 */
        {
            System.out.println("exception ");
        }
        System.out.println("finished"); /* Line 24 */
    }

    public static void aMethod() throws Exception {
        try /* Line 5 */
        {
            throw new Exception(); /* Line 7 */
        } catch (Exception e) {
            System.out.println("exception@aMethod ");
        } finally /* Line 9 */
        {
            System.out.println("finally "); /* Line 11 */
        }
    }
}