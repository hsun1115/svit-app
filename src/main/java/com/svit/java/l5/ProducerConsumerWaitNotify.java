package com.svit.java.l5;

/**
 * An implementation of a producer and consumer via wait() and notify();
 *
 * @author sv-it
 */
public class ProducerConsumerWaitNotify {
	static final int MAX = 10;
	static int count = 1;

	static class Q {
		int n;
		boolean valueSet = false;

		synchronized int get() {
			if (!valueSet) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException caught");
				}
			}
			System.out.println("Got: " + n);
			valueSet = false;
			notify();
			return n;
		}

		synchronized void put(int n) {
			if (valueSet) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException caught");
				}
			}
			this.n = n;
			valueSet = true;
			System.out.println("Put: " + n);
			notify();
		}
	}

	static class Producer implements Runnable {
		Q q;

		Producer(Q q) {
			this.q = q;
			new Thread(this, "Producer").start();
		}

		@Override
		public void run() {
			int i = 0;
			// while (true) {
			while (count++ <= MAX) {
				q.put(i++);
			}
		}
	}

	static class Consumer implements Runnable {
		Q q;

		Consumer(Q q) {
			this.q = q;
			new Thread(this, "Consumer").start();
		}

		@Override
		public void run() {
			// while (true) {
			while (count - 1 <= MAX) {
				q.get();
			}
		}
	}

	public static void main(String args[]) {

		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}
