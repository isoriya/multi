package com.tenxp.concurrent.blockingqueue.consumer;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedConsumer implements Runnable {

	protected ConcurrentLinkedQueue<String> queue = null;
	protected int interval;
	
	public ConcurrentLinkedConsumer(ConcurrentLinkedQueue<String> queue, int interval) {
		this.queue = queue;
		this.interval = interval;
	}

	public void run() {
		try {

			while (true) {
				System.out.println(Thread.currentThread().getName() + "/" + queue.poll());
				Thread.sleep(interval);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
