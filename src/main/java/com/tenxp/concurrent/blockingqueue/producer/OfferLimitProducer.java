package com.tenxp.concurrent.blockingqueue.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Producer는 1초마다 item을 집어넣는다.
 * 정상 삽입시 true
 * 용량이 없는 경우 지정한 시간 만큼 wait
 * 시간이 지났는데도 용량이 없으면 false  
 * @author psk84
 *
 */
public class OfferLimitProducer implements Runnable {

	protected BlockingQueue queue = null;
	protected int interval;
	
	public OfferLimitProducer(BlockingQueue queue, int interval) {
		this.queue = queue;
		this.interval = interval;
	}

	public void run() {
		try {
			while (true) {
				boolean result = queue.offer("String Offer Limit :: " + ThreadLocalRandom.current().nextInt(0,1000), 3, TimeUnit.SECONDS);
				System.out.println("ArrayBlockingQueue Offer Result :: " + result);
				Thread.sleep(interval);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
