package com.tenxp.thread.threadpool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
private static ExecutorService executorService;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{

		List<Callable<String>> list = new ArrayList<Callable<String>>();;
		for(int i = 0;i<10;i++) {
            list.add(getWork(i)); 
        }  
		
		executorService = Executors.newFixedThreadPool(3);
		
		List<Future<String>> futureList = executorService.invokeAll
				((Collection<Callable<String>>)list);
	    
        for(Future<String> future : futureList ) {
            System.out.println(future.get());
        }
		executorService.shutdown();
	}
	
	public static Callable<String> getWork(final int i) {
		
		return new Callable<String>() {
			
			public String call() throws Exception {
				if(i == 3) {
					try {
						Thread.sleep(10000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return i +" success";
			}
		};

	}
}
