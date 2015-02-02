package com.tenxp.concurrent.blockingqueue.producer;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentLinkedProducer implements Runnable {

	protected ConcurrentLinkedQueue<String> queue = null;
	protected int interval;
	
	public ConcurrentLinkedProducer(ConcurrentLinkedQueue<String> queue, int interval) {
		this.queue = queue;
		this.interval = interval;
	}

	public void run() {
		try {

			while (true) {
				queue.add("String Put :: " + ThreadLocalRandom.current().nextInt(0,1000));
				Thread.sleep(interval);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
