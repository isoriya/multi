package com.tenxp.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.tenxp.concurrent.blockingqueue.consumer.TakeConsumer;
import com.tenxp.concurrent.blockingqueue.producer.PutProducer;

public class PriorityBlockingQueueExample {

	public static void main(String[] args){

		//Producer : put
		//Consumer : take
		putTakeSample(10);
		
		
	}
	
	public static void putTakeSample(int queueSize) {
		BlockingQueue queue = new PriorityBlockingQueue<String>(queueSize);

		PutProducer producer = new PutProducer(queue);
		
		TakeConsumer consumer1 = new TakeConsumer(queue);
		TakeConsumer consumer2 = new TakeConsumer(queue);

		System.out.println("[putTakeSample]Starting Wait Producer.");
		new Thread(producer).start();
		System.out.println("[putTakeSample ]Starting Take1 Consumer.");
		new Thread(consumer1).start();
		System.out.println("[putTakeSample ]Starting Take2 Consumer.");
		new Thread(consumer2).start();
		
	}
}
