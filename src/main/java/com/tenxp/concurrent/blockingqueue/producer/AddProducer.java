package com.tenxp.concurrent.blockingqueue.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Producer는 1초마다 item을 집어넣는다.
 * 정상 삽입시 true 
 * 용량이 없을 경우 IllegalStateException 발생한다.
 * 
 * @author psk84
 *
 */
public class AddProducer implements Runnable {

	protected BlockingQueue queue = null;
	public AddProducer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {

			while (true) {
				boolean result = queue.add("String Add :: " + ThreadLocalRandom.current().nextInt(0,1000));
				System.out.println("ArrayBlockingQueue Add Result :: " + result);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			System.out.println("ArrayBlockingQueue Add 용량제한 Exception :: "
					+ e.getStackTrace());
		}
	}
}
