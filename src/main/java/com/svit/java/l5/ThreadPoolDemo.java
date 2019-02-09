package com.svit.java.l5;

/**
 * @author sv-it
 */
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 

class Task implements Runnable { 
	private String name; 
	
	public Task(String s) 
	{ 
		name = s; 
	} 
	
	public void run() 
	{ 
		try
		{ 
			for (int i = 0; i<=6	; i++) 
			{ 
				if (i==0) 
				{ 
					Date d = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
					System.out.println("Set up time for"
							+ " task name - "+ name +" = " +ft.format(d)); 
				} 
				else
				{ 
					Date d = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
					System.out.println("Running time for task name - "+ 
							name +" = " +ft.format(d)); 
				} 
				Thread.sleep(2000); 
			} 
			System.out.println(name+" done"); 
		} 
		
		catch(InterruptedException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
} 
public class ThreadPoolDemo 
{ 
	// Maximum number of threads in thread pool 
	static final int MAX_T = 3;			 

	public static void main(String[] args) 
	{ 
		// creates tasks 
		Runnable r1 = new Task("task 1"); 
		Runnable r2 = new Task("task 2"); 
		Runnable r3 = new Task("task 3"); 
		Runnable r4 = new Task("task 4"); 
		Runnable r5 = new Task("task 5");	 
		
		// creates a thread pool with MAX_T no
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T); 
		
		pool.execute(r1); 
		pool.execute(r2); 
		pool.execute(r3); 
		pool.execute(r4); 
		pool.execute(r5); 

		pool.shutdown();	 
	} 
} 
