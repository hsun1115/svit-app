package com.svit.java.l4;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is to explain how fail safe iterator works, no exception is expected.  Expected output is : 3 1 2
 * 
 * @author sv-it
 */
public class FailSafeDemo {

	public static void main(String[] args) {
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C","3");
        
        Iterator iterator = map.keySet().iterator();
        
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
            map.put("B", "4");
        }

	}

}
