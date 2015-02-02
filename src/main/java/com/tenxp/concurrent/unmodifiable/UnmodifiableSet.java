package com.tenxp.concurrent.unmodifiable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class UnmodifiableSet {
	public static void unmodifiableSet() {
		System.out.println("========================= unmodifiableSet ========================");
		  
	      Map<Integer , String> list = new HashMap<Integer , String>();
	      
	      list.put(1, "신정호");
	      list.put(2, "전우균");
	      list.put(3, "박승규");
	      list.put(4, "강동호");
	      
	      System.out.println("Initial list: "+ list.keySet());
	      
	      Set<Integer> immutablelist = Collections.unmodifiableSet(list.keySet());
	      
	      new Thread(new Reader(immutablelist)).start();
	      new Thread(new Putter(immutablelist)).start();
	      new Thread(new Remover(immutablelist)).start();
	}
	
	static class Reader implements Runnable{
		private Set<Integer> immutablelist;
		public Reader(Set<Integer> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			System.out.println("item Reader :: "+ this.immutablelist);
		}
	}
	
	static class Putter implements Runnable{
		private Set<Integer> immutablelist;
		public Putter(Set<Integer> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.add(6);
				System.out.println("item Putter :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Putter exception :: "+ e);
			}
		}
	}
	

	static class Remover implements Runnable{
		private Set<Integer> immutablelist;
		public Remover(Set<Integer> immutablelist){
			this.immutablelist = immutablelist;//reference copy
		}
		
		public void run() {
			try{
				this.immutablelist.clear();
				System.out.println("item Remover :: "+ this.immutablelist);
			}catch(Exception e){
				System.out.println("item Remover exception :: "+ e);
			}
		}
	}
}
