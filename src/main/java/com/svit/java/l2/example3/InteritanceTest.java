package com.svit.java.l2.example3;

/**
 * To test inheritance and hiding fields/methods and sub/parent identity
 * @author sv-it
 */
class A{
	int a;
	public A(int i){
		a = i;
	}	
	public void identify(){
		printPhrase("Class A");
	}
	public void printPhrase(String s){
		System.out.println(s);
	}
}

class B extends A{
	public B(int i){
		super(i);
	}	
	public void identify(){
		printPhrase("Class B");	
	}
	public int instanceField(){
		return a;	
	}
}


class ClassA {
    public static void methodOne(int i) {}
    public void methodTwo(int i) {}
    public static void methodThree(int i) {}
    public static void methodFour(int i) {}
}

class ClassB extends ClassA {
    //method with compile-time errors - This static method cannot hide the instance method from ClassA
    //public void methodOne(int i) {}
    
    //overrides a method in the superclass
    public void methodTwo(int i) {}
    
    //method with compile-time errors - - This instance method cannot override the static method from ClassA
    //public void methodThree(int i) {}
    
    //hides a method in the superclass if a static method is redefined in subclass
    public static void methodFour(int i) {}
}   


public class InteritanceTest{
	public static void main(String[] args){
		B b = new B(2);
		b.identify();
		System.out.println(b.instanceField());	
		
		
		A a = new A(3);
		a.identify();
		System.out.println(((B)a).instanceField());		

		//runtime exception 
//		b = (B)a;
//		System.out.println(b.instanceField() + "**");

        ClassA a1 = new ClassA();
        ClassA a2 = new ClassB();		
	}
}