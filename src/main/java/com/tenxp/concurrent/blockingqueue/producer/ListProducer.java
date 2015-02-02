package com.tenxp.concurrent.blockingqueue.producer;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ListProducer implements Runnable {

	protected List<String> list = null;
	public ListProducer(List<String> list) {
		this.list = list;
	}

	public void run() {
		try {

			while (true) {
				int data = ThreadLocalRandom.current().nextInt(0,1000);
				boolean result = list.add("List String Add :: " + data);
				System.out.println("List Add Result :: " + data);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
