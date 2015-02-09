package com.tenxp.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	public static void main(String[] args){

		
		int count = 0;
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		while (count < 10) {
			// �ִ� ������ ��������� �ʴ´�.
			executorService.execute(getWork(count));
//			if(count == 4) {
//				// �ٷ�����
//				List<Runnable> list = executorService.shutdownNow();
//				System.out.println("�̿Ϸ� ������=" + list.size());
//				// �������̴� �� ���� ���� �ϰ� ����
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
