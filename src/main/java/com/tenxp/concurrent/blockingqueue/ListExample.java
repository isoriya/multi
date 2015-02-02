package com.tenxp.concurrent.blockingqueue;

import java.util.ArrayList;
import java.util.List;

import com.tenxp.concurrent.blockingqueue.consumer.ListConsumer;
import com.tenxp.concurrent.blockingqueue.producer.ListProducer;

public class ListExample {

	public static void main(String[] args){
		listSample();
	}
	
	public static void listSample(){
		List<String> list = new ArrayList<String>();
		
		ListProducer producer = new ListProducer(list);
		
		ListConsumer consumer1 = new ListConsumer(list);
		ListConsumer consumer2 = new ListConsumer(list);
		
		System.out.println("[listSample]Starting Producer.");
		new Thread(producer).start();
		System.out.println("[listSample ]Starting  Consumer.");
		new Thread(consumer1).start();
		System.out.println("[listSample ]Starting  Consumer.");
		new Thread(consumer2).start();
	}
}
