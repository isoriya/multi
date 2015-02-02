package com.tenxp.concurrent.blockingqueue.consumer;

import java.util.concurrent.SynchronousQueue;

public class SychronousConsumer implements Runnable {

	protected SynchronousQueue<String> queue = null;
	protected int interval;
	
	public SychronousConsumer(SynchronousQueue<String> queue, int interval) {
		this.queue = queue;
		this.interval = interval;
	}

	public void run() {
		try {

			while (true) {
				System.out.println(Thread.currentThread().getName() + "/" + queue.take());
				Thread.sleep(interval);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
