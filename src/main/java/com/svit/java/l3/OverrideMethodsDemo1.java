package com.svit.java.l3;

/**
 * This example show to how to access inherited members 
 * Rule 1 - When you invoke a method through an object reference, the actual class of the object governs
 * which implementation is used 
 * 
 * Rule 2 - When you access a field, the declared type of the reference is used.
 * @author sv-it
 */

class BaseShow {
	public String str = "SuperStr";

	public void show() {
		System.out.println("Super.show: " + str);
	}
}

class ExtendShow extends BaseShow {
	public String str = "ExtendStr";

	// method overriding
	@Override
	public void show() {
		System.out.println("Extend.show: " + str);
	}
}

public class OverrideMethodsDemo1 {
	public static void main(String[] args) {
		ExtendShow ext = new ExtendShow();
		BaseShow base = ext;

		// will print Extend.show: ExtendStr, which is same as next show output
		base.show();
		// will print Extend.show: ExtendStr
		ext.show();

		System.out.println("base.str = " + base.str); // base.str = SuperStr
		System.out.println("ext.str = " + ext.str); // ext.str = ExtendStr
	}
}
