package com.svit.java.l6;

import java.util.Observable;
import java.util.Observer;

/**
 * To understand Observer Design Pattern, we will take one real time example. We
 * read newspaper. We get the daily news by news paper. Here, we are the observer
 * and the news paper is observable. Observer Design Pattern keeps the data of
 * its entire listener and whenever there is any change it notifies to its
 * listener.
 * 
 * @author sv-it
 * 
 */
class FirstNewsReader implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("FirstNewsReader got The news:" + (String) arg);
	}
}

class SecondNewsReader implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("SecondNewsReader got The news:" + (String) arg);
	}
}

class News extends Observable {
	void broadcast() {
		String[] news = { "News 101", "News 202", "News 303" };
		for (String s : news) {
			// set change
			setChanged();
			// notify observers for change
			notifyObservers(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error Occurred.");
			}
		}
	}
}

public class ObserverPatternDemo {
	public static void main(String args[]) {
		News observedNews = new News();
		FirstNewsReader reader1 = new FirstNewsReader();
		SecondNewsReader reader2 = new SecondNewsReader();
		observedNews.addObserver(reader1);
		observedNews.addObserver(reader2);
		observedNews.broadcast();
	}
}
