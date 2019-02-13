package com.svit.java.l4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This is to explain how fail fast iterator works exception
 * java.util.ConcurrentModificationException is expected
 * 
 * 
 * @author sv-it
 */
public class FailFastDemo {

	public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C","3");
        
        Iterator iterator = map.keySet().iterator();
        
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
            map.put("D", "4"); //modification causes java.util.ConcurrentModificationException
        }

	}

}
