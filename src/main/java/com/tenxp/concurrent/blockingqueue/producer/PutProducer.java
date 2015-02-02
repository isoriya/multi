package com.tenxp.concurrent.blockingqueue.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Producer는 3초마다 item을 집어넣는다.
 * Queue에 용량이 없을경우 wait한다.
 */
public class PutProducer implements Runnable {

	protected BlockingQueue queue = null;
	
	public PutProducer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (true) {
				int data = ThreadLocalRandom.current().nextInt(0,1000);
				System.out.println("Data put :: " + data);
				queue.put("String Put :: " + data);
				Thread.sleep(500);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}