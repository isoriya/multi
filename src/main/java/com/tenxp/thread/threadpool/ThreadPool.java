package com.tenxp.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	public static void main(String[] args){

		
		int count = 0;
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		while (count < 10) {
			// 넣는 순서로 수행되지는 않는다.
			executorService.execute(getWork(count));
//			if(count == 4) {
//				// 바로종료
//				List<Runnable> list = executorService.shutdownNow();
//				System.out.println("미완료 사이즈=" + list.size());
//				// 진행중이던 것 까지 진행 하고 종료
//				executorService.shutdown();
//				break;
//			}
			++count;
		}
		executorService.shutdown();
	}
	
	public static Runnable getWork(int i) {
		
		return () -> {
			
			
			if(i == 3) {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(i);
			}; 
	}
}
