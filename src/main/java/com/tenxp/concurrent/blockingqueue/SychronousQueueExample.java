package com.tenxp.concurrent.blockingqueue;

import java.util.concurrent.SynchronousQueue;

import com.tenxp.concurrent.blockingqueue.consumer.SychronousConsumer;
import com.tenxp.concurrent.blockingqueue.producer.SychronousProducer;

public class SychronousQueueExample {

	public static void main(String[] args){
		//Producer : put
		//Consumer : take
		putTakeSampel(10, 500, 2000);
		
	}
	
	public static void putTakeSampel(int queueSize, int producerInterval,
			int consumerInterval) {
		SynchronousQueue<String> queue = new SynchronousQueue<String>();

		SychronousProducer producer = new SychronousProducer(queue,
				producerInterval);
		SychronousConsumer consumer = new SychronousConsumer(queue,
				consumerInterval);
		SychronousConsumer consumer2 = new SychronousConsumer(queue,
				consumerInterval);
		
		System.out.println("[putTakeSample]Starting Wait Producer.");
		new Thread(producer).start();
		System.out.println("[putTakeSample ]Starting Take Consumer.");
		new Thread(consumer).start();
		System.out.println("[putTakeSample ]Starting Take Consumer.");
		new Thread(consumer2).start();
	}
}
