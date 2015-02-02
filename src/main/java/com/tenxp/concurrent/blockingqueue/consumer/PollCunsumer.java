package com.tenxp.concurrent.blockingqueue.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Consumer는 queue에 요소가 있을시 요소를 꺼낸다.
 * Queue에 요소가 없을 시 지정한 시간만큼 wait하게 된다.
 * 지정한 시간이 지났지만 요소가 없는경우 null반환
 * @author psk84
 *
 */
public class PollCunsumer implements Runnable {

	protected BlockingQueue queue = null;
	protected int interval;
	public PollCunsumer(BlockingQueue queue, int interval) {
		this.queue = queue;
		this.interval = interval;
	}

	public void run() {
		try {

			while (true) {
				System.out.println(Thread.currentThread().getName() + "/"+ queue.poll(1, TimeUnit.MICROSECONDS));
				Thread.sleep(interval);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

