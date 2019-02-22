package com.svit.java.l6;


/**
 * 
 * @author sv-it
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPatternDemo {
	public static void main(String[] args) {
        List<Shape> list = new ArrayList<Shape>();
        list.add(new Rectangle());
        list.add(new Square());
        list.add(new Circle());
    
		System.out.println("Use built-in iterator for iterator patter");
		Iterator<Shape> iterator = list.iterator();
		while(iterator.hasNext()) {
			Shape shape = (Shape)iterator.next();
		    System.out.println(shape.getDesc());
		}
	}
}
