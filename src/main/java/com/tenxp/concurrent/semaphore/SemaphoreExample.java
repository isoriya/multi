package com.tenxp.concurrent.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

	static public void semaphoreDefault(){
		Pool pool = new Pool();
		for(int i = 0 ; i < 20 ; i++){
			new Thread(new User(i, pool)).start();
		}
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static class User implements Runnable{
		int tag = 0;
		Pool poolRef;
		public User(int tag, Pool pool){
			this.tag = tag;
			this.poolRef = pool;
		}
		public void run() {
			try {
				poolRef.work(tag);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	
	public static class Pool {
		   private static final int MAX_AVAILABLE = 5;
		   private final Semaphore available = new java.util.concurrent.Semaphore(MAX_AVAILABLE, true);
		  
		   public int work(int index) throws InterruptedException {
			 System.out.println("=========> work begin : " + index);
		     available.acquire();
		     try {
		    	 Thread.sleep(3000);
				 System.out.println("=========> work ing : " + index);
					 
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
		     available.release();
		     System.out.println("=========> work finish: " + index );
		     return index;
		   }		  
	}
	
	static public void semaforeTryAcquire(){
		PoolTimeOutInterrupted pool = new PoolTimeOutInterrupted();
		for(int i = 0 ; i < 20 ; i++){
			new Thread(new UserTimeOutInterrupted(i, pool)).start();
		}
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static class UserTimeOutInterrupted implements Runnable{
		int tag = 0;
		PoolTimeOutInterrupted poolRef;
		public UserTimeOutInterrupted(int tag, PoolTimeOutInterrupted pool){
			this.tag = tag;
			this.poolRef = pool;
		}
		public void run() {
			try {
				poolRef.work(tag);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}

	public static class PoolTimeOutInterrupted {
		   private static final int MAX_AVAILABLE = 5;
		   private final Semaphore available = new java.util.concurrent.Semaphore(MAX_AVAILABLE, true);
		  
		   public int work(int index) throws InterruptedException {

			 boolean isSync = available.tryAcquire(3000, TimeUnit.MILLISECONDS);
			 System.out.println("=========> work begin : " + index 
					 + "&& try :: " + isSync);
//			 boolean isSync = available.tryAcquire();
//			 System.out.println("=========> work begin : " + index 
//					 + "&& try :: " + isSync);
			 if(!isSync)
				 return -1;
			 
			 try {
				 Thread.sleep(2000);
				 System.out.println("=========> work ing : " + index);
					 
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
		     System.out.println("=========> work finish: " + index);
		     available.release();
		     
		     return index;
		   }		  
	}
}
