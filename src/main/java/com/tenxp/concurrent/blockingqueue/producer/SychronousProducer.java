package com.tenxp.concurrent.blockingqueue.producer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;

public class SychronousProducer implements Runnable {

	protected SynchronousQueue<String> queue = null;
	protected int interval;
	
	public SychronousProducer(SynchronousQueue<String> queue, int interval) {
		this.queue = queue;
		this.interval = interval;
	}

	public void run() {
		try {
			while (true) {
				int data = ThreadLocalRandom.current().nextInt(0,1000);
				System.out.println("Put Data :: " + data);
				queue.put("String Put :: " + data);
				Thread.sleep(interval);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
