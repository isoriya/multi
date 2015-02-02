package com.tenxp.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.tenxp.concurrent.blockingqueue.consumer.PollCunsumer;
import com.tenxp.concurrent.blockingqueue.consumer.TakeConsumer;
import com.tenxp.concurrent.blockingqueue.producer.AddProducer;
import com.tenxp.concurrent.blockingqueue.producer.OfferLimitProducer;
import com.tenxp.concurrent.blockingqueue.producer.OfferProducer;
import com.tenxp.concurrent.blockingqueue.producer.PutProducer;

public class ArrayBlockingQueueExample {

	public static void main(String[] args){
		//Producer : add
		//Consumer : take
//		addTakeSample(2);
		
		//Producer : offer
		//Consumer : take
//		offerTakeSample(2);
		
		//Producer : offer (limit)
		//Consumer : take
//		offerTakeLimitSample(2, 100);
		
		//Producer : put
		//Consumer : poll
//		putPollSample(2, 1000);
		
		//Producer : put
		//Consumer : take
//		putTakeSample(2);
		
		
	}
	
	public static void addTakeSample(int queueSize) {
		BlockingQueue queue = new ArrayBlockingQueue(queueSize);

		AddProducer producer = new AddProducer(queue);
		
		TakeConsumer consumer1 = new TakeConsumer(queue);
		TakeConsumer consumer2 = new TakeConsumer(queue);
		
		System.out.println("[addTakeSample]Starting Add Producer.");
		new Thread(producer).start();
		System.out.println("[addTakeSample ]Starting Take1 Consumer.");
		new Thread(consumer1).start();
		System.out.println("[addTakeSample ]Starting Take2 Consumer.");
		new Thread(consumer2).start();
	}

	public static void offerTakeSample(int queueSize) {
		BlockingQueue queue = new ArrayBlockingQueue(queueSize);

		OfferProducer producer = new OfferProducer(queue);
		
		TakeConsumer consumer1 = new TakeConsumer(queue);
		TakeConsumer consumer2 = new TakeConsumer(queue);
		
		System.out.println("[offerTakeSample]Starting Offer Producer.");
		new Thread(producer).start();
		System.out.println("[offerTakeSample ]Starting Take1 Consumer.");
		new Thread(consumer1).start();
		System.out.println("[offerTakeSample ]Starting Take2 Consumer.");
		new Thread(consumer2).start();
	}
	
	public static void offerTakeLimitSample(int queueSize, int producerInterval) {
		BlockingQueue queue = new ArrayBlockingQueue(queueSize);

		OfferLimitProducer producer = new OfferLimitProducer(queue, producerInterval);
		
		TakeConsumer consumer1 = new TakeConsumer(queue);
		TakeConsumer consumer2 = new TakeConsumer(queue);

		System.out.println("[offerTakeLimitSample]Starting OfferLimit Producer.");
		new Thread(producer).start();
		System.out.println("[offerTakeLimitSample ]Starting Take1 Consumer.");
		new Thread(consumer1).start();
		System.out.println("[offerTakeLimitSample ]Starting Take2 Consumer.");
		new Thread(consumer2).start();
	}

	public static void putPollSample(int queueSize,
			int consumerInterval) {
		BlockingQueue queue = new ArrayBlockingQueue(queueSize);

		PutProducer producer = new PutProducer(queue);
		
		PollCunsumer consumer1 = new PollCunsumer(queue, consumerInterval);
		PollCunsumer consumer2 = new PollCunsumer(queue, consumerInterval);
		
		System.out.println("[putPollSample]Starting Put Producer.");
		new Thread(producer).start();
		System.out.println("[putPollSample]Starting Poll1 Consumer.");
		new Thread(consumer1).start();
		System.out.println("[putPollSample]Starting Poll2 Consumer.");
		new Thread(consumer2).start();
		
	}
	public static void putTakeSample(int queueSize) {
		BlockingQueue queue = new ArrayBlockingQueue(queueSize);

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
