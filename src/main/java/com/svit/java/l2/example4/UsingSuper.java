package com.svit.java.l2.example4;

/**
 * If your method overrides one of its superclass's methods, you can invoke the overridden method through
 * the use of the keyword super. You can also use super to refer to a hidden field (although hiding fields is discouraged).
 * Consider following testing case as sample to use super to call super class methods
 * @author sv-it
 */

class Superclass {
	protected void printMethod() {
		System.out.println("Printed in Superclass.");
	}
}

class Subclass extends Superclass {

	@Override
	public void printMethod() {
		super.printMethod(); //using super to invoke super class methods
		System.out.println("Printed in Subclass");
	}

}

public class UsingSuper
{
	public static void main(String[] args) {
		Subclass s = new Subclass();
		s.printMethod();
	}
}
