package com.svit.java.l6;

/**
 * Singleton: a class can be instantiated only once in JVM per class loader.
 * Repeated calls always return the same instance.
 * 
 * Singletons can be used to create a Connection Pool. If programmers create a
 * new connection object in every class that requires it, then its clear waste
 * of resources. In this scenario by using a singleton connection class we can
 * maintain a single connection object which can be used throughout the
 * application.
 * 
 * @author sv-it
 */

//class Singleton1 { 
//  // public instance initialized when loading the class 
//  public static Singleton1 instance = new Singleton1(); 
//  
//  private Singleton1() { 
//    // private constructor 
//  } 
//} 

class Singleton {
    // private static Singleton singletonObject;
    private volatile static Singleton singletonObject; // use volatile to avoid
                                                       // uncertainty issue by
                                                       // compiler from double
                                                       // check locking

    // Step 1: Provide a default Private constructor ; A private Constructor
    // prevents any other class from instantiating.
    private Singleton() {
        // this constructor is required to override default public constructor
        // Implementation code is optional in private constructor,
    }

    // Step 2: Create a Method for getting the reference to the Singleton Object
    // Step 3: Make the Access method Synchronized to prevent Thread Problems.
    public static synchronized Singleton getSingletonObject() {
        if (singletonObject == null) { // first lock
            synchronized (Singleton.class) {
                if (singletonObject == null) // double lock
                    singletonObject = new Singleton();
            }

        }
        return singletonObject;
    }

    // Step 4: Override the Object clone method to prevent cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

public class SingletonLazyDemo {

    public static void main(String[] args) {
         // Your Business Logic to return singleton objects, which are from same memory location
        System.out.println("Singleton object obtained!"
                + Singleton.getSingletonObject());

        System.out.println("Singleton object obtained again!"
                + Singleton.getSingletonObject());

        System.out.println("Singleton object obtained 3rd time!"
                + Singleton.getSingletonObject());

    }
}
