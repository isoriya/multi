package com.tenxp.concurrent.blockingqueue.consumer;

import java.util.concurrent.BlockingQueue;

/*
 * Consumer는 queue에 요소가 있을시 요소를 꺼낸다.
 * Queue에 요소가 없을 시 wait하게 된다.
 * wait도충 interrupt발생시 InterruptedException발생
 */
public class TakeConsumer implements Runnable {

	protected BlockingQueue queue = null;
	
	public TakeConsumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {

			while (true) {
				System.out.println(Thread.currentThread().getName() + "/" + queue.take());
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
