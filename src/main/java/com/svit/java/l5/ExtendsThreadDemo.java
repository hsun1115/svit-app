package com.svit.java.l5;

/**
 * 
 * @author sv-it
 *
 */
class MyThread extends Thread {
	public void run() {
		System.out.println("This extended thread is running ... ");
	}
}

public class ExtendsThreadDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}

}