package com.tenxp.concurrent.blockingqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.tenxp.concurrent.blockingqueue.consumer.ConcurrentLinkedConsumer;
import com.tenxp.concurrent.blockingqueue.producer.ConcurrentLinkedProducer;

public class ConcurrentLinkedQueueExample {

	public static void main(String[] args){
		//Producer : put
		//Consumer : take
		putTakeSample(2, 10, 1000);
	}
	
	public static void putTakeSample(int queueSize, int producerInterval,
			int consumerInterval) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

		ConcurrentLinkedProducer producer = new ConcurrentLinkedProducer(queue, producerInterval);
		
		ConcurrentLinkedConsumer consumer1 = new ConcurrentLinkedConsumer(queue, consumerInterval);
		ConcurrentLinkedConsumer consumer2 = new ConcurrentLinkedConsumer(queue, consumerInterval);
		ConcurrentLinkedConsumer consumer3 = new ConcurrentLinkedConsumer(queue, consumerInterval);
		ConcurrentLinkedConsumer consumer4 = new ConcurrentLinkedConsumer(queue, consumerInterval);
		ConcurrentLinkedConsumer consumer5 = new ConcurrentLinkedConsumer(queue, consumerInterval);

		System.out.println("[putTakeSample]Starting Wait Producer.");
		new Thread(producer).start();
		System.out.println("[putTakeSample ]Starting Take1 Consumer.");
		new Thread(consumer1).start();
		System.out.println("[putTakeSample ]Starting Take2 Consumer.");
		new Thread(consumer2).start();
		System.out.println("[putTakeSample ]Starting Take3 Consumer.");
		new Thread(consumer3).start();
		System.out.println("[putTakeSample ]Starting Take4 Consumer.");
		new Thread(consumer4).start();
		System.out.println("[putTakeSample ]Starting Take5 Consumer.");
		new Thread(consumer5).start();
	}
}
