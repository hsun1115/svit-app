package com.svit.java.l7;

interface InterfaceOne {
	// abstract method
	public void square(int a);

	// default method
	default void showDefault() {
		System.out.println("Default Method Executed");
	}

	// static method
	static void showStatic() {
		System.out.println("Static Method Executed");
	}
}

public class DefaultMethodDemo implements InterfaceOne {
	// implementation of square abstract method
	public void square(int a) {
		System.out.println(a * a);
	}

	public static void main(String args[]) {
		DefaultMethodDemo d = new DefaultMethodDemo();
		d.square(4);

		// default method executed
		d.showDefault();
		
		//static method executed
		InterfaceOne.showStatic();
	}
}
