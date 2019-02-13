package com.svit.java.l5;

/**
 * 
 * @author sv-it
 *
 */

class MyAnothterThread implements Runnable  {
    public void run() {
            System.out.println("This implemented thread is running ... ");
    }
}  

public class ImplRunnableDemo {

	public static void main(String[] args) {
        Thread t = new Thread(new MyAnothterThread());
        t.start();
	}

}
