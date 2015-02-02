package com.tenxp.concurrent.blockingqueue.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Producer는 1초마다 item을 집어넣는다.
 * 정상 삽입시 true
 * 용량이 없는 경우 false  
 * @author psk84
 *
 */
public class OfferProducer implements Runnable {

	protected BlockingQueue queue = null;
	
	public OfferProducer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (true) {
				boolean result = queue.offer("String Offer :: " + ThreadLocalRandom.current().nextInt(0,1000));
				System.out.println("ArrayBlockingQueue Offer Result :: " + result);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
