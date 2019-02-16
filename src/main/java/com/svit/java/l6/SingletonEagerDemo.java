package com.svit.java.l6;

/**
 * Singleton: a class can be instantiated only once in JVM per class loader.
 * Repeated calls always return the same instance.
 * 
 * eager initialization, the instance of Singleton Class is created at the time of 
 * class loading, this is the easiest method to create a singleton class but it has 
 * a drawback that instance is created even though client application might not be using it.
 * 
 * @author sv-it
 */
public class SingletonEagerDemo {
	  // public instance initialized when loading the class 
	  public static SingletonEagerDemo instance = new SingletonEagerDemo(); 
	  
	  private SingletonEagerDemo() { 
	    // private constructor 
	  } 
	  
	  public static SingletonEagerDemo getSingletonObject(){
		  return instance;
	  }
	  
    public static void main(String[] args) {
         // Your Business Logic to return singleton objects, which are from same memory location
        System.out.println("Singleton object obtained!"
                + getSingletonObject());

        System.out.println("Singleton object obtained 2nd time!"
                + getSingletonObject());

        System.out.println("Singleton object obtained 3rd time!"
                + getSingletonObject());

    }
}
