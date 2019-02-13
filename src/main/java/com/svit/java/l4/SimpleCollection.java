package com.svit.java.l4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author sv-it
 *
 */
public class SimpleCollection {

	public static void main(String[] args) {
		List c;
		c = new ArrayList();
		System.out.println(c.getClass().getName());
		for (int i=1; i <= 10; i++) { 
			c.add(i + " * " + i + " = "+i*i);
		}
		Iterator iter = c.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}
}
