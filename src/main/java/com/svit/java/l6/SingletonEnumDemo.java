package com.svit.java.l6;

/**
 * Singleton: a class can be instantiated only once in JVM per class loader.
 * Repeated calls always return the same instance.
 * 
 * @author sv-it
 */
enum EnumSingleton {

    INSTANCE;
    
    public static void doSomething(){
        //do something
    }
}

public class SingletonEnumDemo {
    public static void main(String[] args) {
    	EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

    	System.out.println("Singleton object obtained!" + enumSingleton);

    }
}
