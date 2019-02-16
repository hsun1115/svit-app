package com.svit.java.l6;

/**
 * The join() method of a Thread instance can be used to "join" the start of a thread's execution to the end of another thread's 
 * execution so that a thread will not start running until another thread has ended. If join() is called on a Thread instance, 
 * the currently running thread will block until the Thread instance has finished executing.
 * 
 * The ThreadExample class creates a RunnableJob object. It creates 4 threads named "T1", "T2", "T3", and "T4" with the 
 * RunnableJob object. It calls start() and then join() on each thread, in order. This blocks the execution of the 
 * current (main) thread from proceeding until the thread has completed. This means that the main thread will block for 1 second 
 * at each join(), since the RunnableJob sleeps for 1 second. Following this, ThreadExample creates 4 more threads, 
 * "T5", "T6", "T7", and "T8". This time, no joins are called on these threads, so the main thread will not block.
 * @author bzhou
 * @since 2013-03-09
 */
import java.util.Date;

class RunnableJob implements Runnable {

    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("RunnableJob is being run by " + thread.getName() + " at " + new Date());
        
        try {
            Thread.sleep(1000);
            System.out.println("xxx this is " + thread.getName() + " after sleep()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class JoinDemo
{
    public static void main(String[] args)
    {
        RunnableJob runnableJob = new RunnableJob();

        try{
            Thread thread1 = new Thread(runnableJob, "T1");
            Thread thread2 = new Thread(runnableJob, "T2");
            Thread thread3 = new Thread(runnableJob, "T3");
            Thread thread4 = new Thread(runnableJob, "T4");
    
            thread1.start();//start thread1 to run
            thread1.join();//this means: main thread will wait for this thread1 die before processing other threads
            
            thread2.start();
            thread2.join();
            
            thread3.start();
            thread3.join();
            
            thread4.start();
            thread4.join();
    
            Thread thread5 = new Thread(runnableJob, "T5");
            Thread thread6 = new Thread(runnableJob, "T6");
            Thread thread7 = new Thread(runnableJob, "T7");
            Thread thread8 = new Thread(runnableJob, "T8");
    
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
        }
        catch (InterruptedException e)
        {
            
        }
    }

}
