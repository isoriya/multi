package com.tenxp.thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletionService<String> completionService = 
				new ExecutorCompletionService<String>(executorService);
		
		for(int i = 0;i<10;i++) {
            completionService.submit(getWork(i));
        }  
		
		try {
//			for(int i=0; i<10; i++){
			for(int i=0; i<3; i++){
				Future<String> f = completionService.take();
				String tempString = f.get();
				System.out.println(tempString);
			}
			System.out.println("¿Ï·á");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
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
