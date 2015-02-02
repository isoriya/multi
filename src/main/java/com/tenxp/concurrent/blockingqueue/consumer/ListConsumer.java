package com.tenxp.concurrent.blockingqueue.consumer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListConsumer implements Runnable {

	protected List<String> list = null;
	public ListConsumer(List<String> list) {
		this.list = list;
	}

	public void run() {
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while (true) {
				try {
				String data = list.get(0);
				list.remove(0);
				System.out.println(Thread.currentThread().getName() + "/List Get Result :: " + data);
				Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	}
}
